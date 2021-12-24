package ru.attest.reactive_mongo.entities.enterprise;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(value = "enterprise")
@Data
public class Enterprise {

    @Id
    private ObjectId id;

    private String name;

    private ObjectId parentKey;

    private int ord;

    private String shortName;

    private Conf confClassified;

    private String fullName;

    private Timezone timezone;

    private Territory city;

    private String terName;

    private Double latitude;

    private Double longitude;

    private Double zoom;

    private String opf;

    private String inn;

    private String entRequisite;

    private String infConnCategory;

    private String economyDep;

    private String depComplex;

    private Boolean isExploitationEnt;

    private Boolean isYarooEnt;

    private String registerNum;

    private LocalDateTime registerDate;

    private String registerAddress;

    private String radiationDanger;

    private String nuclearDanger;

    private String chemicalDanger;

    private String chemicalDangerInfluenceCategory;

    private BigDecimal keyId;

    private String enterpriseStruct;

    private DepartmentType departmentType;

    private List<Okved> okvedSet;

    private List<Department> departments;

    private boolean liquidationFlag;
}
