package com.example.demo.user.exceptions;

import com.example.demo.user.domain.UserName;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class UserAlreadyExistsException extends UserException {
    UserName userName;

    @Override
    public String getMessage() {
        return String.format("User %s already existis.", userName.getValue());
    }
}
