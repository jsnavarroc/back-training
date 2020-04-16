package com.example.demo.user.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class UserAuthRequest {
    UserName username;
    String password;
}
