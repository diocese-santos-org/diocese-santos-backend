package br.com.diocese.application.impl;

import br.com.diocese.infrastructure.repository.AvisoRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import utils.Utils;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AvisoFacedeImplTest {

    @Mock
    AvisoRepository avisoRepository;

    @InjectMocks
    AvisoFacedeImpl avisoFacede;

    @Test
    public void obterComunicadosComObjetosEsperandoStatus200() {

        when(avisoRepository.findAll()).thenReturn(Utils.getListAvisos());
        var response = avisoFacede.obterAvisos();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void obterComunicadosSemObjetosEsperandoStatus204() {

        when(avisoRepository.findAll()).thenReturn(new ArrayList<>());
        var response = avisoFacede.obterAvisos();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }


    @Test
    public void obterComunicadosPorIdEsperando200() {

        when(avisoRepository.findById(1L)).thenReturn(Optional.of(Utils.getAviso()));
        var response = avisoFacede.obterAvisoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void obterComunicadosPorIdEsperando204() {

        when(avisoRepository.findById(1L)).thenReturn(Optional.empty());
        var response = avisoFacede.obterAvisoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }

    @Test
    public void deletarComunicadosPorIdEsperando200() {

        when(avisoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(avisoRepository).deleteById(1L);

        var response = avisoFacede.deletarAvisoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void deletarComunicadosPorIdEsperando204() {

        when(avisoRepository.existsById(1L)).thenReturn(false);

        var response = avisoFacede.deletarAvisoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);

    }
}