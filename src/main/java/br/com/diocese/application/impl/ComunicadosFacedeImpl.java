package br.com.diocese.application.impl;

import br.com.diocese.application.ComunicadoFacede;
import br.com.diocese.infrastructure.repository.ComunicadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComunicadosFacedeImpl implements ComunicadoFacede {

    @Autowired
    ComunicadosRepository comunicadosRepository;

    @Override
    public ResponseEntity obterComunicados() {
        var comunicados = comunicadosRepository.findAll();

        if (comunicados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comunicados);
    }

    @Override
    public ResponseEntity obterComunicadoPorId(Long idComunicado) {
        var comunicados = comunicadosRepository.findById(idComunicado);

        if (comunicados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comunicados);
    }

    @Override
    public ResponseEntity deletarComunicadoPorId(Long idComunicado) {

        if (comunicadosRepository.existsById(idComunicado)) {
            comunicadosRepository.deleteById(idComunicado);
            return ResponseEntity.ok("Deletado com sucesso!");
        }
        return ResponseEntity.notFound().build();
    }
}
