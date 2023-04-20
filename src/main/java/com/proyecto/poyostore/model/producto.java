package com.proyecto.poyostore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class producto {
    @Id
    private String id_producto;
    @Id
    private String id_proveedor;
    private String nombre;
    private String descripcion;
    private String categoria;
    private double precio;
    private int cantidad;
    private byte imagen;

    public producto(String nombre, String descripcion,  String categoria,  double precio, int cantidad, byte imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }
}