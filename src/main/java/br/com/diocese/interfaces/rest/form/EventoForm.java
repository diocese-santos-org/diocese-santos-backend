package br.com.diocese.interfaces.rest.form;

import lombok.Data;

import java.sql.Date;

@Data
public class EventoForm {
    private String titulo;
    private String descricao;
    private String horario;
    private Date data;
    private String local;
}
