package com.example.demo.user.controlers;

import com.example.demo.user.domain.CreateUserRequest;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserOperation;
import com.example.demo.user.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServices services;

    @PostMapping
    public ResponseEntity<UserOperation> createUser(@RequestBody CreateUserRequest userBody) {
        UserOperation userOperation = services.userCreated(userBody.getUsername(), userBody.getPassword());
        if(userOperation.isValid()) {
            return ResponseEntity.ok(userOperation);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(userOperation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCreated> getUserById(@PathVariable Long id){
        Optional<UserCreated> optionalUser = services.findById(id);
        return ResponseEntity.of(optionalUser);
    }
}

