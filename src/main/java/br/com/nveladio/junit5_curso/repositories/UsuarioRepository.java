package br.com.nveladio.junit5_curso.repositories;

import br.com.nveladio.junit5_curso.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    Usuario salvar(Usuario usuario);

    Optional<Usuario> getUserByEmail(String email);
}
