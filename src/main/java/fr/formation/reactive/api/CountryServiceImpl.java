package fr.formation.reactive.api;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.web.reactive.function.client.WebClient;

import fr.formation.reactive.domain.Country;
import fr.formation.reactive.domain.CountryResponseDto;
import fr.formation.reactive.domain.CountryResponseValidator;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo repo;

    @Autowired
    private WebClient webClient;

    @Autowired
    private CountryResponseValidator responseValidator;

    @Cacheable(value = "country", key = "#isoCode")
    @Override
    public Mono<Country> getByIsoCode(String isoCode) {
	return repo.findByIsoCode(isoCode).switchIfEmpty(getAndSave(isoCode));
    }

    private Country save(Country country) {
	repo.save(country).subscribe();
	return country;
    }

    private Mono<Country> getAndSave(String isoCode) {
	return getFromApiByIsoCode(isoCode).timeout(Duration.ofMillis(2000))
		.map(this::mapToCountry).map(this::save);
    }

    private Mono<CountryResponseDto> getFromApiByIsoCode(String isoCode) {
	return webClient.get().uri("/" + isoCode).exchange().flatMap(
		response -> response.bodyToMono(CountryResponseDto.class));
    }

    private Country mapToCountry(CountryResponseDto dto) {
	responseValidator.validate(dto,
		new DirectFieldBindingResult(dto, dto.toString()));
	Country country = new Country();
	country.setName(dto.getName());
	country.setRegion(dto.getRegion());
	country.setFlag(dto.getFlag());
	country.setIsoCode(dto.getAlpha2Code());
	return country;
    }
}
