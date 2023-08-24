package br.com.diocese.application.useCase;


import br.com.diocese.application.controller.dto.UsuarioDto;
import br.com.diocese.application.controller.form.UsuarioForm;
import br.com.diocese.domain.contract.useCase.IUsuarioUseCase;
import br.com.diocese.domain.model.Usuario;
import br.com.diocese.infrastructure.config.security.TokenService;
import br.com.diocese.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.util.Optional;


@Service
public class UsuarioUseCase implements IUsuarioUseCase {


    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService tokenService;


    public ResponseEntity<?> obterUsuario(String token) {
        Usuario usuario = usuarioToken(token);
        UsuarioDto usuarioDto = UsuarioDto.converter(usuario);
        return ResponseEntity.ok(usuarioDto);
    }

    public ResponseEntity<String> cadastrarUsuario(UsuarioForm usuarioForm) {
        try {
            if (!validandoEmail(usuarioForm.getEmail()))
                return new ResponseEntity<>("Formato do email invalido", HttpStatus.BAD_REQUEST);

            var usuario = transformarUsuarioForm(usuarioForm);

            usuarioRepository.save(usuario);

            return new ResponseEntity<>("Usuario cadastrado", HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Email ja cadastrado!!", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Algum erro inesperado aconteceu", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity deletarUsuario(String token) {

        var usuario = obterUsuarioPorToken(token);

        usuarioRepository.delete(usuario);

        return ResponseEntity.ok().build();

    }

    public ResponseEntity<?> obterUsuarioPorEmail(String email) {
        if (!validandoEmail(email)) return new ResponseEntity<>("Formato de email invalido!!", HttpStatus.BAD_REQUEST);

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        if (usuarioOptional.isPresent()) {
            return new ResponseEntity<>(usuarioOptional.get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private Long obterIdUsuario(String tokenBearer) {
        String token = tokenService.recuperarToken(tokenBearer);
        return tokenService.getIdUsuario(token);
    }

    private Usuario usuarioToken(String token) {
        token = tokenService.recuperarToken(token);
        return usuarioRepository.getById(tokenService.getIdUsuario(token));
    }

    public Usuario obterUsuarioPorToken(String token) {
        return usuarioToken(token);
    }

    private boolean validandoEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    private Usuario transformarUsuarioForm(UsuarioForm usuarioForm) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioForm.getNome());

        usuario.setEmail(usuarioForm.getEmail().toLowerCase());

        usuario.setSenha(passwordEncoder.encode(usuarioForm.getSenha()));

        usuario.setCpf(usuarioForm.getCpf());

        usuario.setTelefone(usuarioForm.getTelefone());

        return usuario;

    }
}
