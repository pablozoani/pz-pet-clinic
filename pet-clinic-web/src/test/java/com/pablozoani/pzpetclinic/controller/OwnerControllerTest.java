package com.pablozoani.pzpetclinic.controller;

import com.pablozoani.pzpetclinic.model.Owner;
import com.pablozoani.pzpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController controller;
    Set<Owner> owners;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).firstName("Pablo").lastName("Zoani").build());
        owners.add(Owner.builder().id(2L).firstName("Clark").lastName("Kent").build());
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners/")).
            andExpect(status().isOk()).
            andExpect(view().name("owners/index")).
            andExpect(model().attribute("owners", owners)).
            andExpect(model().attribute("owners", hasSize(2)));
        verify(ownerService, times(1)).findAll();
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find")).
            andExpect(status().isOk()).
            andExpect(view().name("notimplemented"));
        verifyNoInteractions(ownerService);
    }
}