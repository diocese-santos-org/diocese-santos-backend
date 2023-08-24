package br.com.diocese.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Paroquia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
