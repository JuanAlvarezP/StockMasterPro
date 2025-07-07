package com.stockmasterpro.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class DetalleVenta {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Required
    private Integer cantidad = 1;
    
    @Money @Required
    private BigDecimal precioUnitario;
    
    @Money @ReadOnly
    private BigDecimal subtotal;
    
    @ManyToOne(fetch = FetchType.LAZY) @Required
    private Producto producto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta venta;
    
    @PrePersist @PreUpdate
    private void calcularSubtotal() {
        if (precioUnitario != null && cantidad != null) {
            this.subtotal = precioUnitario.multiply(new BigDecimal(cantidad));
        }
    }
    
    public DetalleVenta() {}
    
    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
        calcularSubtotal();
    }
}