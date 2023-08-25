package br.com.diocese.application;

import org.springframework.http.ResponseEntity;

public interface ParoquiaFacede {

    ResponseEntity retornarParoquias(double latMobile, double longMobile);

}
