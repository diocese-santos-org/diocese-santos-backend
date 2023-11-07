package br.com.diocese.application;

import br.com.diocese.interfaces.rest.form.ComunicadoForm;
import org.springframework.http.ResponseEntity;

public interface ComunicadoFacede {

    ResponseEntity obterComunicados();

    ResponseEntity obterComunicadoPorId(Long idComunicado);

    ResponseEntity deletarComunicadoPorId(Long idComunicado);

    ResponseEntity cadastrarComunicado(ComunicadoForm comunicadoForm);
}
