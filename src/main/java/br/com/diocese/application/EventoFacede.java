package br.com.diocese.application;

import br.com.diocese.interfaces.rest.form.EventoForm;
import org.springframework.http.ResponseEntity;

public interface EventoFacede {
    ResponseEntity obterEventos();

    ResponseEntity obterEventoPorId(Long idEvento);

    ResponseEntity deletarEventoPorId(Long idEvento);

    ResponseEntity cadastrarEvento(EventoForm eventoForm);
}
