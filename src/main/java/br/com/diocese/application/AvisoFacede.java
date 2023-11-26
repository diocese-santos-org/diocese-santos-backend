package br.com.diocese.application;

import br.com.diocese.interfaces.rest.form.AvisoForm;
import org.springframework.http.ResponseEntity;

public interface AvisoFacede {

    ResponseEntity obterAvisos();

    ResponseEntity obterAvisoPorId(Long idComunicado);

    ResponseEntity deletarAvisoPorId(Long idComunicado);

    ResponseEntity cadastrarAviso(AvisoForm avisoForm);
}
