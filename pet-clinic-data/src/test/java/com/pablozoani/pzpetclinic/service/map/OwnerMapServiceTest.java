package com.pablozoani.pzpetclinic.service.map;

import com.pablozoani.pzpetclinic.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Owner owner;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        owner = Owner.builder().
            id(1L).firstName("Pablo").lastName("Zoani").city("CABA").build();
        ownerMapService.save(owner);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("Zoani");
        assertEquals(1L, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertTrue(!owners.isEmpty());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);
        assertEquals("Pablo", owner.getFirstName());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().
            id(2L).
                               firstName("Ringo").
                               build();
        ownerMapService.save(owner);
        Owner owner2 = ownerMapService.findById(2L);
        assertEquals(owner, owner2);
    }

    @Test
    void delete() {
        ownerMapService.delete(owner);
        Owner nullOwner = ownerMapService.findById(1L);
        assertNull(nullOwner);
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        Owner nullOwner = ownerMapService.findById(1L);
        assertNull(nullOwner);
    }
}