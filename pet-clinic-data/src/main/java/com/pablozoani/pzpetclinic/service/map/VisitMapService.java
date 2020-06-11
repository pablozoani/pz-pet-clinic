package com.pablozoani.pzpetclinic.service.map;

import com.pablozoani.pzpetclinic.model.Visit;
import com.pablozoani.pzpetclinic.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit t) {
        if (t.getPet() == null || t.getPet().getId() == null ||
            t.getPet().getOwner() == null || t.getPet().getOwner().getId() == null) {
            throw new RuntimeException("invalid visit");
        }
        return super.save(t);
    }

    @Override
    public void delete(Visit t) {
        super.delete(t);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
