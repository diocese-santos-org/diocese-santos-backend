package br.com.diocese.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Paroquia {

    @Id
    private Long id;
    private String nome;

    @OneToOne
    private Endereco endereco;

    private String telefone;

    private String email;

    private String secretaria;
    @OneToOne
    private Missa missas;

    @OneToOne
    private RedesSociais redesSociais;

}
