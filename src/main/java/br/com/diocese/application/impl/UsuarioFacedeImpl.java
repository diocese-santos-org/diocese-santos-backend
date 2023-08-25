package br.com.diocese.application.impl;


import br.com.diocese.application.UsuarioFacede;
import br.com.diocese.domain.entity.Usuario;
import br.com.diocese.domain.mapper.UsuarioMapper;
import br.com.diocese.infrastructure.config.security.TokenService;
import br.com.diocese.infrastructure.repository.UsuarioRepository;
import br.com.diocese.interfaces.rest.dto.UsuarioDto;
import br.com.diocese.interfaces.rest.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.diocese.infrastructure.utils.EmailValidator.validandoEmail;


@Service
public class UsuarioFacedeImpl implements UsuarioFacede {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper usuarioMapper;

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

            var usuario = usuarioMapper.formToEntity(usuarioForm);

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

    private Usuario usuarioToken(String token) {
        token = tokenService.recuperarToken(token);
        return usuarioRepository.getById(tokenService.getIdUsuario(token));
    }

    public Usuario obterUsuarioPorToken(String token) {
        return usuarioToken(token);
    }

}
