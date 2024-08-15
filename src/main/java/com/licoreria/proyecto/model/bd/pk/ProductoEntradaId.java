package com.licoreria.proyecto.model.bd.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProductoEntradaId implements Serializable {
    private Integer identrada;
    private Integer idproducto;
}
