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
}