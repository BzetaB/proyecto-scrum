package com.licoreria.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    private String documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    private boolean sexo;
    private String direccion;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name="iddocumento")
    private TipoDocumentoCliente tipoDocumentoCliente;

}
