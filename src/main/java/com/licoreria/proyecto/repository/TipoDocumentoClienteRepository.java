package com.licoreria.proyecto.repository;

import com.licoreria.proyecto.model.bd.TipoDocumentoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoClienteRepository
        extends JpaRepository<TipoDocumentoCliente, Integer> {
}
