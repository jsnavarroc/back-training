package com.example.demo.user.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("users-sql")
public class SqlUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SqlUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public UserCreated createOne(UserName userName, Password password) {
        return null;
    }

    @Override
    public UserCreated findById(Long id) {
        return null;
    }
}
