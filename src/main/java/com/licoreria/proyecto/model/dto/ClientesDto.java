package com.licoreria.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class ClientesDto {
    private Integer idcliente;

    private String documento;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private Date fechanacimiento;
    private boolean sexo;
    private String direccion;
    private String username;
    private String password;

    private Integer iddocumento;
    private String tipodocumento;

}
