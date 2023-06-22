package com.golfplot.api.exception;

import com.golfplot.api.exception.types.ErrorDetails;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NoSuchElementException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorDetails> noSuchElementExceptionHandling(Exception ex) {
        ErrorDetails details = new ErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDetails> sqlExceptionHandling(Exception ex) {
        ErrorDetails details = new ErrorDetails(ex.getCause().getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdentifierGenerationException.class)
    public ResponseEntity<ErrorDetails> identifierGenerationExceptionHandling(Exception ex) {
        ErrorDetails details = new ErrorDetails(ex.getCause().getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
        System.out.println(IdentifierGenerationException.class.getClass());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}

