package fr.formation.reactive.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import fr.formation.reactive.domain.Country;
import fr.formation.reactive.domain.CountryResponseDto;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo repo;

    @Autowired
    private WebClient webClient;

    @Cacheable(value = "country", key = "#isoCode")
    @Override
    public Mono<Country> getByIsoCode(String isoCode) {
	return repo.findByIsoCode(isoCode).switchIfEmpty(getAndSave(isoCode));
    }

    private void save(Country country) {
	repo.save(country).subscribe();
    }

    private Mono<Country> getAndSave(String isoCode) {
	return getFromApiByIsoCode(isoCode).map(this::mapToCountry)
		.map(resp -> {
		    if (resp.getIsoCode() != null) {
			save(resp);
		    }
		    return resp;
		});
    }

    private Mono<CountryResponseDto> getFromApiByIsoCode(String isoCode) {
	return webClient.get().uri("/" + isoCode)
		.accept(MediaType.APPLICATION_JSON).exchange()
		.flatMap(response -> response
			.bodyToMono(CountryResponseDto.class));
    }

    private Country mapToCountry(CountryResponseDto dto) {
	Country country = new Country();
	country.setName(dto.getName());
	country.setRegion(dto.getRegion());
	country.setFlag(dto.getFlag());
	country.setIsoCode(dto.getAlpha2Code());
	return country;
    }
}
