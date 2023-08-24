package br.com.diocese.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id
    private Long id;

    private String enderecoCompleto;
    private String cidade;
    private String estado;
    private String cep;
    private String latitude;

    private String longitude;
}
