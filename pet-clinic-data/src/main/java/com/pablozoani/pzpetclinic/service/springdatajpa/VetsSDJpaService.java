package com.pablozoani.pzpetclinic.service.springdatajpa;

import com.pablozoani.pzpetclinic.model.Vet;
import com.pablozoani.pzpetclinic.repository.VetRepository;
import com.pablozoani.pzpetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetsSDJpaService implements VetService {

    private final VetRepository vetRepository;

    @Autowired
    public VetsSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> output = new HashSet<>();
        vetRepository.findAll().forEach(output::add);
        return output;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
