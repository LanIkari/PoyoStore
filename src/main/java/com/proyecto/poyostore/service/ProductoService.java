package com.proyecto.poyostore.service;

import com.proyecto.poyostore.model.Producto;
import com.proyecto.poyostore.model.Rol;
import com.proyecto.poyostore.repository.mdbProductoRepository;
import com.proyecto.poyostore.repository.mdbRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private mdbProductoRepository productoRepo;

    //Metodo para crear y actualizar un producto
    //Para el metodo de actualizar un producto, se puede utilizar el metodo "save"
    //ya que la API de mongo para la gestion de la base de datos es que, Al crear
    //el objeto comprueba si ya existe ese mismo objeto, y si existe lo que hace es
    //actualizarlo, si no existe lo crea.
    public void saveProducto(Producto producto){
        productoRepo.save(producto);
    }

    //Metodo para obtener todos los productos
    public List<Producto> getAllProductos(){
        return productoRepo.findAll();
    }

    //Metodo para obtener un producto por su Id
    //Optional es una tipo de variable que permite comprobar si el objeto
    //que se esta retornando es nulo o no
    public Optional<Producto> getProductoById(String id){
        return productoRepo.findById(id);
    }

    //Metodo para eliminar un producto por su Id
    public void deleteProductoById(String id){
        productoRepo.deleteById(id);
    }
}
