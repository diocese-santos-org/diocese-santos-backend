package br.com.diocese.domain.entity;

import br.com.diocese.interfaces.rest.form.AvisoForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aviso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    public static Aviso formToModel(AvisoForm avisoForm){
        Aviso aviso = new Aviso();
        aviso.setTitulo(avisoForm.getTitulo());
        aviso.setDescricao(avisoForm.getDescricao());
        return aviso;
    }
}
