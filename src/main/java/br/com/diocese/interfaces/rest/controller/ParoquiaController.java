package br.com.diocese.interfaces.rest.controller;

import br.com.diocese.application.impl.ParoquiaFacedeImpl;
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
    ParoquiaFacedeImpl paroquiaFacedeImpl;

    @Override
    @GetMapping
    public ResponseEntity<?> obterParoquiasPerto(double latitude, double longitude) {
        return paroquiaFacedeImpl.retornarParoquias(latitude, longitude);
    }

}
