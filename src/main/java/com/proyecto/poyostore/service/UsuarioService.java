package com.proyecto.poyostore.service;

import com.proyecto.poyostore.model.Usuario;
import com.proyecto.poyostore.repository.mdbUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Clase intermedia entre el REST Controller y la base de datos donde implementamos
// los metodos para las operaciones CRUD
@Service
public class UsuarioService  {

    @Autowired
    private mdbUsuarioRepository usuarioRepo;

    //Metodo para crear y actualizar un usuario
    //Para el metodo de actualizar un usuario, se puede utilizar el metodo "save"
    //ya que la API de mongo para la gestion de la base de datos es que, Al crear
    //el objeto comprueba si ya existe ese mismo objeto, y si existe lo que hace es
    //actualizarlo, si no existe lo crea.
    public void save(Usuario usuario){
        usuarioRepo.save(usuario);
    }

    //Metodo para obtener todos los usuarios
    public List<Usuario> getAllUsers(){
        return usuarioRepo.findAll();
    }

    //Metodo para obtener un usuario por su Id
    //Optional es una tipo de variable que permite comprobar si el objeto
    //que se esta retornando es nulo o no
    public Optional<Usuario> findById(String id){
        return usuarioRepo.findById(id);
    }

    //Metodo para eliminar un usuario por su Id
    public void deleteById(String id){
        usuarioRepo.deleteById(id);
    }

}
