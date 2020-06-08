package com.pablozoani.pzpetclinic.model;

public class Specialty extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public Specialty setDescription(String description) {
        this.description = description;
        return this;
    }
}
