package com.licoreria.proyecto.repository;

import com.licoreria.proyecto.model.bd.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET nombre=:nombre," +
            " precio=:precio,"+
            "detalles=:detalles,"+
            "unidades=:unidades,"+
            "activo=:activo, " +
            "idcategoria=:idcategoria "+
            "where idproducto = :idproducto",nativeQuery = true)
    void actualizarProducto(@Param("idproducto")Integer idproducto,
                            @Param("nombre")String nombre,
                            @Param("precio")Double precio,
                            @Param("detalles")String detalles,
                            @Param("unidades")Integer unidades,
                            @Param("idcategoria")Integer idcategoria,
                            @Param("activo")boolean activo);

}
