package com.example.demo.configuration;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor // con esto colocamos el contructor.
public class WebApplicationConfiguration implements WebMvcConfigurer {

    private final Gson gson;

    // Metodo encargado de indicarle a Spring como convertir lo mensajes
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter(gson);
        converters.add(gsonHttpMessageConverter);
    }
}
