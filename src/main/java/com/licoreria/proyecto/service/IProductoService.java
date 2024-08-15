package com.licoreria.proyecto.service;

import com.licoreria.proyecto.model.bd.Producto;
import com.licoreria.proyecto.model.dto.ProductoDto;

import java.util.List;

public interface IProductoService {

    List<ProductoDto> listarProductos();
    void guardar(ProductoDto productoDto);
    Producto obtenerProducto(Integer idproducto);
}
