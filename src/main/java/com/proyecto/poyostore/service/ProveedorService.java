package com.proyecto.poyostore.service;

import com.proyecto.poyostore.model.Proveedor;
import com.proyecto.poyostore.repository.mdbProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private mdbProveedorRepository proveedorRepo;

    //Metodo para crear y actualizar un proveedor
    //Para el metodo de actualizar un usuario, se puede utilizar el metodo "save"
    //ya que la API de mongo para la gestion de la base de datos es que, Al crear
    //el objeto comprueba si ya existe ese mismo objeto, y si existe lo que hace es
    //actualizarlo, si no existe lo crea.
    public void saveFactura(Proveedor proveedor){
        proveedorRepo.save(proveedor);
    }

    //Metodo para obtener todos los proveedores
    public List<Proveedor> getAllProveedores(){
        return proveedorRepo.findAll();
    }

    //Metodo para obtener un proveedor por su Id
    //Optional es una tipo de variable que permite comprobar si el objeto
    //que se esta retornando es nulo o no
    public Optional<Proveedor> getProveedorById(String id){
        return proveedorRepo.findById(id);
    }

    //Metodo para eliminar un proveedor por su Id
    public void deleteProveedorById(String id){
        proveedorRepo.deleteById(id);
    }

}
