package com.proyecto.poyostore.repository;

import com.proyecto.poyostore.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mdbProductoRepository extends MongoRepository<Producto, String> {
}
