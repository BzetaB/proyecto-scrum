package com.licoreria.proyecto.service;

import com.licoreria.proyecto.model.bd.Clientes;
import com.licoreria.proyecto.model.bd.Producto;
import com.licoreria.proyecto.model.bd.TipoDocumentoCliente;
import com.licoreria.proyecto.model.dto.ClientesDto;
import com.licoreria.proyecto.model.dto.ProductoDto;
import com.licoreria.proyecto.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class ClienteService implements IClienteService{
    private ClienteRepository clienteRepository;
    @Override
    public List<ClientesDto> listarClientes() {
        List<ClientesDto> clientesDtoList = new ArrayList<>();
        for (Clientes clientes: clienteRepository.findAll()){
            ClientesDto clientesDto =
                    ClientesDto.builder()
                            .idcliente(clientes.getIdcliente())
                            .iddocumento(clientes.getTipoDocumentoCliente().getIddocumento())
                            .tipodocumento(clientes.getTipoDocumentoCliente().getTipodocumento())
                            .documento(clientes.getDocumento())
                            .nombres(clientes.getNombres())
                            .apellidos(clientes.getApellidos())
                            .telefono(clientes.getTelefono())
                            .correo(clientes.getCorreo())
                            .fechanacimiento(clientes.getFechanacimiento())
                            .sexo(clientes.isSexo())
                            .direccion(clientes.getDireccion())
                            .username(clientes.getUsername())
                            .build();
            clientesDtoList.add(clientesDto);

        }
        return clientesDtoList;
    }

    @Override
    public void guardarClientes(Clientes clientes) {
        if (clientes.getIdcliente()>0){
            clienteRepository.actualizarCliente(
                    clientes.getNombres(),
                    clientes.getApellidos(),
                    clientes.getTelefono(),
                    clientes.getCorreo(),
                    clientes.getIdcliente()
            );
        }else {
            Clientes clienteNuevo = new Clientes();
            clienteNuevo.setNombres(clientes.getNombres());
            clienteNuevo.setApellidos(clientes.getApellidos());
            clienteNuevo.setDocumento(clientes.getDocumento());
            clienteNuevo.setTelefono(clientes.getTelefono());
            clienteNuevo.setCorreo(clientes.getCorreo());
            clienteNuevo.setFechanacimiento(clientes.getFechanacimiento());
            clienteNuevo.setSexo(clientes.isSexo());
            clienteNuevo.setDireccion(clientes.getDireccion());
            clienteNuevo.setUsername(clientes.getUsername());
            clienteNuevo.setPassword(clientes.getPassword());
            clienteRepository.save(clienteNuevo);
        }

    }
}
