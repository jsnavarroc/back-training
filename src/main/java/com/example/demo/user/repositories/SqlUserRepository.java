package com.example.demo.user.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String SQL = "INCERT INTO USER (USERNAME, PASSWORD) VALUES (?.?)";

        PreparedStatementSetter pss = preparedStatement -> {
            preparedStatement.setString(1, userName.getValue());
            preparedStatement.setString(2, password.getValue());
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();

       PreparedStatementCreator psc = connection -> {
           PreparedStatement ps = connection.prepareStatement(SQL);
           ps.setString(1, userName.getValue());
           ps.setString(2, password.getValue());
           return ps;
       };

        jdbcTemplate.update(
            psc,
            keyHolder
        );

        Long key = keyHolder.getKey().longValue();
        return UserCreated.of(
                userName,
                password,
                key
        );
    }

    @Override
    public UserCreated findById(Long id) {
        String SQL = "select ID, USERNAME, PASSWORD from USERS where ID = ?";
        Object[] objects = {id};

        RowMapper<UserCreated> rowMapper = (resultSet, i) -> {
            long id1 = resultSet.getLong("ID");
            UserName username = UserName.of(resultSet.getString("USERNAME"));
            Password password = Password.of(resultSet.getString("PASSWORD"));
            return UserCreated.of(username, password, id1);
        };
        /* *
        * con el metodo queryForObject solo obtendremos la primera linea que cuampla con la
        * condicion SQL, si colocamos el metodo queryForList retornara todos
        * */
        jdbcTemplate.queryForObject(SQL, objects, rowMapper );
        return null;
    }
}
