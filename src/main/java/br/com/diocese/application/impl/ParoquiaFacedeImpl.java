package br.com.diocese.application.impl;

import br.com.diocese.application.ParoquiaFacede;
import br.com.diocese.domain.entity.Paroquia;
import br.com.diocese.infrastructure.repository.ParoquiaRepository;
import br.com.diocese.infrastructure.utils.GeolocalizacaoUtils;
import br.com.diocese.interfaces.rest.dto.ParoquiasPertoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParoquiaFacedeImpl implements ParoquiaFacede {

    //-23.938525, -46.418176, -23.955622, -46.415700 1.9km

    @Autowired
    private ParoquiaRepository paroquiaRepository;

    @Override
    public ResponseEntity obterParoquias() {
        try {
            var paroquias = paroquiaRepository.findAll();

            if (paroquias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(paroquias);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity obterParoquiaPorId(Long idParoquia) {
        try {
            var paroquia = paroquiaRepository.findById(idParoquia);

            if (paroquia.isPresent()) {
                return ResponseEntity.ok(paroquia.get());
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity obterParoquiasGeoLocalizacao(double latMobile, double longMobile) {
        try {
            SortedMap<Double, Paroquia> nearbyObjects = new TreeMap<>();
            List<ParoquiasPertoDto> nearbyObjectsList = new ArrayList<>();

            var paroquias = paroquiaRepository.findAll();

            for (Paroquia paroquia : paroquias) {
                double distance = GeolocalizacaoUtils.calcularDistancia(
                        latMobile, longMobile, paroquia.getEndereco().getLatitude(), paroquia.getEndereco().getLongitude());

                nearbyObjects.put(distance, paroquia);
            }
            for (Map.Entry<Double, Paroquia> entry : nearbyObjects.entrySet()) {
                nearbyObjectsList.add(new ParoquiasPertoDto(entry.getValue(), entry.getKey()));
            }
            return ResponseEntity.ok(nearbyObjectsList);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
