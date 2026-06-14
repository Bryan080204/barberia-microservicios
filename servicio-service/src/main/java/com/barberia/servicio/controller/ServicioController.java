package com.barberia.servicio.controller;

import com.barberia.servicio.model.Servicio;
import com.barberia.servicio.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ServicioController {
    
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/lista")
    public List<Servicio> getServicios() {
        return servicioRepository.findAll();
    }
}
