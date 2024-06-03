package br.com.nveladio.junit5_curso.infra.service;


import br.com.nveladio.junit5_curso.domain.Usuario;
import br.com.nveladio.junit5_curso.domain.builders.UsuarioBuilder;
import br.com.nveladio.junit5_curso.repositories.UsuarioRepository;
import br.com.nveladio.junit5_curso.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;


public class UsuarioServiceTest {
    private UsuarioService service;

    @Test
    public void deveRetornarEmptyQuandoUsuarioInexistente() {
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        Mockito.when(repository.getUserByEmail("mail@mail.com")).thenReturn(Optional.empty());

        Optional<Usuario> user = service.getUserByEmail("mail@gmail.com");
        Assertions.assertTrue(user.isEmpty());

    }

    @Test
    public void deveRetornarUsuarioPorEmail() {
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);

        // Configura o mock para retornar um usuário quando o e-mail é "mail@mail.com"
        Mockito.when(repository.getUserByEmail("mail@mail.com"))
                .thenReturn(Optional.of(UsuarioBuilder.umUsuario().agora()));

        // Chamada ao serviço usando o e-mail "mail@mail.com"
        Optional<Usuario> user = service.getUserByEmail("mail@mail.com");
        Assertions.assertFalse(user.isEmpty());
        System.out.println(user);
    }

}
