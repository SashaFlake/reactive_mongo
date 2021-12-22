package ru.attest.reactive_mongo.entities.enterprise;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Timezone {

    private String name;

    private String timeId;

    private Double timeValue;

    public Timezone(String name, String timeId, Double timeValue) {
        this.name = name;
        this.timeId = timeId;
        this.timeValue = timeValue;
    }
}
