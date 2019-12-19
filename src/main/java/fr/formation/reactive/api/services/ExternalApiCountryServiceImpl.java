package fr.formation.reactive.api.services;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.web.reactive.function.client.WebClient;

import fr.formation.reactive.domain.dtos.CountryResponseDto;
import fr.formation.reactive.domain.model.Country;
import fr.formation.reactive.domain.validators.CountryResponseValidator;
import reactor.core.publisher.Mono;

@Service
public class ExternalApiCountryServiceImpl implements CountryService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private CountryResponseValidator responseValidator;

    @Override
    public Mono<Country> getByIsoCode(String isoCode) {
	return getFromApiByIsoCode(isoCode).timeout(Duration.ofMillis(2000))
		.map(this::mapToCountry);
    }

    private Mono<CountryResponseDto> getFromApiByIsoCode(String isoCode) {
	return webClient.get().uri("/" + isoCode).exchange().flatMap(
		response -> response.bodyToMono(CountryResponseDto.class));
    }

    private Country mapToCountry(CountryResponseDto dto) {
	responseValidator.validate(dto,
		new DirectFieldBindingResult(dto, dto.getClass().getName()));
	Country country = new Country();
	country.setName(dto.getName());
	country.setRegion(dto.getRegion());
	country.setFlag(dto.getFlag());
	country.setIsoCode(dto.getAlpha2Code());
	return country;
    }
}
