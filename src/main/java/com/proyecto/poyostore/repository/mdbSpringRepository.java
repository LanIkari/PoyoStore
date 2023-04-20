package com.proyecto.poyostore.repository;
import com.proyecto.poyostore.model.usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.List;
        import java.util.Optional;

/*Implementacion de la API de MongoDB con Spring. Esta clase actua como enlace entre nuestro modelado y la base de datos.
De igual forma esta clase contiene todos los metodos para las operaciones CRUD*/
public interface mdbSpringRepository extends MongoRepository<usuario, String> {
    //Metodo para buscar un usuario por su id
    @Query("{ 'id_usuario' : ?0 }")
    //Optional es un contenedor que puede contener un valor o no
    Optional<usuario> findById(String id_usuario);

    //Metodo para buscar un usuario por su nombre
    @Query("{ 'nombre' : ?0 }")
    usuario findByNombre(String nombre);
    //Metodo para buscar un usuario por su correo
    @Query(value = "{ 'nombre' : ?0 }", fields = "{ 'name' : 1, quantity : 1 }")
    List<usuario> findAllByNombre(String nombre);
    public long count();
}