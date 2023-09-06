package com.example.springjpapratice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DuplicateDataException extends Exception{
    private String message;
    public DuplicateDataException(String message){
        super(message);
    }
}
