package com.pablozoani.pzpetclinic.repository;

import com.pablozoani.pzpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
