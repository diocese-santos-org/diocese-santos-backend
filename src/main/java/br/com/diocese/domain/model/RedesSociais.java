package br.com.diocese.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RedesSociais {
    @Id
    private Long id;

    private String facebook;
    private String instagram;
    private String youtube;
}
