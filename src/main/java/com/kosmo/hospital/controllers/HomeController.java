package com.kosmo.hospital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    @GetMapping("/")
    public String vistaPrincipal() {
        return "principal"; // Esto carga principal.jsp desde /WEB-INF/views/
    }
}
