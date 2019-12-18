package fr.formation.reactive.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryResponseDto {

    @Size(min = 2, max = 2)
    private String alpha2Code;

    @NotBlank
    private String name;

    @NotBlank
    private String region;

    @NotNull
    private String flag;

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
	return region;
    }

    public void setRegion(String region) {
	region = region;
    }

    public String getFlag() {
	return flag;
    }

    public void setFlag(String flag) {
	this.flag = flag;
    }
}
