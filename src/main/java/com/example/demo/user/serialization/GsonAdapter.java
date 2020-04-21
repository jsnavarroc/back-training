package com.example.demo.user.serialization;

import com.example.demo.user.domain.Password;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import io.micrometer.core.instrument.FunctionTimer;

import java.util.function.Function;

public interface GsonAdapter<T> extends JsonDeserializer<T>, JsonSerializer<T> {
    public  static <T> String toString (T object) {
        return object.toString();
    }

    public default Password creator(String value, Function<String, Password> creator){
        return creator.apply(value);
    }

    public static void main(String[] args) {
        Function<String, Password>  creator = new Function<String, Password>(){
            @Override
            public Password apply(String s) {
                return Password.of(s);
            }
        };


        Password password = creator.apply("Password");

        System.out.println(password);
    }
}
