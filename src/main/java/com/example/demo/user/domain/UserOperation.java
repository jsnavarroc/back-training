package com.example.demo.user.domain;

public interface UserOperation {
    UserCreated value();
    String errorMessage();

    Boolean isValid();
}
