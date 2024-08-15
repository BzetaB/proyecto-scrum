package com.licoreria.proyecto.service;

import com.licoreria.proyecto.model.bd.Categoria;
import com.licoreria.proyecto.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaService implements ICategoriaService{
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCateogorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        if (categoria.getIdcategoria()>0){
            categoriaRepository.actualizarCategoria(
                    categoria.getIdcategoria(),
                    categoria.getNomcategoria()
            );
        }else {
                Categoria nuevaCategoria = new Categoria();
                nuevaCategoria.setNomcategoria(categoria.getNomcategoria());
                categoriaRepository.save(nuevaCategoria);
        }
    }
}
