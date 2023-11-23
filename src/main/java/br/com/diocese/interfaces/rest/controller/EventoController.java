package br.com.diocese.interfaces.rest.controller;

import br.com.diocese.application.impl.EventoFacedeImpl;
import br.com.diocese.infrastructure.config.security.TokenService;
import br.com.diocese.interfaces.rest.form.EventoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoFacedeImpl eventoFacede;

    @Autowired
    TokenService tokenService;

    @GetMapping
    public ResponseEntity obterEventos(@RequestHeader("Authorization") String token) {

        if (tokenService.isTokenValido(token)) {
            return eventoFacede.obterEventos();
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @GetMapping("/{idEvento}")
    public ResponseEntity obterEventoPorId(@RequestHeader("Authorization") String token, @PathVariable Long idEvento) {

        if (tokenService.isTokenValido(token)) {
            return eventoFacede.obterEventoPorId(idEvento);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @PostMapping
    public ResponseEntity cadastrarEvento(@RequestHeader("Authorization") String token, @RequestBody EventoForm eventoForm) {

        if (tokenService.isTokenValido(token)) {
            return eventoFacede.cadastrarEvento(eventoForm);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }

    @DeleteMapping("/{idEvento}")
    public ResponseEntity deletarComunicadoPorId(@RequestHeader("Authorization") String token, @PathVariable Long idEvento) {

        if (tokenService.isTokenValido(token)) {
            return eventoFacede.deletarEventoPorId(idEvento);
        }
        return ResponseEntity.status(401).body("Acesso não autorizado");
    }
}
