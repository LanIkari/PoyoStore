package com.proyecto.poyostore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Rol")
@Setter
@Getter
// Clase que representa a un rol
public class Rol {
    // Anotación que indica que el atributo id es el identificador del rol
    @Id
    private String id_rol;
    private String nombre;
    private String descripcion;
    //Creacion de constructor vacío para Rol
    public Rol(){

    }
    public Rol(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}