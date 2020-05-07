package co.jsnvarroc.orders.user.configuration;

import co.jsnvarroc.orders.user.repositories.SqlUserRepository;
import co.jsnvarroc.orders.user.repositories.InMemoryUserRepository;
import co.jsnvarroc.orders.user.repositories.UserRepository;
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
                .withTableName("users")
                .usingGeneratedKeyColumns("id");

        return new SqlUserRepository(jdbcTemplate, simpleJdbcInsert);
    }


    @Bean
    @Profile({"test"})
    public UserRepository userRepository(){
        return new InMemoryUserRepository();
    }

}
