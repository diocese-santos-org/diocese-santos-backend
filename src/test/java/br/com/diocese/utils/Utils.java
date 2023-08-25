package br.com.diocese.utils;

import br.com.diocese.domain.entity.Usuario;

public class Utils {

    public final static String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
    public static final String TOKEN_TRATADO = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
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
