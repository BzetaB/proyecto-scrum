package com.licoreria.proyecto.service;


import com.licoreria.proyecto.model.bd.Clientes;
import com.licoreria.proyecto.model.dto.ClientesDto;

import java.util.List;

public interface IClienteService {
    List<ClientesDto> listarClientes();

    void guardarClientes(Clientes clientes);
}
