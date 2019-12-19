package fr.formation.reactive.api.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import fr.formation.reactive.domain.model.Country;
import reactor.core.publisher.Mono;

public interface CountryRepo extends ReactiveMongoRepository<Country, String> {

    Mono<Country> findByIsoCode(String isoCode);
}
