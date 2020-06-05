package com.pablozoani.pzpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/vets"})
@Controller
public class VetController {

    @GetMapping({""})
    public String listVets() {
        return "vets/index";
    }
}