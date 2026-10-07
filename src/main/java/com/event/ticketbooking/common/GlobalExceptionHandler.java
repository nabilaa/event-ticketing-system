package com.event.ticketbooking.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.event.ticketbooking.common.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> constraintViolationException(jakarta.validation.ConstraintViolationException exception) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setData(null);
        response.setErrors(exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(org.springframework.web.server.ResponseStatusException.class)
    public ResponseEntity<ApiResponse<String>> apiException(org.springframework.web.server.ResponseStatusException exception) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setData(null);
        response.setErrors(exception.getReason());

        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }
}