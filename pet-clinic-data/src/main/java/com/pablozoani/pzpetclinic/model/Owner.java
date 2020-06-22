package com.pablozoani.pzpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor
@Entity
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();

    public Set<Pet> getPets() {
        return pets;
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
