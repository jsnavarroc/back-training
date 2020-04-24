package com.example.demo.user.configuration;

import com.example.demo.user.repositories.InMemoryUserRepository;
import com.example.demo.user.repositories.SqlUserRepository;
import com.example.demo.user.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Profile({"dev", "prod"})
    public UserRepository userRepository(JdbcTemplate jdbcTemplate, DataSource dataSource){
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("USERS")
                .usingGeneratedKeyColumns("ID");

        return new SqlUserRepository(jdbcTemplate, simpleJdbcInsert);
    }


    @Bean
    @Profile({"dev-test"})
    public UserRepository userRepository(){
        return new InMemoryUserRepository();
    }

}
