package br.com.diocese.application.controller;


import br.com.diocese.application.controller.form.UsuarioForm;
import br.com.diocese.domain.contract.controller.IUsuarioController;
import br.com.diocese.domain.contract.useCase.IUsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController implements IUsuarioController {

    @Autowired
    IUsuarioUseCase IUsuarioUseCase;

    @GetMapping
    public ResponseEntity<?> obterUsuario(@RequestHeader(value = "Authorization") String token) {

        return IUsuarioUseCase.obterUsuario(token);

    }

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioForm usuarioForm) {

        return IUsuarioUseCase.cadastrarUsuario(usuarioForm);

    }

    @DeleteMapping
    public ResponseEntity deletarUsuario(@RequestHeader(value = "Authorization") String token) {

        return IUsuarioUseCase.deletarUsuario(token);

    }
}
