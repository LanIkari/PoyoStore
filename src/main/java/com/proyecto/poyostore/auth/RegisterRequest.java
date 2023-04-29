package com.proyecto.poyostore.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Clase para la autenticacion del usuario
public class RegisterRequest {

    private String nombre;

    private String apellido;

    private String correo;

    private String contrasena;

    private String telefono;

    private double fondos;
}
