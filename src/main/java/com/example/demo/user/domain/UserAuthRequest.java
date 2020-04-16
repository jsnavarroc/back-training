package com.example.demo.user.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class UserAuthRequest {
    String username;
    String password;
}
