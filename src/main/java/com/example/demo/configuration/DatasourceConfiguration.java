package com.example.demo.configuration;

import com.example.demo.configuration.domain.DatabaseCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DatasourceConfiguration {

    private final DatabaseCredentials credentials;

    @Autowired
    public DatasourceConfiguration(DatabaseCredentials credentials) {
        this.credentials = credentials;
    }

    /*
    * Este se utiliza cuando queremos que el metodo se ejecute una vez hayan cargado todas las deprendencias
    * de esta forma evitará un NullPointerException.
    * */
    @PostConstruct
    public  void  init(){
        System.out.println(">>>" + credentials);
    }
}
