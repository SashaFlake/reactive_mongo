package ru.attest.reactive_mongo.util;

import ru.attest.reactive_mongo.entities.AbstractEntity;

public class ClasspathConst<T extends AbstractEntity> {
    final static String commonPath = "ru.attest.reactive_mongo.entities.";
    final static String enterprisePath = "ru.attest.reactive_mongo.entities.enterprise.";
    final static String marsEnterprisePath = "ru.attest.reactive_mongo.entities.mars.enterprise.";

    public static Class<?> recognizeClass(String className) throws ClassNotFoundException {
        return Class.forName(commonPath+className);
    }

}
