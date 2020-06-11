package com.pablozoani.pzpetclinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
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
        return Collections.unmodifiableSet(pets);
    }

    public Owner addPet(Pet pet) {
        if (pet == null) {
            throw new RuntimeException("pet cannot be null");
        }
        if (pet.getOwner() != null) {
            throw new RuntimeException("this pet already has an owner");
        }
        pet.setOwner(this);
        this.pets.add(pet);
        return this;
    }
}
