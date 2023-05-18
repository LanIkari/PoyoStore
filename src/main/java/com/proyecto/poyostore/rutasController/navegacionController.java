package com.proyecto.poyostore.rutasController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navegacionController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/seguridad")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("Seguridad Integrada");
    }
}
