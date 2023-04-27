package com.proyecto.poyostore.controller;

import com.proyecto.poyostore.model.Proveedor;
import com.proyecto.poyostore.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("proveedores")
public class ProveedorController {
    // Inyectamos la interfaz de usuario en una variable de tipo privada con @Autowired
    @Autowired
    private ProveedorService ProveedorService;

    // Obtener todos los usuarios
    @GetMapping
    //En ResponseEntity indicamos que puede recibir cualquier dato con:"?"
    public ResponseEntity<?> getAllProveedores() {
        try {
            //Debido a que necesitamos una lista de Proveedores, hacemos uso de la interfaz de usuario para obtener todos
            //los usuarios con el metodo findAll()
            return new ResponseEntity<List<Proveedor>>(ProveedorService.getAllProveedores(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener Proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear nuevo un Proveedor en la base de datos
    @PostMapping
    // La anotacion @RequestBody índica el tipo de objeto se espera recibir
    public ResponseEntity<?> createNewProveedor(@RequestBody Proveedor proveedor) {
        try {
            // LLamamos al metodo save de la interfaz de Proveedores para guarda al usuario en una variable
            ProveedorService.saveFactura(proveedor);
            // Retornamos el proveedor creado y el codigo de estado 201
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al crear al Proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Traer a un Proveedor por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProveedorById(@PathVariable String id) {
        try {
            return new ResponseEntity<Proveedor>(ProveedorService.getProveedorById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener Proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Eliminar un Proveedor por su Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable String id) {
        try {
            ProveedorService.deleteProveedorById(id);
            return new ResponseEntity<String>("Proveedor eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al eliminar el Proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar un Proveedor por su id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody Proveedor proveedor) {
        try {
            proveedor.setId_proveedor(id);
            ProveedorService.saveFactura(proveedor);
            return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al actualizar Proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
