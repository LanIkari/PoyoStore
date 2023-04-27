package com.proyecto.poyostore.rutasController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navegacionController {

    @GetMapping("/")
    public String index(){return "index";}
}