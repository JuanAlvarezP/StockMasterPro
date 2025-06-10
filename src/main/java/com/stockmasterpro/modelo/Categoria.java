package com.stockmasterpro.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Categoria {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Column(length=50) @Required
    private String nombre;

    @Column(length=200)
    private String descripcion;
    
    @Stereotype("PORCENTAJE")
    @ReadOnly
    private BigDecimal porcentajeIva = new BigDecimal("0.15"); // IVA fijo al 15%
    
    @OneToMany(mappedBy="categoria")
    @ListProperties("codigo, nombre, precio, precioConIva")
    private Collection<Producto> productos;
}