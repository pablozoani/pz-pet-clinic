package com.pablozoani.pzpetclinic.service.springdatajpa;

import com.pablozoani.pzpetclinic.model.Owner;
import com.pablozoani.pzpetclinic.repository.OwnerRepository;
import com.pablozoani.pzpetclinic.repository.PetRepository;
import com.pablozoani.pzpetclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner pablo = Owner.builder()
             .id(1L)
             .firstName("Pablo")
             .lastName("Zoani")
             .build();

        when(ownerRepository.findByLastName(any())).thenReturn(pablo);

        Owner output = service.findByLastName("Zoani");

        assertEquals(pablo, output);

        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Owner pablo = Owner.builder()
                           .id(1L)
                           .firstName("Pablo")
                           .lastName("Zoani")
                           .build();
        Owner bruce = Owner.builder()
                           .id(2L)
                           .firstName("Bruce")
                           .lastName("Wayne")
                           .build();
        Set<Owner> ownersMock = new HashSet<>();
        ownersMock.add(pablo);
        ownersMock.add(bruce);

        when(ownerRepository.findAll()).thenReturn(ownersMock);

        Set<Owner> owners = service.findAll();
        assertEquals(ownersMock, owners);
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Owner pablo = Owner.builder()
                           .id(1L)
                           .firstName("Pablo")
                           .lastName("Zoani")
                           .build();
        when(ownerRepository.findById(any())).thenReturn(Optional.of(pablo));
        Owner output = service.findById(1L);
        assertEquals(pablo, output);
        verify(ownerRepository, times(1)).findById(any());
    }

    @Test
    void save() {
        Owner pablo = Owner.builder()
                           .id(1L)
                           .firstName("Pablo")
                           .lastName("Zoani")
                           .build();
        when(ownerRepository.save(any())).thenReturn(pablo);
        Owner output = service.save(pablo);
        assertEquals(pablo, output);
        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        Owner pablo = Owner.builder()
                           .id(1L)
                           .firstName("Pablo")
                           .lastName("Zoani")
                           .build();
        service.delete(pablo);
        verify(ownerRepository, times(1)).delete(pablo);
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(1L);
    }
}