package fr.formation.reactive.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.reactive.api.services.CountryService;
import fr.formation.reactive.domain.dtos.CountryRequestDto;
import fr.formation.reactive.domain.model.Country;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Qualifier("countryServiceImpl")
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
	super();
	this.countryService = countryService;
    }

    @PostMapping
    public Mono<Country> getByIsoCode(
	    @Valid @RequestBody CountryRequestDto request) {
	return countryService.getByIsoCode(request.getIsoCode());
    }
}
