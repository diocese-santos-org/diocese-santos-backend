package br.com.diocese.domain.entity;

import br.com.diocese.interfaces.rest.form.ComunicadoForm;
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
public class Comunicado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    public static Comunicado formToModel(ComunicadoForm comunicadoForm){
        Comunicado comunicado = new Comunicado();
        comunicado.setTitulo(comunicadoForm.getTitulo());
        comunicado.setDescricao(comunicadoForm.getDescricao());
        return comunicado;
    }
}
