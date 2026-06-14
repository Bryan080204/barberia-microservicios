package com.barberia.barbero.controller;

import com.barberia.barbero.model.Barbero;
import com.barberia.barbero.repository.BarberoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BarberoController {
    
    @Autowired
    private BarberoRepository barberoRepository;

    @GetMapping("/lista")
    public List<Barbero> getBarberos() {
        return barberoRepository.findAll();
    }
}