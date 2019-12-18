package fr.formation.reactive.domain.exceptions;

public class RequestTimeoutException extends RuntimeException {

    public RequestTimeoutException() {
	super();
    }

    public RequestTimeoutException(String message) {
	super(message);
    }

    public RequestTimeoutException(String message, Throwable cause) {
	super(message, cause);
    }
}
