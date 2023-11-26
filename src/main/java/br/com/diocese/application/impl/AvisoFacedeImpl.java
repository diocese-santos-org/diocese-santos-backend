package br.com.diocese.application.impl;

import br.com.diocese.application.AvisoFacede;
import br.com.diocese.domain.entity.Aviso;
import br.com.diocese.infrastructure.repository.AvisoRepository;
import br.com.diocese.interfaces.rest.form.AvisoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AvisoFacedeImpl implements AvisoFacede {

    @Autowired
    AvisoRepository avisoRepository;

    @Override
    public ResponseEntity obterAvisos() {
        try {
            var comunicados = avisoRepository.findAllByOrderByIdDesc();

            if (comunicados.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(comunicados);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity obterAvisoPorId(Long idComunicado) {
        try {
            var comunicado = avisoRepository.findById(idComunicado);

            if (comunicado.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(comunicado);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity deletarAvisoPorId(Long idComunicado) {
        try {
            if (avisoRepository.existsById(idComunicado)) {
                avisoRepository.deleteById(idComunicado);
                return ResponseEntity.ok("Deletado com sucesso!");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity cadastrarAviso(AvisoForm avisoForm) {
        try {
            Aviso aviso = Aviso.formToModel(avisoForm);

            Aviso avisoCriado = avisoRepository.save(aviso);
            return ResponseEntity.status(HttpStatus.CREATED).body(avisoCriado);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
