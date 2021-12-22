package ru.attest.reactive_mongo.entities.mars.enterprise;


import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
public class AddInfo {
    private String legalForm;
    private String taxNumber;
    private String paymentInfo;
    private String catInformationExchange;
    private String economyBranch;
    private String branchComplex;
    private Boolean isExplotationOrg;
    private Boolean isYaroo;
    private Boolean showInPPD;
    private String activities;
    private String activitiesDescription;
    private String registryNumber;
    private Date registryDate;
    private String registryLocation;
    private List<Classificator> classificators = new ArrayList<>();
    private Dangers dangers;
    private Map<String,String> vals;

}
