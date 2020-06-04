package com.pablozoani.pzpetclinic.model;

public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
