package com.proyecto.poyostore.controller;

import com.proyecto.poyostore.model.Usuario;
import com.proyecto.poyostore.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// La anotación @RestController indica que esta clase es un controlador
@RestController
// La anotación @RequestMapping indica que la URL base para esta clase controlador es /usuarios
@RequestMapping("/usuarios")
public class UsuarioController {

    // Inyectamos la interfaz de usuario en una variable de tipo privada con @Autowired
    @Autowired
    private UsuarioService UsuarioService;

    // Obtener todos los usuarios
    @GetMapping
    //En ResponseEntity indicamos que puede recibir cualquier dato con:"?"
    public ResponseEntity<?> getAllUsers(){
        try {
            //Debido a que necesitamos una lista de usuarios, hacemos uso de la interfaz de usuario para obtener todos
            //los usuarios con el metodo findAll()
            return new ResponseEntity< List<Usuario> >(UsuarioService.getAllUsers(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Error al obtener Usuarios", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Crear nuevo un usuario en la base de datos
    @PostMapping
    // La anotacion @RequestBody índica el tipo de objeto se espera recibir
    public  ResponseEntity<?> createNewUser(@RequestBody Usuario usuario){
        try{
            // LLamamos al metodo save de la interfaz de usuario para guarda al usuario en una variable
            UsuarioService.save(usuario);
            // Retornamos el usuario creado y el codigo de estado 201
            return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>("Error al crear al Usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Traer a un usuario por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try{
            return new ResponseEntity<Usuario>(UsuarioService.findById(id).get(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>("Error al obtener Usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Eliminar un usuario por su Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        try{
            UsuarioService.deleteById(id);
            return new ResponseEntity<String>("Usuario eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Error al eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar un usuario por su id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id,  @RequestBody Usuario usuario){
        try{
            usuario.setId_usuario(id);
            UsuarioService.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Error al actualizar Usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}