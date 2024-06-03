package br.com.nveladio.junit5_curso.domain.exceptions;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = -2734243454565466L;

    public ValidationException(String message) {
        super(message);
    }
}
