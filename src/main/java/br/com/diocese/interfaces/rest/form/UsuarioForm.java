package br.com.diocese.interfaces.rest.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioForm {

    @NotBlank(message = "Nome é obrigatorio!!")
    @NotNull
    @Length(min = 3, max = 35, message = "Minimo de 3 letras e maximo de 35!!")
    private String nome;

    @NotNull
    @NotBlank(message = "Email é obrigatorio!!")
    @Length(min = 10, message = "Minimo 5 caracteres!!")
    private String email;

    @NotBlank(message = "Senha é obrigatorio!!")
    @NotNull
    @Length(min = 7, message = "Senha só é valida com mais de 7 caractres")
    private String senha;

    private String cpf;
    private String telefone;

}
