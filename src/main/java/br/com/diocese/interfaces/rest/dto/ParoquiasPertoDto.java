package br.com.diocese.interfaces.rest.dto;

import br.com.diocese.domain.entity.Paroquia;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParoquiasPertoDto {
    private Paroquia paroquia;
    private double distancia;
}
