package com.example.demo.user.domain;

public class UserName {

    private final String value;


    private UserName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "value='" + value + '\'' +
                '}';
    }
}

