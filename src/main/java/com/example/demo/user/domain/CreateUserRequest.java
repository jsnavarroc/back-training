package com.example.demo.user.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class CreateUserRequest {
    UserName username;
    Password password;

}
