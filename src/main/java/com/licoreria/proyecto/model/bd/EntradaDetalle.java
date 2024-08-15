package com.licoreria.proyecto.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.licoreria.proyecto.model.bd.pk.ProductoEntradaId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "entradetalle")
public class EntradaDetalle {
    @EmbeddedId
    private ProductoEntradaId id;
    private Integer cajas;
    private Integer unidxcajas;
    private Double precio;
    private Double subtotal;

    @ManyToOne
    @MapsId("idproducto")
    @JoinColumn(name = "idproducto")
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @MapsId("identrada")
    @JoinColumn(name = "identrada")
    @JsonBackReference
    private EntradaProducto entradaProducto;


}
