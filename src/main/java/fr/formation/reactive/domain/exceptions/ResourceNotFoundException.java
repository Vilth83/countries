package fr.formation.reactive.domain.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8443721954762512457L;

    public ResourceNotFoundException() {
	super();
    }

    public ResourceNotFoundException(String message) {
	super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
	super(message, cause);
    }
}
