package com.proyecto.poyostore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Proveedor")
@Setter
@Getter
public class Proveedor {
    @Id
    private String id_proveedor;
    private String nombre;
    private String telefono;
    private String correo;

    public Proveedor(){

    }

    public Proveedor(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
}