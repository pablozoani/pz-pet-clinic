package com.pablozoani.pzpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Specialty extends BaseEntity {

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public Specialty setDescription(String description) {
        this.description = description;
        return this;
    }
}
