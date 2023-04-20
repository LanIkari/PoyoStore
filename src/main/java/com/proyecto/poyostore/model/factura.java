package com.proyecto.poyostore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("factura")
@Setter
@Getter
// Clase que representa a una factura
public class factura {
    // Anotación que indica que el atributo id es el identificador de la factura
    @Id
    private String id_factura;
    // Hacemos uso del identificador del usuario para ligarlo a una factura
    @Id
    private String id_usuario;
    // Hacemos uso del identificador del producto para ligarlo a una factura
    @Id

    private String id_prducto;
    private Date fecha;

    private double total;

    private int numeroSeguimiento;
    //Creacion de constructor vacío para factura
    public factura(Date fecha, double total, int numeroSeguimiento) {
        this.fecha = fecha;
        this.total = total;
        this.numeroSeguimiento = numeroSeguimiento;
    }
}
