package com.example.demo.user.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    UserCreated createOne(UserName userName, Password password);
    UserCreated findById(Long id);
}
