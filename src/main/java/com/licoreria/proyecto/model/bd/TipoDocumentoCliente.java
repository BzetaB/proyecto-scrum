package com.licoreria.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipoDocumentoCliente")
public class TipoDocumentoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocumento;
    private String tipodocumento;
}
