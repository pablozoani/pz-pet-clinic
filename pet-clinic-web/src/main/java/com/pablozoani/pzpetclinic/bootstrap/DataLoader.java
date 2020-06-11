package com.pablozoani.pzpetclinic.bootstrap;

import com.pablozoani.pzpetclinic.model.*;
import com.pablozoani.pzpetclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("bootstrap data started");

        /*
        int petCount = petTypeService.findAll().size();
        if (petCount == 0) {
            loadData();
        }*/

        loadData();

        System.out.println("bootstrap data ended");
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner o1 = new Owner();
        o1.setFirstName("Peter");
        o1.setLastName("Parker");
        o1.setAddress("street1 984");
        o1.setCity("Dubai");
        o1.setTelephone("+97199992868");

        Pet petersDog = new Pet();
        petersDog.setName("Fluffy");
        petersDog.setBirthDate(LocalDate.of(2012, Month.JANUARY, 12));
        petersDog.setPetType(dog);
        o1.addPet(petersDog);

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Bruce");
        o2.setLastName("Wayne");
        o2.setAddress("street2 287");
        o2.setCity("Buenos Aires");
        o2.setTelephone("+5429749718");

        Pet brucesCat = new Pet();
        brucesCat.setName("Mish");
        brucesCat.setBirthDate(LocalDate.of(2017, Month.APRIL, 24));
        brucesCat.setPetType(cat);
        o2.addPet(brucesCat);

        ownerService.save(o2);

        Visit visit1 = new Visit();
        visit1.setPet(brucesCat);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Bruce's Cat is OK.");
        visitService.save(visit1);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        specialtyService.save(surgery);

        Vet v1 = new Vet();
        v1.setFirstName("Tony");
        v1.setLastName("Stark");
        v1.getSpecialties().add(dentistry);
        v1.getSpecialties().add(radiology);
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Frodo");
        v2.setLastName("Baggins");
        v2.getSpecialties().add(surgery);
        vetService.save(v2);
    }
}
