package br.com.nveladio.junit5_curso.ifra;

import br.com.nveladio.junit5_curso.domain.Usuario;
import br.com.nveladio.junit5_curso.domain.builders.UsuarioBuilder;
import br.com.nveladio.junit5_curso.repositories.UsuarioRepository;

import java.util.Optional;

public class UsuarioDummyRepository implements UsuarioRepository {

    @Override
    public Usuario salvar(Usuario usuario) {
        return UsuarioBuilder.umUsuario()
                .comNome(usuario.Nome())
                .comEmail(usuario.Email())
                .comSenha(usuario.Senha())
                .agora();
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        if ("user@gmail.com".equals(email))
            return Optional.of(UsuarioBuilder.umUsuario().comEmail(email).agora());
        return Optional.empty();
    }
}
