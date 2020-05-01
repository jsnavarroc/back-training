package co.jsnvarroc.orders.user.repositories;

import co.jsnvarroc.orders.user.domain.Password;
import co.jsnvarroc.orders.user.domain.UserCreated;
import co.jsnvarroc.orders.user.domain.UserName;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SqlUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private RowMapper<UserCreated> rowMapper = (resultSet, i) -> {
        long id1 = resultSet.getLong("id");
        UserName username = UserName.of(resultSet.getString("username"));
        Password password = Password.of(resultSet.getString("password"));
        return UserCreated.of(username, password, id1);
    };

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
        parameters.put("username", userName.getValue());
        parameters.put("password", password.getValue());

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
        String SQL = "SELECT id, username, password FROM users WHERE id = ?";
        Object[] objects = {id};
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

    @Override
    public Optional<UserCreated> findByUserName(UserName userName) {
        String SQL = "SELECT id, username, password FROM users WHERE username = ?";
        Object[] objects = {userName.getValue()};
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL, objects, rowMapper ));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }
}
