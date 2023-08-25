package br.com.diocese.domain.mapper;

import br.com.diocese.domain.entity.Usuario;
import br.com.diocese.interfaces.rest.form.UsuarioForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario formToEntity(UsuarioForm usuarioForm) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioForm.getNome());

        usuario.setEmail(usuarioForm.getEmail().toLowerCase());

        usuario.setSenha(passwordEncoder.encode(usuarioForm.getSenha()));

        usuario.setCpf(usuarioForm.getCpf());

        usuario.setTelefone(usuarioForm.getTelefone());

        return usuario;

    }
}
