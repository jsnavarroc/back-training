package com.example.demo.user.repositories;

import com.example.demo.user.domain.Password;
import com.example.demo.user.domain.UserCreated;
import com.example.demo.user.domain.UserName;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SqlUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public SqlUserRepository(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
    }


    @Override
    public UserCreated createOne(UserName userName, Password password) {
     /*String SQL = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

       PreparedStatementCreator psc = connection -> {
           PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, userName.getValue());
           ps.setString(2, password.getValue());
           return ps;
       };

        jdbcTemplate.update(
            psc,
            keyHolder
        );

        Long key = keyHolder.getKey().longValue();*/

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("USERNAME", userName.getValue());
        parameters.put("PASSWORD", password.getValue());

        Number number = simpleJdbcInsert.executeAndReturnKey(parameters);
        long key = number.longValue();
        return UserCreated.of(
                userName,
                password,
                key
        );
    }

    @Override
    public Optional<UserCreated> findById(Long id) {
        String SQL = "SELECT ID, USERNAME, PASSWORD FROM USERS WHERE ID = ?";
        Object[] objects = {id};

        RowMapper<UserCreated> rowMapper = (resultSet, i) -> {
            long id1 = resultSet.getLong("ID");
            UserName username = UserName.of(resultSet.getString("USERNAME"));
            Password password = Password.of(resultSet.getString("PASSWORD"));
            return UserCreated.of(username, password, id1);
        };
        try {
            /* *
            * con el metodo queryForObject solo obtendremos la primera linea que cuampla con la
            * condicion SQL, si colocamos el metodo queryForList retornara todos
            * */
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL, objects, rowMapper ));

        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }
}
