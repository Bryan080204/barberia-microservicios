package com.barberia.agenda.controller;

import com.barberia.agenda.model.Cita;
import com.barberia.agenda.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/lista")
public class AgendaController {
    
    @Autowired
    private CitaRepository citaRepository;

    @GetMapping
    public List<Cita> getCitas() {
        return citaRepository.findAll();
    }
}
