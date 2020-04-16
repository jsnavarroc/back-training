package com.example.demo.configuration;

import com.example.demo.user.domain.UserName;
import com.example.demo.user.serialization.UserNameAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfiguration {

    // La idea es solo ver esta linea una sola vez.
    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .registerTypeAdapter(UserName.class, new UserNameAdapter())
                .create();
    }
}
