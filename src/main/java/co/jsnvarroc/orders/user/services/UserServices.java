package co.jsnvarroc.orders.user.services;

import co.jsnvarroc.orders.common.Business;
import co.jsnvarroc.orders.user.domain.*;
import co.jsnvarroc.orders.user.exceptions.UserAlreadyExistsException;
import co.jsnvarroc.orders.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Business
public class UserServices {
    private  final UserRepository repository;

    @Autowired
    public UserServices(UserRepository repository){
        this.repository = repository;
    }

    public UserOperation userCreated(UserName userName, Password password){
        System.out.println("S>> "+userName+" S>>"+password);
        Optional<UserCreated> userExistence = repository.findByUserName(userName);
        if(userExistence.isPresent()){
            UserAlreadyExistsException exeption = UserAlreadyExistsException.of(userName);
            return  UserOperationFailure.of(exeption);
        }else {
            UserCreated userCreated = repository.createOne(userName,password);
            return UserOperationSuccess.of(userCreated);
        }
    }

    public Optional<UserCreated> findById(Long id){
        return repository.findById(id);
    }
}

