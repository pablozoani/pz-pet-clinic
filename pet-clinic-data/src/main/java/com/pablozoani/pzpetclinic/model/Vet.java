package com.pablozoani.pzpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public Vet setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
        return this;
    }
}
