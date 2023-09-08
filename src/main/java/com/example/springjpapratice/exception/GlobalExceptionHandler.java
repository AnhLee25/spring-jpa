package com.example.springjpapratice.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
  private final MessageSource messageSource;

  @ExceptionHandler({DuplicateDataException.class, RuntimeException.class})
  public ResponseEntity<ErrorResponse> handleDuplicateDataException(DuplicateDataException e) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
    errorResponse.setDescription(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
