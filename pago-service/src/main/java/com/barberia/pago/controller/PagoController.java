package com.barberia.pago.controller;

import com.barberia.pago.model.Pago;
import com.barberia.pago.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/lista")
public class PagoController {
    
    @Autowired
    private PagoRepository pagoRepository;

    @GetMapping
    public List<Pago> getPagos() {
        return pagoRepository.findAll();
    }
}