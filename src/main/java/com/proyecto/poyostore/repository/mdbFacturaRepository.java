package com.proyecto.poyostore.repository;

import com.proyecto.poyostore.model.Factura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mdbFacturaRepository extends MongoRepository<Factura, String> {
}
