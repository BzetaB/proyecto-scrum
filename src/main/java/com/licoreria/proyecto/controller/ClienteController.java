package com.licoreria.proyecto.controller;

import com.licoreria.proyecto.model.bd.Clientes;
import com.licoreria.proyecto.model.dto.ClientesDto;
import com.licoreria.proyecto.model.dto.RespuestaGeneral;
import com.licoreria.proyecto.service.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private IClienteService iClienteService;

    @GetMapping("")
    public String frmClientes(Model model){
        model.addAttribute("listclientes",
                iClienteService.listarClientes());

        return "clientes/frmclientes"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<ClientesDto> listarClientes(){
        return iClienteService.listarClientes();

    }


    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarCliente(@RequestBody Clientes clientes){
        String mensaje="Producto registrado correctamente";
        boolean resultado= true;
        try {
            iClienteService.guardarClientes(clientes);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }
}
