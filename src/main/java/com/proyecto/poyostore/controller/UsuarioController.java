package com.proyecto.poyostore.controller;

import com.proyecto.poyostore.model.Usuario;
import com.proyecto.poyostore.repository.mdbUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Inyectamos la interfaz de usuario con @Autowired
    @Autowired
    private mdbUsuarioRepository usuarioRepo;

    // Guardar un usuario en la base de datos
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Usuario usuario){
        try{
            usuario = usuarioRepo.save(usuario);
            return new ResponseEntity<String>("Usuario creado correctamente", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>("Error al crear al Usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
