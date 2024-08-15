package com.licoreria.proyecto.controller;

import com.licoreria.proyecto.model.bd.Categoria;
import com.licoreria.proyecto.model.dto.RespuestaGeneral;
import com.licoreria.proyecto.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    private ICategoriaService iCategoriaService;

    @GetMapping("")
    public String frmCategoria(Model model){
        model.addAttribute("listcategoria",
                iCategoriaService.listarCateogorias());
        return "producto/frmcategoria";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Categoria> listarCategorias(){
        return iCategoriaService.listarCateogorias();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarCategoria(@RequestBody Categoria categoria){
        String mensaje="Categoria registrada correctamente";
        boolean resultado= true;
        try {
            iCategoriaService.guardarCategoria(categoria);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }



}
