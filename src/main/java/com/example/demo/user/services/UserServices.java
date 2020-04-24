package com.example.demo.user.services;

import com.example.demo.common.Business;
import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;
import com.example.demo.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Business
public class UserServices {
    private  final  UserRepository repository;

    @Autowired
    public UserServices(UserRepository repository){
        this.repository = repository;
    }

    public UserCreated userCreated(UserName userName, Password password){
        return repository.createOne(userName, password);
    }

    public Optional<UserCreated> findById(Long id){
        return repository.findById(id);
    }
}
