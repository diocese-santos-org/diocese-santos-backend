package br.com.diocese.domain.contract.controller;


import br.com.diocese.application.controller.dto.TokenDto;
import br.com.diocese.application.controller.form.LoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AutenticacaoController {

    public ResponseEntity<TokenDto> autenticarLogin(@RequestBody LoginForm loginForm);

}
