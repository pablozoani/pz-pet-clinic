package com.pablozoani.pzpetclinic.bootstrap;

import com.pablozoani.pzpetclinic.model.Owner;
import com.pablozoani.pzpetclinic.model.Vet;
import com.pablozoani.pzpetclinic.service.OwnerService;
import com.pablozoani.pzpetclinic.service.VetService;
import com.pablozoani.pzpetclinic.service.map.OwnerMapService;
import com.pablozoani.pzpetclinic.service.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Peter");
        o1.setLastName("Parker");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("Bruce");
        o2.setLastName("Wayne");
        ownerService.save(o2);

        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("Tony");
        v1.setLastName("Stark");
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("Frodo");
        v2.setLastName("Baggins");
        vetService.save(v2);
    }
}
