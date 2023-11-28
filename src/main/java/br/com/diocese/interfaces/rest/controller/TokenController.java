package br.com.diocese.interfaces.rest.controller;

import br.com.diocese.infrastructure.config.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @GetMapping
    public String gerarToken() {
        return tokenService.generateToken();
    }

}
