package com.pablozoani.pzpetclinic.service.map;

import com.pablozoani.pzpetclinic.model.Owner;
import com.pablozoani.pzpetclinic.service.OwnerService;
import com.pablozoani.pzpetclinic.service.PetService;
import com.pablozoani.pzpetclinic.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    @Autowired
    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(final Owner owner) {
        if (owner != null) {
            owner.getPets().forEach(pet -> {
                if (pet.getId() == null) {
                    petService.save(pet);
                } else if (!pet.getOwner().equals(owner)) {
                    throw new RuntimeException("this pet has another owner");
                }
                if (pet.getOwner() == null) {
                    pet.setOwner(owner);
                }
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        petTypeService.save(pet.getPetType());
                    }
                } else {
                    throw new RuntimeException("null pet type");
                }
            });
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
