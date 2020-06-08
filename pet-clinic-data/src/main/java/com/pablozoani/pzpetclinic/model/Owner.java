package com.pablozoani.pzpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public Owner setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Owner setCity(String city) {
        this.city = city;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Owner setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public Owner setPets(Set<Pet> pets) {
        this.pets = pets;
        return this;
    }
}
