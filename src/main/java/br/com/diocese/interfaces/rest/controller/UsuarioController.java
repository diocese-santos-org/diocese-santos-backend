package br.com.diocese.interfaces.rest.controller;


import br.com.diocese.application.UsuarioFacede;
import br.com.diocese.interfaces.rest.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioFacede usuarioFacede;

    @GetMapping
    public ResponseEntity<?> obterUsuario(@RequestHeader(value = "Authorization") String token) {

        return usuarioFacede.obterUsuario(token);

    }

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioForm usuarioForm) {

        return usuarioFacede.cadastrarUsuario(usuarioForm);

    }

    @DeleteMapping
    public ResponseEntity deletarUsuario(@RequestHeader(value = "Authorization") String token) {

        return usuarioFacede.deletarUsuario(token);

    }
}
