package com.licoreria.proyecto.model.bd.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProductoVentaId implements Serializable {
    private Integer idproducto;
    private Integer idventa;
}
