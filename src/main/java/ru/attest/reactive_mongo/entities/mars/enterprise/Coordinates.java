package ru.attest.reactive_mongo.entities.mars.enterprise;

import lombok.Data;

@Data
public class Coordinates {
    private Double latitude;
    private Double longitude;

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
