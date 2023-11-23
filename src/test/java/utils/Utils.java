package utils;

import br.com.diocese.domain.entity.Comunicado;
import br.com.diocese.domain.entity.Evento;
import br.com.diocese.domain.entity.Paroquia;

import java.util.ArrayList;
import java.util.List;

public class Utils {


    public static Comunicado getComunicado() {
        return new Comunicado(1L, "Titulo", "Descrição");
    }

    public static List<Comunicado> getListComunicados() {
        var lista = new ArrayList<Comunicado>();

        lista.add(getComunicado());
        lista.add(getComunicado());
        lista.add(getComunicado());

        return lista;
    }

    public static Evento getEvento() {
        return new Evento(1L, "Titulo", "Descricao", "Horario", null, "local");
    }

    public static List<Evento> getListEventos() {
        var lista = new ArrayList<Evento>();

        lista.add(getEvento());
        lista.add(getEvento());
        lista.add(getEvento());

        return lista;

    }

    public static Paroquia getParoquia() {
        return new Paroquia(1L, null, null, null, null, null, null, null, null, null);
    }

    public static List<Paroquia> getListParoquias() {
        var lista = new ArrayList<Paroquia>();

        lista.add(getParoquia());
        lista.add(getParoquia());
        lista.add(getParoquia());

        return lista;
    }

}
