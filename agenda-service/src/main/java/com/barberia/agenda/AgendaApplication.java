package com.barberia.agenda;

import com.barberia.agenda.model.Cita;
import com.barberia.agenda.repository.CitaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class AgendaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AgendaApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner initData(CitaRepository citaRepository) {
        return args -> {
            // Insertar datos solo si la tabla está vacía
            if (citaRepository.count() == 0) {
                citaRepository.save(new Cita(LocalDate.of(2026, 3, 27), "10:00", "Juan Antonio", "Bryan"));
                citaRepository.save(new Cita(LocalDate.of(2026, 3, 27), "11:00", "Axel", "Rodolfo"));
                citaRepository.save(new Cita(LocalDate.of(2026, 3, 28), "14:30", "Rodolfo", "Bryan"));
                
                System.out.println("✅ 3 citas de prueba han sido insertadas en la base de datos.");
            }
        };
    }
}
