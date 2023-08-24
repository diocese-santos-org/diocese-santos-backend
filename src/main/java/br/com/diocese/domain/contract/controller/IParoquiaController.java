package br.com.diocese.domain.contract.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IParoquiaController {

    ResponseEntity<?> obterParoquiasPerto(@RequestParam double latitude, @RequestParam double longitude);

}
