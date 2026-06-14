package com.barberia.agenda.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "citas")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDate fecha;
    
    @Column(nullable = false)
    private String hora;
    
    @Column(nullable = false)
    private String cliente;
    
    @Column(nullable = false)
    private String barbero;
    
    // Constructor vacío
    public Cita() {}
    
    // Constructor con parámetros
    public Cita(LocalDate fecha, String hora, String cliente, String barbero) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.barbero = barbero;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    
    public String getBarbero() { return barbero; }
    public void setBarbero(String barbero) { this.barbero = barbero; }
}
