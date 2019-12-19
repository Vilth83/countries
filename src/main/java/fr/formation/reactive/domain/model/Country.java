package fr.formation.reactive.domain.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Country {

    @Id
    private String id;

    @Field
    @NotNull
    private String isoCode;

    @Field
    private String name;

    @Field
    private String region;

    @Field
    private String flag;

    public Country(String isoCode, String name, String region, String flag) {
	super();
	this.isoCode = isoCode;
	this.name = name;
	region = region;
	this.flag = flag;
    }

    public Country() {
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getIsoCode() {
	return isoCode;
    }

    public void setIsoCode(String isoCode) {
	this.isoCode = isoCode;
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
	this.region = region;
    }

    public String getFlag() {
	return flag;
    }

    public void setFlag(String flag) {
	this.flag = flag;
    }

    @Override
    public String toString() {
	return "Country [id=" + id + ", isoCode=" + isoCode + ", name=" + name
		+ ", Region=" + region + ", flag=" + flag + "]";
    }
}
