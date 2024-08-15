package com.licoreria.proyecto.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "entradaproducto")
public class EntradaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identrada;
    private String detalles;
    private Double total;
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;

    @ManyToOne
    @JoinColumn(name = "idcolaborador")
    private Colaborador colaborador;

    @OneToMany(mappedBy = "entradaProducto",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<EntradaDetalle> productos = new HashSet<>();

}
