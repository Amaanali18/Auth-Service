package com.Auth.Auth_Service.exceptions;

import com.Auth.Auth_Service.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
//    public GlobalExceptionHandler(String message) {
//        super(message);
//    }

    @ExceptionHandler(GlobalExceptionHandler.class)
    public ResponseEntity<ErrorDTO>  handleException(ResourceNotFound ex) {
        ErrorDTO errorDTO = new ErrorDTO(404,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO>  handleException(IllegalArgumentException ex) {
        ErrorDTO errorDTO = new ErrorDTO(400,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }
}
