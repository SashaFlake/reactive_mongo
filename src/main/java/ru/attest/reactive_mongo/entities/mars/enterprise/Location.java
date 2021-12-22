package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;
import ru.attest.reactive_mongo.entities.enterprise.Timezone;
@Data
public class Location {
    private String country;
    private String district;
    private String region;
    private String city;
    private Timezone timezone;

    public Location(String country, String district, String region, String city, Timezone timezone) {
        this.country = country;
        this.district = district;
        this.region = region;
        this.city = city;
        this.timezone = timezone;
    }
}
