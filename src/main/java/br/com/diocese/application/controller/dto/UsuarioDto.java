package br.com.diocese.application.controller.dto;


import br.com.diocese.domain.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;


    public static UsuarioDto converter(Usuario usuario) {
        return new UsuarioDto(usuario.getNome(), usuario.getEmail(), "Senha não pode ser retornada", usuario.getCpf(), usuario.getTelefone());
    }

    public UsuarioDto(String nome, String email, String senha, String cpf, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public void converterAtualizacoes(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        if (this.senha == null) {

            this.setSenha("Senha inalterada");
        } else this.setSenha("Senha alterada com sucesso!!");
    }
}
