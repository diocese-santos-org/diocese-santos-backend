package br.com.diocese.application.controller;

import br.com.diocese.application.useCase.ParoquiaUseCase;
import br.com.diocese.domain.contract.controller.IParoquiaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paroquia")
public class ParoquiaController implements IParoquiaController {

    @Autowired
    ParoquiaUseCase paroquiaUseCase;

    @Override
    @GetMapping
    public ResponseEntity<?> obterParoquiasPerto(double latitude, double longitude) {
        return paroquiaUseCase.retornarParoquias(latitude, longitude);
    }

}
