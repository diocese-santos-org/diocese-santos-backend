package br.com.diocese.interfaces.rest.form;

import lombok.Data;

@Data
public class EventoForm {
    private String titulo;
    private String descricao;
    private String horario;
    private String data;
    private String local;
}
