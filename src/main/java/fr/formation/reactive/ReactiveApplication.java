package fr.formation.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import fr.formation.reactive.domain.validators.CountryResponseValidator;

@SpringBootApplication
@EnableCaching
public class ReactiveApplication {

    public static void main(String[] args) {
	SpringApplication.run(ReactiveApplication.class, args);
    }

    @Bean
    protected WebClient restCountriesWebClient() {
	return WebClient.builder()
		.baseUrl("https://restcountries.eu/rest/v2/alpha/")
		.defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
		.build();
    }

    @Bean
    protected CountryResponseValidator responseValidator() {
	return new CountryResponseValidator();
    }
}
