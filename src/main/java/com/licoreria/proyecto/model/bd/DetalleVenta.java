package com.licoreria.proyecto.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.licoreria.proyecto.model.bd.pk.ProductoVentaId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalleventa")
public class DetalleVenta {
    @EmbeddedId
    private ProductoVentaId id;
    private Integer cantidad;
    private Double precio;
    private Double subtotal;

    @ManyToOne
    @MapsId("idproducto")
    @JoinColumn(name = "idproducto")
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @MapsId("idventa")
    @JoinColumn(name = "idventa")
    @JsonBackReference
    private Venta venta;

}
