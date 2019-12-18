package fr.formation.reactive.api;

import java.net.UnknownHostException;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.formation.reactive.domain.exceptions.NotAcceptableException;
import fr.formation.reactive.domain.exceptions.RequestTimeoutException;
import fr.formation.reactive.domain.exceptions.ResourceNotFoundException;
import io.netty.handler.timeout.TimeoutException;

@RestControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler({ ResourceNotFoundException.class })
    protected ResponseEntity<ResourceNotFoundException> handleNotFound(
	    ResourceNotFoundException exception) {
	return new ResponseEntity<>(
		new ResourceNotFoundException(exception.getMessage()),
		HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ TimeoutException.class })
    protected ResponseEntity<RequestTimeoutException> handleTimeOut(
	    TimeoutException exception) {
	return new ResponseEntity<>(
		new RequestTimeoutException("request took to long to respond",
			exception),
		HttpStatus.REQUEST_TIMEOUT);
    }

    @ExceptionHandler({ UnknownHostException.class })
    protected ResponseEntity<UnknownHostException> handleHostException() {
	return new ResponseEntity<>(new UnknownHostException("Host not found"),
		HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler({ NotReadablePropertyException.class })
    protected ResponseEntity<NotAcceptableException> handleNotReadableProperty(
	    NotReadablePropertyException exception) {
	return new ResponseEntity<>(
		new NotAcceptableException(
			"Not acceptable " + exception.getPropertyName()),
		HttpStatus.NOT_ACCEPTABLE);
    }
}
