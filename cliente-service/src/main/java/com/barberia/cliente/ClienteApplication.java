package com.barberia.cliente;

import com.barberia.cliente.model.Cliente;
import com.barberia.cliente.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClienteApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner initData(ClienteRepository clienteRepository) {
        return args -> {
            // Insertar datos solo si la tabla está vacía
            if (clienteRepository.count() == 0) {
                clienteRepository.save(new Cliente("Bryan", "+34 612 456 789"));
                clienteRepository.save(new Cliente("Rodolfo", "+34 612 456 790"));
                clienteRepository.save(new Cliente("Axel", "+34 612 456 791"));
                
                System.out.println("✅ 3 clientes de prueba han sido insertados en la base de datos.");
            }
        };
    }
}
