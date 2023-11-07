package br.com.diocese.application.impl;

import br.com.diocese.application.ComunicadoFacede;
import br.com.diocese.domain.entity.Comunicado;
import br.com.diocese.infrastructure.repository.ComunicadoRepository;
import br.com.diocese.interfaces.rest.form.ComunicadoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComunicadosFacedeImpl implements ComunicadoFacede {

    @Autowired
    ComunicadoRepository comunicadoRepository;

    @Override
    public ResponseEntity obterComunicados() {
        try {
            var comunicados = comunicadoRepository.findAll();

            if (comunicados.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(comunicados);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity obterComunicadoPorId(Long idComunicado) {
        try {
            var comunicados = comunicadoRepository.findById(idComunicado);

            if (comunicados.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(comunicados);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity deletarComunicadoPorId(Long idComunicado) {
        try {
            if (comunicadoRepository.existsById(idComunicado)) {
                comunicadoRepository.deleteById(idComunicado);
                return ResponseEntity.ok("Deletado com sucesso!");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity cadastrarComunicado(ComunicadoForm comunicadoForm) {
        try {
            Comunicado comunicado = Comunicado.formToModel(comunicadoForm);

            Comunicado comunicadoCriado = comunicadoRepository.save(comunicado);
            return ResponseEntity.status(HttpStatus.CREATED).body(comunicadoCriado);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
