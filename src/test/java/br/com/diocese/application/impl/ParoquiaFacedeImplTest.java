package br.com.diocese.application.impl;

import br.com.diocese.infrastructure.repository.ParoquiaRepository;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)

public class ParoquiaFacedeImplTest {

    @InjectMocks
    ParoquiaFacedeImpl paroquiaFacede;

    @Mock
    ParoquiaRepository paroquiaRepository;

    @Test
    public void obterParoquiasEsperando200() {
        when(paroquiaRepository.findAll()).thenReturn(Utils.getListParoquias());
        var response = paroquiaFacede.obterParoquias();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void obterParoquiasEsperando204() {
        when(paroquiaRepository.findAll()).thenReturn(new ArrayList<>());
        var response = paroquiaFacede.obterParoquias();

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void obterParoquiaPorIdEsperando200() {
        when(paroquiaRepository.findById(1L)).thenReturn(Optional.of(Utils.getParoquia()));
        var response = paroquiaFacede.obterParoquiaPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void obterParoquiaPorIdEsperando204() {
        when(paroquiaRepository.findById(1L)).thenReturn(Optional.empty());
        var response = paroquiaFacede.obterParoquiaPorId(1L);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}