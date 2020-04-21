package com.example.demo.user.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class CreateUserRequest {
    UserName username;
    Password password;

}
