package com.licoreria.proyecto.controller;

import com.licoreria.proyecto.model.dto.ProductoDto;
import com.licoreria.proyecto.model.dto.RespuestaGeneral;
import com.licoreria.proyecto.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductoController {
    private IProductoService iProductoService;

    @GetMapping("")
    public String frmProducto(Model model){
        model.addAttribute("listproducto",
                iProductoService.listarProductos());
        return "producto/frmproducto";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<ProductoDto> listarproductos(){
        return iProductoService.listarProductos();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarProducto(@RequestBody ProductoDto productoDto){
        String mensaje="Producto registrado correctamente";
        boolean resultado= true;
        try {
            iProductoService.guardar(productoDto);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }


}
