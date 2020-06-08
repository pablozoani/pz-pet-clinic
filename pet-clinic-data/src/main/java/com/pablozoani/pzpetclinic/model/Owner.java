package com.pablozoani.pzpetclinic.model;

import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public Owner setPets(Set<Pet> pets) {
        this.pets = pets;
        return this;
    }
}
