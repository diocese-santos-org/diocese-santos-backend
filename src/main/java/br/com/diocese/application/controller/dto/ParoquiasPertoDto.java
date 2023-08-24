package br.com.diocese.application.controller.dto;

import br.com.diocese.domain.model.Paroquia;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParoquiasPertoDto {
    private Paroquia paroquia;
    private double distancia;
}
