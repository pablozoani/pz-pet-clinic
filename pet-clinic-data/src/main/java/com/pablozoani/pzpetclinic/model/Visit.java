package com.pablozoani.pzpetclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public Visit setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Visit setDescription(String description) {
        this.description = description;
        return this;
    }

    public Pet getPet() {
        return pet;
    }

    public Visit setPet(Pet pet) {
        this.pet = pet;
        return this;
    }
}
