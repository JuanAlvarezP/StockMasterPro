package com.stockmasterpro.modelo;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Cliente {
    
    @Id @Column(length=10) @Required
    private String cedula;
    
    @Column(length=50) @Required
    private String nombre;
    
    @Column(length=100)
    private String direccion;
    
    @Column(length=20)
    private String telefono;
    
    @Email
    private String email;
    
    // Constructor simplificado para pruebas
    public Cliente() {}
    
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
}