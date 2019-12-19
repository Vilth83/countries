package fr.formation.reactive.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import fr.formation.reactive.api.repositories.CountryRepo;
import fr.formation.reactive.domain.model.Country;
import reactor.core.publisher.Mono;

@Service
@Primary
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo repo;

    @Autowired
    @Qualifier("externalApiCountryServiceImpl")
    private CountryService apiService;

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
	return apiService.getByIsoCode(isoCode).map(this::save);
    }
}
