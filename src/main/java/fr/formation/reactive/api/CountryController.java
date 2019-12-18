package fr.formation.reactive.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.reactive.domain.Country;
import fr.formation.reactive.domain.CountryRequestDto;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public Mono<Country> getByIsoCode(
	    @Valid @RequestBody CountryRequestDto request) {
	return countryService.getByIsoCode(request.getIsoCode());
    }
}
