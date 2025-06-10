package com.stockmasterpro.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Producto {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Column(length=20) @Required
    private String codigo;
    
    @Column(length=100) @Required
    private String nombre;
    
    @Column(length=500)
    private String descripcion;
    
    @Money @Required
    private BigDecimal precio;
    
    @Money @ReadOnly
    private BigDecimal precioConIva;
    
    @Money @ReadOnly
    private BigDecimal valorIva;
    
    @Money @ReadOnly
    private BigDecimal precioFinal; // Precio con IVA y descuento
    
    @Stereotype("PORCENTAJE")
    private BigDecimal descuento = BigDecimal.ZERO;
    
    @Required
    private Integer stockActual = 0;
    
    @Required
    private Integer stockMinimo = 5;
    
    @ReadOnly
    private Date fechaCreacion = new Date();
    
    private Date fechaActualizacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Categoria categoria;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    private Proveedor proveedorPrincipal;
    
    @PrePersist
    @PreUpdate
    private void calcularPrecios() {
        this.fechaActualizacion = new Date();
        
        // 1. Cálculo del IVA al 15%
        calcularIva();
        
        // 2. Aplicar descuento si existe
        aplicarDescuento();
    }
    
    private void calcularIva() {
        if (this.precio != null) {
            this.valorIva = this.precio.multiply(new BigDecimal("0.15"))
                               .setScale(2, RoundingMode.HALF_UP);
            this.precioConIva = this.precio.add(this.valorIva)
                                   .setScale(2, RoundingMode.HALF_UP);
        }
    }
    
    public void aplicarDescuento() {
        if (this.precioConIva != null && this.descuento != null) {
            BigDecimal montoDescuento = this.precioConIva.multiply(this.descuento)
                                              .setScale(2, RoundingMode.HALF_UP);
            this.precioFinal = this.precioConIva.subtract(montoDescuento);
        } else {
            this.precioFinal = this.precioConIva;
        }
    }
    
    

}