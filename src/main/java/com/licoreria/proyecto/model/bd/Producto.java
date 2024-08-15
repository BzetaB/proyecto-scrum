package com.licoreria.proyecto.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;
    private String nombre;
    private Double precio;
    private Integer stock;
    private String detalles;
    private Integer unidades;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="idcategoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<DetalleVenta> ventas = new HashSet<>();

    @OneToMany(mappedBy = "producto",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<EntradaDetalle> entrada = new HashSet<>();
}
