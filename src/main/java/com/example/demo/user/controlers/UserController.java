package com.example.demo.user.controlers;

import com.example.demo.user.domain.CreateUserRequest;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServices services;

    @PostMapping
    public UserCreated createUser(@RequestBody CreateUserRequest userBody) {
        return services.userCreated(userBody.getUsername(), userBody.getPassword());
    }

    @GetMapping("/{id}")
    public Optional<UserCreated> getUserById(@PathVariable Long id){
        return services.findById(id);
    }
}

