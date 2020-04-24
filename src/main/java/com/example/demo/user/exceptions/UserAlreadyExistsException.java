package com.example.demo.user.exceptions;

import com.example.demo.user.domain.UserName;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class UserAlreadyExistsException extends UserException {
    UserName userName;

    private UserAlreadyExistsException(UserName userName) {
        super(String.format("User %s already exists", userName.getValue()));
        this.userName = userName;
    }
}

