package br.com.diocese.application;

import br.com.diocese.interfaces.rest.form.UsuarioForm;
import org.springframework.http.ResponseEntity;

public interface UsuarioFacede {

    ResponseEntity<?> obterUsuario(String token);

    ResponseEntity<String> cadastrarUsuario(UsuarioForm usuarioForm);

    ResponseEntity deletarUsuario(String token);

}
