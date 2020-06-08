package com.pablozoani.pzpetclinic.bootstrap;

import com.pablozoani.pzpetclinic.model.Owner;
import com.pablozoani.pzpetclinic.model.PetType;
import com.pablozoani.pzpetclinic.model.Vet;
import com.pablozoani.pzpetclinic.service.OwnerService;
import com.pablozoani.pzpetclinic.service.PetTypeService;
import com.pablozoani.pzpetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("bootstrap data started");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner o1 = new Owner();
        o1.setFirstName("Peter");
        o1.setLastName("Parker");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Bruce");
        o2.setLastName("Wayne");
        ownerService.save(o2);

        Vet v1 = new Vet();
        v1.setFirstName("Tony");
        v1.setLastName("Stark");
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Frodo");
        v2.setLastName("Baggins");
        vetService.save(v2);

        System.out.println("bootstrap data ended");
    }
}
