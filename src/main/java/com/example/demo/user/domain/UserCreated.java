package com.example.demo.user.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class UserCreated {
    UserName userName;
    Password password;
    Long id;
}
