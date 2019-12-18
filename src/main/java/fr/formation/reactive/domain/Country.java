package fr.formation.reactive.domain;

import java.net.URI;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Country {

    @Id
    private String id;

    @Field
    private String isoCode;

    @Field
    private String name;

    @Field
    private String Region;

    @Field
    private URI flag;

    public Country(String isoCode, String name, String region, URI flag) {
	super();
	this.isoCode = isoCode;
	this.name = name;
	Region = region;
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

    @Override
    public String toString() {
	return "Country [id=" + id + ", isoCode=" + isoCode + ", name=" + name
		+ ", Region=" + Region + ", flag=" + flag + "]";
    }
}
