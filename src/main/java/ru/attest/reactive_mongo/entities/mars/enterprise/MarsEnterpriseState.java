package ru.attest.reactive_mongo.entities.mars.enterprise;

public enum MarsEnterpriseState {
    /***
     * Состояния версии предприятия: Актуальное(Опубликована), Редактирование(Создана, но не опубликована), Архивная
     */
    Actual{
        final private String state = "Actual";
        public String getState(){return state;}
    },
    Edited{
        final private String state = "Edited";
        public String getState(){return state;}
    },
    Archive{
        final private String state = "Archive";
        public String getState(){return state;}
    };
    public abstract String getState();
}
