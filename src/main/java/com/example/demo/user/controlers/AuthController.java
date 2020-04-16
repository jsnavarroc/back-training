package com.example.demo.user.controlers;

import com.example.demo.user.domain.UserAuthRequest;
import com.example.demo.user.domain.UserName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/hello")
    public String greeting(){
        return "Hello world";
    }

    @PostMapping("/authenticate")
    public UserAuthRequest autenticate(){
        UserName userName = UserName.of("test-username");
        String password = "password...";
        return UserAuthRequest.from(
                userName,
                password
        );
    }
}
