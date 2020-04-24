package com.example.demo.configuration;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserName;
import com.example.demo.user.exceptions.UserException;
import com.example.demo.user.serialization.StringSerializable;
import com.example.demo.user.serialization.StringValueAdapter;
import com.example.demo.user.serialization.UserNameAdapter;
import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
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
                .registerTypeAdapter(UserName.class, new StringValueAdapter<>(UserName::of))
                .registerTypeAdapter(Password.class, new StringValueAdapter<>(creator))
                .registerTypeAdapter(UserException.class, new JsonSerializer<UserException>() {
                    @Override
                    public JsonElement serialize(UserException src, Type typeOfSrc, JsonSerializationContext context) {
                        JsonObject jsonObject = new JsonObject();
                        String message = src.getMessage();
                        JsonPrimitive errorValue = new JsonPrimitive(message);
                        jsonObject.add("error", errorValue);
                        return jsonObject;
                    }
                })
                .create();
    }
}
