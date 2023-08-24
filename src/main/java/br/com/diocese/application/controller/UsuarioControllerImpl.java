package br.com.diocese.application.controller;


import br.com.diocese.application.controller.form.UsuarioForm;
import br.com.diocese.domain.contract.controller.UsuarioController;
import br.com.diocese.domain.contract.useCase.UsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @GetMapping
    public ResponseEntity<?> obterUsuario(@RequestHeader(value = "Authorization") String token) {

        return usuarioUseCase.obterUsuario(token);

    }

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioForm usuarioForm) {

        return usuarioUseCase.cadastrarUsuario(usuarioForm);

    }

    @DeleteMapping
    public ResponseEntity deletarUsuario(@RequestHeader(value = "Authorization") String token) {

        return usuarioUseCase.deletarUsuario(token);

    }
}
