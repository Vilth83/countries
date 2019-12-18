package fr.formation.reactive.api;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import fr.formation.reactive.domain.Country;
import reactor.core.publisher.Mono;

public interface CountryRepo extends ReactiveMongoRepository<Country, String> {

    Mono<Country> findByIsoCode(String isoCode);
}
