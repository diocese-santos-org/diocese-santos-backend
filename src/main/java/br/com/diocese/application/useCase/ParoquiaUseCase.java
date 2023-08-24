package br.com.diocese.application.useCase;

import br.com.diocese.application.controller.dto.ParoquiasPertoDto;
import br.com.diocese.domain.model.Paroquia;
import br.com.diocese.infrastructure.repository.EnderecoRepository;
import br.com.diocese.infrastructure.repository.ParoquiaRepository;
import br.com.diocese.infrastructure.utils.GeolocalizacaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class ParoquiaUseCase {

    //-23.938525, -46.418176, -23.955622, -46.415700 1.9km

    private static final double EARTH_RADIUS_KM = 6371.0;

    @Autowired
    private ParoquiaRepository paroquiaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ResponseEntity retornarParoquias(double latMobile, double longMobile) {

        SortedMap<Double, Paroquia> nearbyObjects = new TreeMap<>();
        List<ParoquiasPertoDto> nearbyObjectsList = new ArrayList<>();

        var paroquias = paroquiaRepository.findAll();

        for (Paroquia paroquia : paroquias) {
            double distance = GeolocalizacaoUtils.calcularDistancia(
                    latMobile, longMobile, paroquia.getEndereco().getLatitude(), paroquia.getEndereco().getLongitude());


            nearbyObjects.put(distance, paroquia);


            int count = 0;
            for (Paroquia paroquiasNerby : nearbyObjects.values()) {
                if (count >= 5) {
                    break;
                }
                nearbyObjectsList.add(new ParoquiasPertoDto(paroquiasNerby, distance));
                count++;
            }
        }

        return ResponseEntity.ok(nearbyObjectsList);
    }

    /*private void cadastrarParoquias() {

        var paroquia = new Paroquia();
        var paroquia1 = new Paroquia();
        var paroquia2 = new Paroquia();


        var endereco = new Endereco();
        endereco.set
        endereco.setLatitude(-23.947322);
        endereco.setLongitude(-46.391601);

        var endereco1 = new Endereco();
        endereco1.setLatitude(-23.966237);
        endereco1.setLongitude(-46.409226);

        var endereco2 = new Endereco();
        endereco2.setLatitude(-23.995436);
        endereco2.setLongitude(-46.419153);

        enderecoRepository.save(endereco);
        enderecoRepository.save(endereco1);
        enderecoRepository.save(endereco2);

        var listaEndereco = enderecoRepository.findAll();

        paroquia.setEndereco(listaEndereco.get(0));
        paroquia1.setEndereco(listaEndereco.get(1));
        paroquia2.setEndereco(listaEndereco.get(2));

        paroquiaRepository.save(paroquia);
        paroquiaRepository.save(paroquia1);
        paroquiaRepository.save(paroquia2);


    }*/
}
