package br.com.diocese.interfaces.rest.controller;

import br.com.diocese.application.impl.ComunicadoFacedeImpl;
import br.com.diocese.infrastructure.config.security.TokenService;
import br.com.diocese.interfaces.rest.form.ComunicadoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comunicados")
public class ComunicadoController {

    @Autowired
    ComunicadoFacedeImpl comunicadoFacede;

    @Autowired
    TokenService tokenService;

    @GetMapping
    public ResponseEntity obterComunicados(@RequestHeader("Authorization") String token) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.obterComunicados();
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @GetMapping("/{idComunicado}")
    public ResponseEntity obterComunicadoPorId(@RequestHeader("Authorization") String token, @PathVariable Long idComunicado) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.obterComunicadoPorId(idComunicado);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @PostMapping
    public ResponseEntity cadastrarComunicado(@RequestHeader("Authorization") String token, @RequestBody ComunicadoForm comunicadoForm) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.cadastrarComunicado(comunicadoForm);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @DeleteMapping("/{idComunicado}")
    public ResponseEntity deletarComunicadoPorId(@RequestHeader("Authorization") String token, @PathVariable Long idComunicado) {

        if (tokenService.isTokenValido(token)) {
            return comunicadoFacede.deletarComunicadoPorId(idComunicado);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }
}
