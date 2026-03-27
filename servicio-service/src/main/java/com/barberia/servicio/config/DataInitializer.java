package com.barberia.servicio.config;

import com.barberia.servicio.model.Servicio;
import com.barberia.servicio.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ServicioRepository servicioRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Insertar datos solo si la tabla está vacía
        if (servicioRepository.count() == 0) {
            servicioRepository.save(new Servicio(
                "Corte de Cabello",
                "Corte completo de cabello con técnica profesional",
                120.0,
                30
            ));
            
            servicioRepository.save(new Servicio(
                "Barba",
                "Afeitado y arreglo de barba profesional",
                80.0,
                20
            ));
            
            servicioRepository.save(new Servicio(
                "Tinte",
                "Tinte de cabello con colorantes premium",
                250.0,
                60
            ));
            
            System.out.println("✅ 3 servicios de prueba han sido insertados en la base de datos.");
        }
    }
}
