package com.example.homework16.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User already exists!")
public class ExeptionRegistedUser extends RuntimeException {

    public ExeptionRegistedUser (String message){
        super(message);
    }


}