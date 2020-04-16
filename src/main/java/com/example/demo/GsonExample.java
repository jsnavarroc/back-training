package com.example.demo;

import com.example.demo.user.domain.UserAuthRequest;
import com.example.demo.user.domain.UserName;
import com.example.demo.user.serialization.UserNameAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {

    public static void main(String[] args) {
        // La idea es solo ver esta linea una sola vez.
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(UserName.class, new UserNameAdapter())
                .create();
        UserName userName = UserName.of("test-username");
        String password = "password...";
        UserAuthRequest request = UserAuthRequest.from(
                userName,
                password
        );
        // Se deserealiza para ser leido
        System.out.println(gson.toJson(request));
        System.out.println(gson.fromJson("{\"username\":\"test-username\",\"password\":\"password...\"}", UserAuthRequest.class));
    }
}
