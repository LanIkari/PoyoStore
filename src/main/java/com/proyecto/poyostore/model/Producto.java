package com.proyecto.poyostore.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document ("Producto")
public class Producto {
    @Id
    private String id_producto;
    private Proveedor proveedor;
    private String nombre;
    private String descripcion;
    private String categoria;
    private double precio;
    private int cantidad;
    private byte imagen;
}