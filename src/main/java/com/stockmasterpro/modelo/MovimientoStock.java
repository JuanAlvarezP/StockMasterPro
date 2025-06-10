package com.stockmasterpro.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity 
@Getter @Setter
@View(members = 
    "datosGenerales[tipo, fecha, producto;" +
    "numeroDocumento, cantidad, observaciones];" +
    "relaciones[ordenCompra, venta]"
)
@Tab(properties = "fecha, tipo, producto.nombre, cantidad, numeroDocumento")
public class MovimientoStock {
    
    public enum TipoMovimiento {
        ENTRADA, 
        SALIDA, 
        AJUSTE, 
        COMPRA,
        VENTA
    } 
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length=20) @Required
    private TipoMovimiento tipo;
    
    @ManyToOne(fetch = FetchType.LAZY) @Required
    @DescriptionsList(descriptionProperties = "codigo,nombre")
    private Producto producto;
    
    @Required
    private Integer cantidad;
    
    @Required
    private Date fecha = new Date();
    
    @Column(length=20)
    private String numeroDocumento;
    
    @Column(length=500)
    private String observaciones;
    
    // Relación con OrdenCompra (para movimientos de compra)
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenCompra ordenCompra;
    
    // Relación con Venta (para movimientos de venta)
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta venta;
    
    // Constructor para movimientos de compra
    public MovimientoStock(OrdenCompra orden, Producto producto, int cantidad) {
        this.tipo = TipoMovimiento.COMPRA;
        this.ordenCompra = orden;
        this.producto = producto;
        this.cantidad = cantidad;
        this.numeroDocumento = orden.getNumero();
        this.observaciones = "Recepción de compra";
    }
    
    // Constructor para movimientos de venta
    public MovimientoStock(Venta venta, Producto producto, int cantidad) {
        this.tipo = TipoMovimiento.VENTA;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.numeroDocumento = venta.getNumero();
        this.observaciones = "Venta confirmada";
    }
    
    // Constructor para ajustes manuales
    public MovimientoStock(Producto producto, int cantidad, String motivo) {
        this.tipo = cantidad > 0 ? TipoMovimiento.ENTRADA : TipoMovimiento.SALIDA;
        this.producto = producto;
        this.cantidad = Math.abs(cantidad);
        this.observaciones = "Ajuste manual: " + motivo;
    }
    
    public MovimientoStock() {} // Constructor por defecto
}