package com.licoreria.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "despacho")
public class Despacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddespacho;
    private String apellidoreceptor;
    private String nombrereceptor;
    private Double costo;
    private String direccionsalida;
    private String direccionllegada;
    private String metodoenvio;
    private String telefonoreceptor;

    @ManyToOne
    @JoinColumn(name="idcolaborador")
    private Colaborador colaborador;

    @OneToOne
    @JoinColumn(name = "idcomprobante")
    private Comprobante comprobante;
}

