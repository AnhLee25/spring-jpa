package com.example.springjpapratice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NotFoundException extends RuntimeException {
    private String message;
    
    public NotFoundException(String message) {
        super(message);
    }
}
