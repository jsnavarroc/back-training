package com.example.demo.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;

public interface UserRepository {
    UserCreated createOne(UserName userName, Password password);
    UserCreated findById(Long id);
}
