package com.proyecto.poyostore.service;

import com.proyecto.poyostore.model.Factura;
import com.proyecto.poyostore.repository.mdbFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    @Autowired
    private mdbFacturaRepository facturaRepo;

    //Metodo para crear y actualizar una Factura
    //Para el metodo de actualizar un usuario, se puede utilizar el metodo "save"
    //ya que la API de mongo para la gestion de la base de datos es que, Al crear
    //el objeto comprueba si ya existe ese mismo objeto, y si existe lo que hace es
    //actualizarlo, si no existe lo crea.
    public void saveFactura(Factura factura){
        facturaRepo.save(factura);
    }

    //Metodo para obtener todos las Facturas
    public List<Factura> getAllFacturas(){
        return facturaRepo.findAll();
    }

    //Metodo para obtener una Factura por su Id
    //Optional es una tipo de variable que permite comprobar si el objeto
    //que se esta retornando es nulo o no
    public Optional<Factura> getFacturaById(String id){
        return facturaRepo.findById(id);
    }

    //Metodo para eliminar una Factura por su Id
    public void deleteFacturaById(String id){
        facturaRepo.deleteById(id);
    }
}
