package co.jsnvarroc.orders.product.configuration;

import co.jsnvarroc.orders.product.repositories.InMemoryProductRepository;
import co.jsnvarroc.orders.product.repositories.ProductRepository;
import co.jsnvarroc.orders.product.repositories.SqlProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfigurationProduct {
    @Bean
    public ProductRepository productRepository(JdbcTemplate jdbcTemplate, DataSource dataSource){
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");

        return new SqlProductRepository(jdbcTemplate, simpleJdbcInsert);
    }

    @Bean
    @Profile({"dev-test"})
    public ProductRepository productRepository() {  return new InMemoryProductRepository(); }

}
