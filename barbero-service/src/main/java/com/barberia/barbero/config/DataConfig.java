package com.barberia.barbero.config;

import com.barberia.barbero.model.Barbero;
import com.barberia.barbero.repository.BarberoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    
    @Bean
    public CommandLineRunner initData(BarberoRepository barberoRepository) {
        return args -> {
            // Insertar datos solo si la tabla está vacía
            if (barberoRepository.count() == 0) {
                barberoRepository.save(new Barbero("Bryan", "Cortes profesionales", "+34 612 456 789"));
                barberoRepository.save(new Barbero("Rodolfo", "Especialista en barbas", "+34 612 456 790"));
                barberoRepository.save(new Barbero("Axel", "Tintes y coloración", "+34 612 456 791"));
                
                System.out.println("✅ 3 barberos de prueba han sido insertados en la base de datos.");
            }
        };
    }
}
