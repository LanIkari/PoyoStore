package com.proyecto.poyostore.controller;

import com.proyecto.poyostore.model.Producto;
import com.proyecto.poyostore.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService ProductoService;

    //Obtener todos los productos
    @GetMapping
    //En ResponseEntity indicamos que puede recibir cualquier dato con:"?"
    public ResponseEntity<?> getAllProductos() {
        try {
            //Debido a que necesitamos una lista de productos, hacemos uso de la interfaz de usuario para obtener todos
            //los productos con el metodo findAll()
            return new ResponseEntity<List<Producto>>(ProductoService.getAllProductos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener los productos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear nuevo un producto en la base de datos
    @PostMapping
    // La anotacion @RequestBody índica el tipo de objeto se espera recibir
    public ResponseEntity<?> createNewProducto(@RequestBody Producto producto) {
        try {
            // LLamamos al metodo save de la interfaz de usuario para guarda el rol en una variable
            ProductoService.saveProducto(producto);
            // Retornamos el producto creado y el codigo de estado 201
            return new ResponseEntity<Producto>(producto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Traer un rol por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable String id) {
        try {
            return new ResponseEntity<Producto>(ProductoService.getProductoById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al obtener producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar un rol por su id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable String id, @RequestBody Producto producto) {
        try {
            producto.setId_producto(id);
            ProductoService.saveProducto(producto);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un usuario por su Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable String id) {
        try {
            ProductoService.deleteProductoById(id);
            return new ResponseEntity<String>("Producto eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error al eliminar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
