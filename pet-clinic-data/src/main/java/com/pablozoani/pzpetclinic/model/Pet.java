package com.pablozoani.pzpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder @Entity
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();

    public Set<Visit> getVisits() {
        return Collections.unmodifiableSet(visits);
    }

    public Pet addVisits(Visit... visits) {
        for (Visit visit : visits) {
            if (visit == null) {
                throw new RuntimeException("null visit");
            }
            if (visit.getPet() != null) {
                throw new RuntimeException("visit already has a pet");
            }
            this.visits.add(visit);
            visit.setPet(this);
        }
        return this;
    }
}
