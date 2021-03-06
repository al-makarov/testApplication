package com.magical.SinglePageAplication.model;

/**
 * Сущность типа договора
 */
public class ContractType {
    private int id;
    private String name;

    public ContractType() {

    }
    public ContractType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
