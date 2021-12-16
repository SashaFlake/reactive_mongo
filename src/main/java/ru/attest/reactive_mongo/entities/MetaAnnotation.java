package ru.attest.reactive_mongo.entities;

import lombok.Data;

@Data
public class MetaAnnotation {
    private boolean hasMultyValues = false;
    private boolean sortable = true;
    private boolean isEmptyAttr = false;
    private int headerLvl = 0;
    private String parentAttr = "";
    private DataTypes dataType = DataTypes.EMPTY;
    private String caption = "";
    private boolean visible =  true;
    private boolean editable = true;
    private String id;
    private boolean isKeyAttr = false;
    private boolean isOrdAttr = false;
    private boolean isParentAttr = false;
    private boolean isNameAttr = false;
    private boolean isVersionAttr = false;
    private boolean isVersionIndateAttr = false;
    private boolean isVersionOutdateAttr = false;
    private int columnOrder = 0;
    private String linkedAttrName = "";
    private String[] dependentFrom = {};
    private String[] affectTo = {};
    private boolean isLinkedAttr = false;
    private boolean isRequired = false;
    private boolean isReferential = false;
    private String mappedValue = "";
    private String nameAttr = "";
    private boolean isParamFilter = false;
    private boolean linkToComplex = false;
    private String defaultValue = "";
    private int sortType = 1;
}
