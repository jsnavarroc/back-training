package com.example.demo.user.controlers;

import com.example.demo.user.domain.CreateUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @PostMapping
    public String createUser(@RequestBody CreateUserRequest userBody) {
        return userBody.toString();
    }
}

