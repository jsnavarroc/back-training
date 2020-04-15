package com.example.demo.configuration;

import com.example.demo.configuration.domain.DatabaseCredentials;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {

    @Bean
    public DataSource hikariDatasource(DatabaseCredentials credentials){
        HikariConfig config = new HikariConfig();
        String jdbcUrl = String.format("jdbc:postgresql://%s:%s/%s", credentials.getHost(), credentials.getPassword(), credentials.getDatabase() );
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(credentials.getUsername());
        config.setPassword(credentials.getPassword());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);

    }

}
