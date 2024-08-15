package com.licoreria.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoDto {
    private Integer idproducto;
    private String nombre;
    private Double precio;
    private String detalles;
    private Integer unidades;
    private boolean activo;
    private Integer stock;

    private Integer idcategoria;
    private String nomcategoria;
}
