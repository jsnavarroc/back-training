package com.example.demo.user.domain;

import com.example.demo.user.exceptions.UserException;
import lombok.Value;

@Value(staticConstructor = "of")
public class UserOperationFailure  implements UserOperation{
    UserException exception;

    @Override
    public UserCreated value() {
        return null;
    }

    @Override
    public String errorMessage() {
        return exception.getMessage();
    }

    @Override
    public Boolean isValid() {
        return false;
    }
}
