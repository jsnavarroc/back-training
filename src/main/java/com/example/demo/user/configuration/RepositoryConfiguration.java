package com.example.demo.user.configuration;

import com.example.demo.user.repositories.InMemoryUserRepository;
import com.example.demo.user.repositories.SqlUserRepository;
import com.example.demo.user.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Profile({"dev", "prod"})
    public UserRepository userRepository(JdbcTemplate jdbcTemplate){
        return new SqlUserRepository(jdbcTemplate);
    }


    @Bean
    @Profile({"dev-test"})
    public UserRepository userRepository(){
        return new InMemoryUserRepository();
    }

}
