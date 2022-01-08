package ru.attest.reactive_mongo.util;

public enum FilterCondition {
    And{
        final private int key = 0;
        public int getKey(){return key;}
    },
    Or{
        final private int key = 1;
        public int getKey(){return key;}
    };
    public abstract int getKey();
}
