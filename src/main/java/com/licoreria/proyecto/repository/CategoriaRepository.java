package com.licoreria.proyecto.repository;

import com.licoreria.proyecto.model.bd.Categoria;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE categoria SET nomcategoria = :nomcategoria WHERE idcategoria = :idcategoria", nativeQuery = true)
    void actualizarCategoria(@Param("idcategoria") Integer idcategoria,
                             @Param("nomcategoria") String nomcategoria);

}
