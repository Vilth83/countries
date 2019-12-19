package fr.formation.reactive.api.services;

import fr.formation.reactive.domain.model.Country;
import reactor.core.publisher.Mono;

public interface CountryService {

    Mono<Country> getByIsoCode(String isoCode);
}
