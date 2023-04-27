package com.proyecto.poyostore.service;

import com.proyecto.poyostore.model.Rol;
import com.proyecto.poyostore.repository.mdbRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {


    @Autowired
    private mdbRolRepository rolRepo;

    //Metodo para crear y actualizar un rol
    //Para el metodo de actualizar un rol, se puede utilizar el metodo "save"
    //ya que la API de mongo para la gestion de la base de datos es que, Al crear
    //el objeto comprueba si ya existe ese mismo objeto, y si existe lo que hace es
    //actualizarlo, si no existe lo crea.
    public void saveRol(Rol rol){
        rolRepo.save(rol);
    }

    //Metodo para obtener todos los roles
    public List<Rol> getAllRoles(){
        return rolRepo.findAll();
    }

    //Metodo para obtener un rol por su Id
    //Optional es una tipo de variable que permite comprobar si el objeto
    //que se esta retornando es nulo o no
    public Optional<Rol> getRolById(String id){
        return rolRepo.findById(id);
    }

    //Metodo para eliminar un rol por su Id
    public void deleteRolById(String id){
        rolRepo.deleteById(id);
    }
}