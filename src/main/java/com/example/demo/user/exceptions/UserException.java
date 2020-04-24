package com.example.demo.user.exceptions;

public abstract class UserException extends  RuntimeException{
    public UserException(String message){
        super(message);
    }
}
