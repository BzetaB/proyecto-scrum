package com.licoreria.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomprobante;
    private String clienteruc;
    private String razonsocial;
    private boolean estado;
    private Date fechaemision;
    private Integer numerocomprobante;

    @OneToOne
    @JoinColumn(name="idventa")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name="idfacturacion")
    private Facturacion facturacion;
}
