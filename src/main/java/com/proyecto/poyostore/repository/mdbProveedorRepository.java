package com.proyecto.poyostore.repository;

import com.proyecto.poyostore.model.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mdbProveedorRepository extends MongoRepository<Proveedor, String> {
}
