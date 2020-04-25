package co.jsnvarroc.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@EnableConfigurationProperties
public class OrdersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApiApplication.class, args);
	}

}
