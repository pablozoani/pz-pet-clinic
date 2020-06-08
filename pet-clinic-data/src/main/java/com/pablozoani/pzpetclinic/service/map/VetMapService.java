package com.pablozoani.pzpetclinic.service.map;

import com.pablozoani.pzpetclinic.model.Vet;
import com.pablozoani.pzpetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyMapService specialtyMapService;

    @Autowired
    public VetMapService(SpecialtyMapService specialtyMapService) {
        this.specialtyMapService = specialtyMapService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (!vet.getSpecialties().isEmpty()) {
            vet.getSpecialties().forEach(specialty -> {
                if (specialty != null) {
                    if (specialty.getId() != null) {
                        specialtyMapService.save(specialty);
                    }
                } else {
                    throw new RuntimeException("null specialty");
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}