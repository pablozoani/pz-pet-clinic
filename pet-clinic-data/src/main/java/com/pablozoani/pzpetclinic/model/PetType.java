package com.pablozoani.pzpetclinic.model;

public class PetType extends BaseEntity {

    private String name;

    public PetType() {
    }

    public String getName() {
        return name;
    }

    public PetType setName(String name) {
        this.name = name;
        return this;
    }
}
