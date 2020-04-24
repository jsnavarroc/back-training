package com.example.demo.user.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class UserOperationFailure  implements UserOperation{
    String message;

    @Override
    public UserCreated value() {
        return null;
    }

    @Override
    public String errorMessage() {
        return message;
    }

    @Override
    public Boolean isValid() {
        return false;
    }
}
