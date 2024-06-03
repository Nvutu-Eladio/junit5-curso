package br.com.nveladio.junit5_curso.infra;

import br.com.nveladio.junit5_curso.domain.Usuario;
import br.com.nveladio.junit5_curso.domain.exceptions.ValidationException;
import br.com.nveladio.junit5_curso.ifra.UsuarioMemoryRepository;
import br.com.nveladio.junit5_curso.service.UsuarioService;
import org.junit.jupiter.api.*;

import static br.com.nveladio.junit5_curso.domain.builders.UsuarioBuilder.umUsuario;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceComUserMemoryRepositoryTest {
    private UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());

    @Test
    @Order(1)
    public void deveSalvarUsuarioValido() {
        Usuario user = service.salvar(umUsuario().comId(null).agora());
        Assertions.assertNotNull(user.Id());
//        Assertions.assertEquals(2L, user.Id());
    }


//    @Test
//    @Order(2)
//    public void deveRejeitarUsuarioExistente() {
//        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
//                service.salvar(umUsuario().comId(null).agora()));
//        Assertions.assertEquals("Usuário user@mail.com já cadastrado!", ex.getMessage());
//    }
}
