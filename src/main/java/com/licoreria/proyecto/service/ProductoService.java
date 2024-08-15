package com.licoreria.proyecto.service;

import com.licoreria.proyecto.model.bd.Categoria;
import com.licoreria.proyecto.model.bd.Producto;
import com.licoreria.proyecto.model.dto.ProductoDto;
import com.licoreria.proyecto.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService{
    private ProductoRepository productoRepository;
    @Override
    public List<ProductoDto> listarProductos() {
        List<ProductoDto> productoDtoList = new ArrayList<>();
        for (Producto producto: productoRepository.findAll()){
            ProductoDto productoDto =
                    ProductoDto.builder()
                            .idproducto(producto.getIdproducto())
                            .nombre(producto.getNombre())
                            .precio(producto.getPrecio())
                            .detalles(producto.getDetalles())
                            .unidades(producto.getUnidades())
                            .activo(producto.isActivo())
                            .stock(producto.getStock())
                            .idcategoria(producto.getCategoria().getIdcategoria())
                            .nomcategoria(producto.getCategoria().getNomcategoria())
                            .build();
            productoDtoList.add(productoDto);

        }
        return productoDtoList;
    }

    @Override
    public void guardar(ProductoDto productoDto) {
        if (productoDto.getIdproducto()>0){
            productoRepository.actualizarProducto(
                    productoDto.getIdproducto(),
                    productoDto.getNombre(),
                    productoDto.getPrecio(),
                    productoDto.getDetalles(),
                    productoDto.getUnidades(),
                    productoDto.getIdcategoria(),
                    productoDto.isActivo()
            );
        }else {
            Producto nuevoProducto = new Producto();
            nuevoProducto.setNombre(productoDto.getNombre());
            nuevoProducto.setPrecio(productoDto.getPrecio());
            nuevoProducto.setDetalles(productoDto.getDetalles());
            nuevoProducto.setUnidades(productoDto.getUnidades());
            nuevoProducto.setActivo(true);

            Categoria categoria = new Categoria();
            categoria.setIdcategoria(productoDto.getIdcategoria());
            nuevoProducto.setCategoria(categoria);

            productoRepository.save(nuevoProducto);
        }
    }

    @Override
    public Producto obtenerProducto(Integer idproducto) {
        return productoRepository.findById(idproducto).orElse(null);
    }
}
