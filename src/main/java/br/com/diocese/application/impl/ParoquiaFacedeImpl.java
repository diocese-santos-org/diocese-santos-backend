package br.com.diocese.application.impl;

import br.com.diocese.application.ParoquiaFacede;
import br.com.diocese.domain.entity.Endereco;
import br.com.diocese.interfaces.rest.dto.ParoquiasPertoDto;
import br.com.diocese.domain.entity.Paroquia;
import br.com.diocese.infrastructure.repository.EnderecoRepository;
import br.com.diocese.infrastructure.repository.ParoquiaRepository;
import br.com.diocese.infrastructure.utils.GeolocalizacaoUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParoquiaFacedeImpl implements ParoquiaFacede {

    //-23.938525, -46.418176, -23.955622, -46.415700 1.9km

    @Autowired
    private ParoquiaRepository paroquiaRepository;

    public ResponseEntity<List<ParoquiasPertoDto>> obterParoquiasGeoLocalizacao(double latMobile, double longMobile) {
        SortedMap<Double, Paroquia> nearbyObjects = new TreeMap<>();
        List<ParoquiasPertoDto> nearbyObjectsList = new ArrayList<>();

        var paroquias = paroquiaRepository.findAll();

        for (Paroquia paroquia : paroquias) {
            double distance = GeolocalizacaoUtils.calcularDistancia(
                    latMobile, longMobile, paroquia.getEndereco().getLatitude(), paroquia.getEndereco().getLongitude());

            nearbyObjects.put(distance, paroquia);
        }
        for (Map.Entry<Double, Paroquia> entry : nearbyObjects.entrySet()){
            nearbyObjectsList.add(new ParoquiasPertoDto(entry.getValue(), entry.getKey()));
        }
        return ResponseEntity.ok(nearbyObjectsList);
    }

    @Override
    public ResponseEntity obterParoquiaPorId(String paroquiaId) {
       var paroquia = paroquiaRepository.findById(Long.valueOf(paroquiaId));

       if(paroquia.isPresent()) {
           return ResponseEntity.ok(paroquia.get());
       }
       return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity obterParoquias() {
        var paroquias = paroquiaRepository.findAll();
        return ResponseEntity.ok(paroquias);
    }

}
