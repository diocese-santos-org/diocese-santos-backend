package br.com.diocese.application.impl;

import br.com.diocese.application.EventoFacede;
import br.com.diocese.domain.entity.Evento;
import br.com.diocese.infrastructure.repository.EventoRepository;
import br.com.diocese.interfaces.rest.form.EventoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventoFacedeImpl implements EventoFacede {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public ResponseEntity obterEventos() {
        try {
            var eventos = eventoRepository.findAllByOrderByDataDesc();

            if (eventos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(eventos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity obterEventoPorId(Long idEvento) {
        try {
            var evento = eventoRepository.findById(idEvento);

            if (evento.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(evento);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity deletarEventoPorId(Long idEvento) {
        try {
            if (eventoRepository.existsById(idEvento)) {
                eventoRepository.deleteById(idEvento);
                return ResponseEntity.ok("Deletado com sucesso!");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity cadastrarEvento(EventoForm eventoForm) {
        try {
            Evento evento = Evento.formToModel(eventoForm);

            Evento eventoCriado = eventoRepository.save(evento);
            return ResponseEntity.status(HttpStatus.CREATED).body(eventoCriado);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
