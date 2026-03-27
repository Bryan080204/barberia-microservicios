package com.barberia.pago.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Pago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String metodoPago;
    
    @Column(nullable = false)
    private Double monto;
    
    @Column(nullable = false)
    private String estado;

    // Constructor vacío
    public Pago() {}

    // Constructor con parámetros
    public Pago(String metodoPago, Double monto, String estado) {
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    
    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
