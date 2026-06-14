package com.barberia.pago.config;

import com.barberia.pago.model.Pago;
import com.barberia.pago.repository.PagoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    
    @Bean
    public CommandLineRunner initData(PagoRepository pagoRepository) {
        return args -> {
            // Insertar datos solo si la tabla está vacía
            if (pagoRepository.count() == 0) {
                pagoRepository.save(new Pago("Efectivo", 150.0, "Completado"));
                pagoRepository.save(new Pago("Tarjeta Crédito", 200.0, "Completado"));
                pagoRepository.save(new Pago("Transferencia", 350.0, "Pendiente"));
                
                System.out.println("✅ 3 pagos de prueba han sido insertados en la base de datos.");
            }
        };
    }
}
