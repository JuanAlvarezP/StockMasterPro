package com.stockmasterpro.modelo;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(members=
"datos[" +
"  codigo, nombre;" +
"  precio, descuento, tipoDescuento;" +
"  valorIva, precioConIva, precioFinal;" +
"]"
)
public class Producto {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Column(length=20) @Required
    private String codigo;
    
    @Column(length=100) @Required
    private String nombre;
    
    @Money @Required
    private BigDecimal precio;
    
    @Money @ReadOnly
    private BigDecimal valorIva;
    
    @Money @ReadOnly
    private BigDecimal precioConIva;
    
    @Money @ReadOnly
    private BigDecimal precioFinal;
    
    @Stereotype("PORCENTAJE")
    private BigDecimal descuento = BigDecimal.ZERO;
    
    @Transient @ReadOnly
    @Depends("descuento")
    private String tipoDescuento;
    
    @ReadOnly
    private Date fechaCreacion = new Date();
    
    private Date fechaActualizacion;

    // ===== CÁLCULOS PRINCIPALES ===== //
    @PrePersist
    @PreUpdate
    private void calcularPrecios() {
        this.fechaActualizacion = new Date();
        calcularIva();
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
    
    private void aplicarDescuento() {
        if (this.precioConIva != null && this.descuento != null) {
            BigDecimal montoDescuento = this.precioConIva.multiply(this.descuento)
                                              .setScale(2, RoundingMode.HALF_UP);
            this.precioFinal = this.precioConIva.subtract(montoDescuento);
        } else {
            this.precioFinal = this.precioConIva;
        }
    }
    
    public String determinarTipoDescuento() {
        if (this.descuento == null || this.descuento.compareTo(BigDecimal.ZERO) == 0) {
            return "SIN_DESCUENTO";
        } else if (this.descuento.compareTo(new BigDecimal("0.10")) <= 0) {
            return "DESCUENTO_NORMAL (hasta 10%)";
        } else if (this.descuento.compareTo(new BigDecimal("0.20")) <= 0) {
            return "DESCUENTO_ESPECIAL (11-20%)";
        } else {
            return "DESCUENTO_EXTRA (más de 20%)";
        }
    }
    
    public String getTipoDescuento() {
        return determinarTipoDescuento();
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id")  // Añadido para clarificar la columna
    @DescriptionsList
    private Proveedor proveedor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")  // Columna en la tabla producto
    @DescriptionsList
    private Categoria categoria;
}