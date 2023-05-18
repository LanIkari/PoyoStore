package com.proyecto.poyostore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acceso")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/registroxd")
    public String registro() {
        return "registro";
    }

    @GetMapping("/autenticacion")
    public String acceso() {
        return "autenticacion";
    }
}