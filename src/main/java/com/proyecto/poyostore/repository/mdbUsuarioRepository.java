package com.proyecto.poyostore.repository;
import com.proyecto.poyostore.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*Implementacion de la API de MongoDB con Spring. Esta clase actua como enlace entre nuestro modelado y la base de datos.
De igual forma esta clase contiene todos los metodos para las operaciones CRUD*/
@Repository
public interface mdbUsuarioRepository extends MongoRepository<Usuario, String> {
    //Metodo para buscar un usuario por su id
    @Query("{ 'id_usuario' : ?0 }")
    //Optional es un contenedor que puede contener un valor o no
    Optional<Usuario> findById(String id_usuario);

    //Metodo para buscar un usuario por su nombre
    @Query("{ 'nombre' : ?0 }")
    Usuario findByNombre(String nombre);
    //Metodo para buscar un usuario por su correo
    @Query(value = "{ 'nombre' : ?0 }", fields = "{ 'name' : 1, quantity : 1 }")
    List<Usuario> findAllByNombre(String nombre);
    public long count();
}