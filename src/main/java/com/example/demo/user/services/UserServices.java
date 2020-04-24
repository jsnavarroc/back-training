package com.example.demo.user.services;

import com.example.demo.common.Business;
import com.example.demo.user.domain.*;
import com.example.demo.user.exceptions.UserAlreadyExistsException;
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

    public UserOperation userCreated(UserName userName, Password password){
        Optional<UserCreated> userExistence = repository.findByUserName(userName);
        if(userExistence.isPresent()){
            UserOperationFailure exeption = UserOperationFailure.of(UserAlreadyExistsException.of(userName));
            return exeption;
        }else {
            UserCreated userCreated = repository.createOne(userName,password);
            return UserOperationSuccess.of(userCreated);
        }
    }

    public Optional<UserCreated> findById(Long id){
        return repository.findById(id);
    }
}
