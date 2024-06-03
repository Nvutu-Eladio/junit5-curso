package br.com.nveladio.junit5_curso.service;

import br.com.nveladio.junit5_curso.domain.Usuario;
import br.com.nveladio.junit5_curso.domain.exceptions.ValidationException;
import br.com.nveladio.junit5_curso.repositories.UsuarioRepository;

import java.util.Optional;

public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService (UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario) {
        repository.getUserByEmail(usuario.Email()).ifPresent(user -> {
            throw new ValidationException(String.format("Usuário %s ja cadastrado", usuario.Email()));

        });
        return  repository.salvar(usuario);
        // Conectar com o banco
        // Preparar SQL
        // Executar a consulta
        // Obter o usuário persistido
    }

    public Optional<Usuario> getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }
}
