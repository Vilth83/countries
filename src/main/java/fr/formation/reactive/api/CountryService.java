package fr.formation.reactive.api;

import fr.formation.reactive.domain.Country;
import reactor.core.publisher.Mono;

public interface CountryService {

    Mono<Country> getByIsoCode(String isoCode);
}
