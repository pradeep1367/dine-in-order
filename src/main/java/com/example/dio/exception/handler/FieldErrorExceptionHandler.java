package com.example.dio.exception.handler;

import com.example.dio.util.FieldErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodValidationException(MethodValidationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldErrorResponse.CustomFieldError> errors = ex.getAllErrors().stream()
                .map(error -> (FieldError) error)
                .map(this::createFieldError)
                .toList();

        FieldErrorResponse error = createFieldErrorResponse(status, errors);

        return ResponseEntity.status(status)
                .body(error);

    }

    private FieldErrorResponse createFieldErrorResponse(HttpStatus status, List<FieldErrorResponse.CustomFieldError> errors) {
        FieldErrorResponse error=FieldErrorResponse.builder()
                .type(status.toString())
                .status(status.value())
                .message("Invalid input")
                .errors(errors)
                .build();

        return error;

    }

    private FieldErrorResponse.CustomFieldError createFieldError(FieldError fieldError) {
        FieldErrorResponse.CustomFieldError  error=FieldErrorResponse.createFieldError(
              fieldError.getDefaultMessage(),
                fieldError.getRejectedValue(),
                fieldError.getField());

        return error;

    }

}
