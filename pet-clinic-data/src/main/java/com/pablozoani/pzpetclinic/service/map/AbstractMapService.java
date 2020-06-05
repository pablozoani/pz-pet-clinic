package com.pablozoani.pzpetclinic.service.map;

import com.pablozoani.pzpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T t) {
        if (t != null) {
            if (t.getId() == null) {
                t.setId(getNextId());
            }

            map.put(t.getId(), t);
        } else {
            throw new RuntimeException("t is null");
        }

        return t;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T t) {
        map.entrySet().removeIf(e -> e.getValue().equals(t));
    }

    private Long getNextId() {
        Long output = null;
        try {
            output = Collections.max(map.keySet()) + 1L;
        } catch (NoSuchElementException e) {
            output = 1L;
        }
        return output;
    }
}
