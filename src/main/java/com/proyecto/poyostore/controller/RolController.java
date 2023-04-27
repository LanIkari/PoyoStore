package com.proyecto.poyostore.controller;

import com.proyecto.poyostore.model.Rol;
import com.proyecto.poyostore.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService RolService;

    //Obtener todos los roles
    @GetMapping
    //En ResponseEntity indicamos que puede recibir cualquier dato con:"?"
    public ResponseEntity<?> getAllRoles() {
        try {
            //Debido a que necesitamos una lista de roles, hacemos uso de la interfaz de usuario para obtener todos
            //los roles con el metodo findAll()
            return new ResponseEntity<List<Rol>>(RolService.getAllRoles(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener los roles", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear nuevo un rol en la base de datos
    @PostMapping
    // La anotacion @RequestBody índica el tipo de objeto se espera recibir
    public ResponseEntity<?> createNewRol(@RequestBody Rol rol) {
        try {
            // LLamamos al metodo save de la interfaz de usuario para guarda el rol en una variable
            RolService.saveRol(rol);
            // Retornamos el rol creado y el codigo de estado 201
            return new ResponseEntity<Rol>(rol, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al crear el rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Traer un rol por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getRolById(@PathVariable String id) {
        try {
            return new ResponseEntity<Rol>(RolService.getRolById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar un rol por su id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRol(@PathVariable String id, @RequestBody Rol rol) {
        try {
            rol.setId_rol(id);
            RolService.saveRol(rol);
            return new ResponseEntity<Rol>(rol, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al actualizar el rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un usuario por su Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable String id) {
        try {
            RolService.deleteRolById(id);
            return new ResponseEntity<String>("Rol eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al eliminar el rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}