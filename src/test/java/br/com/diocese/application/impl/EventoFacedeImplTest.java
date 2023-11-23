package br.com.diocese.application.impl;

import br.com.diocese.infrastructure.repository.EventoRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EventoFacedeImplTest {

    @InjectMocks
    EventoFacedeImpl eventoFacede;
    @Mock
    EventoRepository eventoRepository;

    @Test
    public void obterEventosEsperando200() {

        when(eventoRepository.findAllByOrderByDataDesc()).thenReturn(Utils.getListEventos());

        var response = eventoFacede.obterEventos();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void obterEventosEsperando204() {

        when(eventoRepository.findAllByOrderByDataDesc()).thenReturn(new ArrayList<>());

        var response = eventoFacede.obterEventos();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }

    @Test
    public void obterEventoPorIdEsperando200() {

        when(eventoRepository.findById(1L)).thenReturn(Optional.of(Utils.getEvento()));

        var response = eventoFacede.obterEventoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void obterEventoPorIdEsperando204() {

        when(eventoRepository.findById(1L)).thenReturn(Optional.empty());

        var response = eventoFacede.obterEventoPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

    }


}