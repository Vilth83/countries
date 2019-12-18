package fr.formation.reactive.domain;

import java.net.URI;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryResponseDto {

    @Size(min = 2, max = 2)
    private String alpha2Code;

    @NotBlank
    private String name;

    @NotBlank
    private String Region;

    @NotNull
    private URI flag;

    public String getAlpha2Code() {
	return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
	this.alpha2Code = alpha2Code;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getRegion() {
	return Region;
    }

    public void setRegion(String region) {
	Region = region;
    }

    public URI getFlag() {
	return flag;
    }

    public void setFlag(URI flag) {
	this.flag = flag;
    }
}
