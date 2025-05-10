package com.kosmo.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")

public class vistaController {
    @GetMapping("/consulta")
    public String mostrarConsulta() {
        return "hospital";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar() {
        return "agregarCita";
    }
}
