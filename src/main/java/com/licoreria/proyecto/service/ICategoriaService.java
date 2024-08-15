package com.licoreria.proyecto.service;

import com.licoreria.proyecto.model.bd.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> listarCateogorias();
    void guardarCategoria(Categoria categoria);
}
