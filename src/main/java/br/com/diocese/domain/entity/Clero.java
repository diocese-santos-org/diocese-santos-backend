package br.com.diocese.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Clero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String urlSite;

    @JsonIgnore
    @ManyToMany(mappedBy = "cleros")
    private List<Paroquia> paroquias = new ArrayList<>();


}
