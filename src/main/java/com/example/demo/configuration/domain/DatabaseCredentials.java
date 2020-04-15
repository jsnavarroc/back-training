package com.example.demo.configuration.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database") // Con esto traemos el objeto del yml
@RequiredArgsConstructor // con esto colocamos el contructor.
@Data // Con esto creamos los gets y sets
public class DatabaseCredentials {
    private String host;
    private String port;
    private String username;
    private String password;

}
