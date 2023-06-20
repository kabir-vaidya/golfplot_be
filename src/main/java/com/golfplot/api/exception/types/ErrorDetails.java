package com.golfplot.api.exception.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Data
public class ErrorDetails {
    String message;
    HttpStatus status;
    int statusCode;
}
