package br.com.diocese.interfaces.rest.controller;

import br.com.diocese.application.impl.AvisoFacedeImpl;
import br.com.diocese.infrastructure.config.security.TokenService;
import br.com.diocese.interfaces.rest.form.AvisoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avisos")
public class AvisoController {

    @Autowired
    AvisoFacedeImpl comunicadoFacede;

    @Autowired
    TokenService tokenService;

    @GetMapping
    public ResponseEntity obterAvisos(@RequestHeader("Authorization") String token) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.obterAvisos();
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @GetMapping("/{idEvento}")
    public ResponseEntity obterAvisoPorId(@RequestHeader("Authorization") String token, @PathVariable Long idEvento) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.obterAvisoPorId(idEvento);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @PostMapping
    public ResponseEntity cadastrarAviso(@RequestHeader("Authorization") String token, @RequestBody AvisoForm avisoForm) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.cadastrarAviso(avisoForm);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @DeleteMapping("/{idEvento}")
    public ResponseEntity deletarAvisoPorId(@RequestHeader("Authorization") String token, @PathVariable Long idEvento) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.deletarAvisoPorId(idEvento);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }
}
