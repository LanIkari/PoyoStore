package com.proyecto.poyostore.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Proveedor")
public class Proveedor {
    @Id
    private String id_proveedor;
    private String nombre;
    private String telefono;
    private String correo;
}