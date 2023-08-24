package br.com.diocese.application.useCase;

import br.com.diocese.application.controller.UsuarioControllerImpl;
import br.com.diocese.domain.model.Usuario;
import br.com.diocese.infrastructure.config.security.TokenService;
import br.com.diocese.infrastructure.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static br.com.diocese.utils.Utils.retornaUsuario;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UsuarioUseCaseImplTest {

    @InjectMocks
    UsuarioUseCaseImpl usuarioUseCase;

    @Mock
    TokenService tokenService;

    @Mock
    UsuarioRepository usuarioRepository;

    @Test
    public void testarSimples() {

        when(usuarioRepository.getById(any())).thenReturn(retornaUsuario());
        when(tokenService.recuperarToken(anyString())).thenReturn("iadsikdsikadsoisdio");

        var response = usuarioUseCase.obterUsuario("Bearer iadsikdsikadsoisdio");

        Assertions.assertNotEquals("", response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());



    }

}