package com.proyecto.poyostore.controller;

import com.proyecto.poyostore.model.Factura;
import com.proyecto.poyostore.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("facturas")
public class FacturaController {
    // Inyectamos la interfaz de usuario en una variable de tipo privada con @Autowired
    @Autowired
    private FacturaService FacturaService;

    // Obtener todas las Facturas
    @GetMapping
    //En ResponseEntity indicamos que puede recibir cualquier dato con:"?"
    public ResponseEntity<?> getAllFacturas() {
        try {
            //Debido a que necesitamos una lista de Facturas, hacemos uso de la interfaz de usuario para obtener todas
            //las Facturas con el metodo findAll()
            return new ResponseEntity<List<Factura>>(FacturaService.getAllFacturas(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener Facturas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear nueva Factura en la base de datos
    @PostMapping
    // La anotacion @RequestBody índica el tipo de objeto se espera recibir
    public ResponseEntity<?> createNewFactura(@RequestBody Factura factura) {
        try {
            // LLamamos al metodo save de la interfaz de Facturas para guarda al usuario en una variable
            FacturaService.saveFactura(factura);
            // Retornamos la factura creado y el codigo de estado 201
            return new ResponseEntity<Factura>(factura, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al crear al Proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Traer a un Factura por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getFacturaById(@PathVariable String id) {
        try {
            return new ResponseEntity<Factura>(FacturaService.getFacturaById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener Facturas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Eliminar un Factura por su Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFactura(@PathVariable String id) {
        try {
            FacturaService.deleteFacturaById(id);
            return new ResponseEntity<String>("Factura eliminada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al eliminar Factura", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar una Factura por su id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody Factura factura) {
        try {
            factura.setId_factura(id);
            FacturaService.saveFactura(factura);
            return new ResponseEntity<Factura>(factura, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al actualizar Factura", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
