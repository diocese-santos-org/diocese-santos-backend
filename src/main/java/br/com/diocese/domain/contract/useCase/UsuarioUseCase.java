package br.com.diocese.domain.contract.useCase;

import br.com.diocese.application.controller.form.UsuarioForm;
import org.springframework.http.ResponseEntity;

public interface UsuarioUseCase {

    public ResponseEntity<String> cadastrarUsuario(UsuarioForm usuarioForm);

    public ResponseEntity<?> deletarUsuario(String token);

    public ResponseEntity<?> obterUsuario(String token);

}
