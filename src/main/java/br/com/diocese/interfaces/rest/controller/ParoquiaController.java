package br.com.diocese.interfaces.rest.controller;

import br.com.diocese.application.impl.ParoquiaFacedeImpl;
import br.com.diocese.infrastructure.config.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paroquias")
public class ParoquiaController {

    @Autowired
    ParoquiaFacedeImpl paroquiaFacedeImpl;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/geo")
    public ResponseEntity obterParoquiasGeoLocalizacao(@RequestHeader("Authorization") String token, double latitude, double longitude) {

        if (tokenService.isTokenValido(token)) {
            return paroquiaFacedeImpl.obterParoquiasGeoLocalizacao(latitude, longitude);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @GetMapping
    public ResponseEntity obterTodasParoquias(@RequestHeader("Authorization") String token) {

        if (tokenService.isTokenValido(token)) {
            return paroquiaFacedeImpl.obterParoquias();
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @GetMapping("/{idParoquia}")
    public ResponseEntity obterParoquiaPorId(@RequestHeader("Authorization") String token, @PathVariable Long idParoquia) {

        if (tokenService.isTokenValido(token)) {
            return paroquiaFacedeImpl.obterParoquiaPorId(idParoquia);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

}
