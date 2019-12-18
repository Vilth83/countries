package fr.formation.reactive.domain;

import javax.validation.constraints.Size;

public class CountryRequestDto {

    @Size(min = 2, max = 2)
    private String isoCode;

    public String getIsoCode() {
	return isoCode;
    }

    public void setIsoCode(String isoCode) {
	this.isoCode = isoCode;
    }
}
