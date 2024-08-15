package com.licoreria.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menuprincipal")
public class MenuPrincipalController {
    @GetMapping("")
    public String menuPrincipal() {
        return "menuprincipal";
    }
}
