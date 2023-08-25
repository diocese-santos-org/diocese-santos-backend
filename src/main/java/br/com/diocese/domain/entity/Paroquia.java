package br.com.diocese.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private String urlSite;

    @OneToOne
    private Missa missas;

    @OneToOne
    private RedesSociais redesSociais;

    @ManyToMany
    private List<Clero> cleros;


}
