package br.com.diocese.utils;

import br.com.diocese.domain.model.Usuario;

public class Utils {

    public static Usuario retornaUsuario(){
        var usuario = new Usuario();

        usuario.setCpf("13293219");
        usuario.setNome("Leo");
        usuario.setEmail("leo@gmail.com");
        usuario.setId(1L);
        usuario.setTelefone("13929132");

        return usuario;
    }
}
