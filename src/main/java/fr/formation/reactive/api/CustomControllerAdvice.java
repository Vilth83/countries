package fr.formation.reactive.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.formation.reactive.domain.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler({ ResourceNotFoundException.class })
    protected ResponseEntity<ResourceNotFoundException> handleApiException(
	    ResourceNotFoundException exception) {
	return new ResponseEntity<ResourceNotFoundException>(
		new ResourceNotFoundException(exception.getMessage()),
		HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
