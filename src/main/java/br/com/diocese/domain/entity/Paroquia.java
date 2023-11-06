package br.com.diocese.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @JoinTable(
            name = "paroquias_cleros",
            joinColumns = @JoinColumn(name = "paroquia_id"),
            inverseJoinColumns = @JoinColumn(name = "clero_id")
    )    private List<Clero> cleros;
}
