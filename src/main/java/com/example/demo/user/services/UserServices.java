package com.example.demo.user.services;

import com.example.demo.common.Business;
import com.example.demo.user.repositories.UserRepository;
import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Business
public class UserServices {
    private  final  UserRepository repository;

    @Autowired
    public UserServices(@Qualifier("in-memory") UserRepository repository){
        this.repository = repository;
    }

    public UserCreated userCreated(UserName userName, Password password){
        return repository.createOne(userName, password);
    }

    public  UserCreated findById(Long id){
        return repository.findById(id);
    }
}
