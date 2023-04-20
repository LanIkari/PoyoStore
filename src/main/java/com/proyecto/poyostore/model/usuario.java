package com.proyecto.poyostore.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Anotación que indica que la clase es un documento de MongoDB y que se guardará en la colección "usuario" de la base de datos "DBPoyoStore". Si la coleccion no existe se creara.
@Document("usuario")
// Lombok genera los métodos getter y setter que nos ayudan a reciclar codigo
@Getter
@Setter
// Clase que representa a un usuario
public class usuario {

    // Anotación que indica que el atributo id es el identificador del usuario
    @Id
    private String id_usuario;
    // Anotación que indica que el atributo id es el identificador del rol
    @Id
    private String id_rol;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String telefono;
    private double fondos;

    //Creacion de constructor vacío para usuario
    public usuario(String id_usuario, String nombre, String apellido, String correo, String contraseña, String telefono, double fondos) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.fondos= fondos;
    }
}
