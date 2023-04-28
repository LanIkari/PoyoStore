package com.proyecto.poyostore.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// Anotación que indica que la clase es un documento de MongoDB y que se guardará en la colección "usuario" de la base de datos "DBPoyoStore". Si la coleccion no existe se creara.
@Document("Usuario")
// Clase que representa a un usuario
public class Usuario implements UserDetails {

    // Anotación que indica que el atributo id es el identificador del usuario
    @Id
    private String id_usuario;

    // La anotacion @Field nos ayuda a referenciar un campo que esta en otra clase.
    @Field("rol")
    private Rol rol;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String telefono;
    private double fondos;

    //Métodos implementados por userDetails

    //Metodo que devuelve la lista de roles que tiene un usuario
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    //Este metodo devuelve la contraseña del usuario
    @Override
    public String getPassword() {
        return contrasena;
    }

    //Este método devuelve el correo del usuario
    @Override
    public String getUsername() {
        return correo;
    }

    //Metodos que retornan un valor true para que las cuentas de usuario no caduquen, no se bloqueen y las credenciales nunca expiren

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}