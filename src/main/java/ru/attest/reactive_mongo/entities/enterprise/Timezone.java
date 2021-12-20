package ru.attest.reactive_mongo.entities.enterprise;

import lombok.Data;

@Data
public class Timezone {

    private String name;

    private String timeId;

    private Double timeValue;
}
