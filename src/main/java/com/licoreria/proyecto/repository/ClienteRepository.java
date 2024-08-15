package com.licoreria.proyecto.repository;

import com.licoreria.proyecto.model.bd.Clientes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository
        extends JpaRepository<Clientes, Integer> {
    Clientes findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clientes SET nombres =:nombres,"+
            "apellidos =:apellidos, telefono =:telefono, " +
            "correo =:correo where "+
            "idcliente =:idcliente",nativeQuery = true)
    void actualizarCliente(@Param("nombres") String nombres,
                           @Param("apellidos") String apellidos,
                           @Param("telefono") String telefono,
                           @Param("correo") String correo,
                           @Param("idcliente") Integer idcliente);
}
