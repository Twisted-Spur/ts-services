package com.twistedspur.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle specific exceptions
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetails handleException(NotFoundException ex, WebRequest request) {
        return new ErrorDetails(ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(UserValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleException(UserValidationException ex, WebRequest request) {
        return new ErrorDetails(ex.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(UploadException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetails handleException(UploadException ex, WebRequest request) {
        return new ErrorDetails(ex.getMessage(), request.getDescription(false));
    }

    // Error details class
    @Setter
    @Getter
    public static class ErrorDetails {
        // Getters and setters
        private String message;
        private String details;

        public ErrorDetails(String message, String details) {
            this.message = message;
            this.details = details;
        }
    }
}
