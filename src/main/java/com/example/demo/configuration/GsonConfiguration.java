package com.example.demo.configuration;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserName;
import com.example.demo.user.serialization.StringSerializable;
import com.example.demo.user.serialization.StringValueAdapter;
import com.example.demo.user.serialization.UserNameAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GsonConfiguration {

    // La idea es solo ver esta linea una sola vez.
    @Bean
    public Gson gson(){
        Function<String, Password> creator = new Function<String, Password>(){
            @Override
            public Password apply(String s) {
                return Password.of(s);
            }
        };
        return new GsonBuilder()
                .registerTypeAdapter(UserName.class, new UserNameAdapter())
                .registerTypeAdapter(Password.class, new StringValueAdapter<Password>(creator))
                .create();
    }
}
