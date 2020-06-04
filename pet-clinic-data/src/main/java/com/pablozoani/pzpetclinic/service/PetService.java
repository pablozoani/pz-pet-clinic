package com.pablozoani.pzpetclinic.service;

import com.pablozoani.pzpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
