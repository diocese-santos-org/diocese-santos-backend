package br.com.diocese.application.impl;

import br.com.diocese.infrastructure.repository.ComunicadoRepository;
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
public class ComunicadoFacedeImplTest {

    @Mock
    ComunicadoRepository comunicadoRepository;

    @InjectMocks
    ComunicadoFacedeImpl comunicadoFacede;

    @Test
    public void obterComunicadosComObjetosEsperandoStatus200() {

        when(comunicadoRepository.findAll()).thenReturn(Utils.getListComunicados());
        var response = comunicadoFacede.obterComunicados();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void obterComunicadosSemObjetosEsperandoStatus204() {

        when(comunicadoRepository.findAll()).thenReturn(new ArrayList<>());
        var response = comunicadoFacede.obterComunicados();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }


    @Test
    public void obterComunicadosPorIdEsperando200() {

        when(comunicadoRepository.findById(1L)).thenReturn(Optional.of(Utils.getComunicado()));
        var response = comunicadoFacede.obterComunicadoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void obterComunicadosPorIdEsperando204() {

        when(comunicadoRepository.findById(1L)).thenReturn(Optional.empty());
        var response = comunicadoFacede.obterComunicadoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }

    @Test
    public void deletarComunicadosPorIdEsperando200() {

        when(comunicadoRepository.existsById(1L)).thenReturn(true);
        doNothing().when(comunicadoRepository).deleteById(1L);

        var response = comunicadoFacede.deletarComunicadoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void deletarComunicadosPorIdEsperando204() {

        when(comunicadoRepository.existsById(1L)).thenReturn(false);

        var response = comunicadoFacede.deletarComunicadoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);

    }
}