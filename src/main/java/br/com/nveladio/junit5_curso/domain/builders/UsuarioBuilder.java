package br.com.nveladio.junit5_curso.domain.builders;

import br.com.nveladio.junit5_curso.domain.Usuario;

public class UsuarioBuilder {
    private Long id;     
    private String nome; 
    private String email;
    private String senha;

    private UsuarioBuilder(){}

    public static UsuarioBuilder umUsuario() {
            UsuarioBuilder builder = new UsuarioBuilder();
            inicializarDadosPadroes(builder);
            return builder;
    }

    private static void inicializarDadosPadroes(UsuarioBuilder builder) {
        builder.id = 1L;
        builder.nome = "Usuário Válido";
        builder.email = "user@gmail.com";
        builder.senha = "123";
    }

    public UsuarioBuilder comId(Long id) {
            this.id = id;
            return this;
    }

    public UsuarioBuilder comNome(String nome) {
            this.nome = nome;
            return this;
    }

    public UsuarioBuilder comEmail(String email) {
            this.email = email;
            return this;
    }

    public UsuarioBuilder comSenha(String senha) {
            this.senha = senha;
            return this;
    }

    public Usuario agora() {
            return new Usuario(id, nome, email, senha);
    }
}
