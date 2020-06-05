package com.pablozoani.pzpetclinic.service;

import com.pablozoani.pzpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}