package br.com.diocese.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Missa {
    @Id
    private Long id;

    private String segunda;
    private String terca;
    private String quarta;
    private String quinta;
    private String sexta;
    private String sabado;
    private String domingo;
}
