package br.com.diocese.application;

import org.springframework.http.ResponseEntity;

public interface ComunicadoFacede {

    ResponseEntity obterComunicados();

    ResponseEntity obterComunicadoPorId(Long idComunicado);

    ResponseEntity deletarComunicadoPorId(Long idComunicado);
}
