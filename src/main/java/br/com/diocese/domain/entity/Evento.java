package br.com.diocese.domain.entity;

import br.com.diocese.interfaces.rest.form.EventoForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String horario;
    private Date data;
    private String local;

    public static Evento formToModel(EventoForm eventoForm) {
        Evento evento = new Evento();
        evento.setTitulo(eventoForm.getTitulo());
        evento.setDescricao(eventoForm.getDescricao());
        evento.setHorario(eventoForm.getHorario());
        evento.setData(eventoForm.getData());
        evento.setLocal(eventoForm.getLocal());
        return evento;
    }
}
