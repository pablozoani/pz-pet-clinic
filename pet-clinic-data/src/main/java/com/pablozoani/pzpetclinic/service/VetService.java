package com.pablozoani.pzpetclinic.service;

import com.pablozoani.pzpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
