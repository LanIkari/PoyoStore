package com.proyecto.poyostore.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Factura")
// Clase que representa a una factura
public class Factura {
    
    // Anotación que indica que el atributo id es el identificador de la factura
    @Id
    private String id_factura;
    
    // Hacemos uso del identificador del usuario para ligarlo a una factura
    private Usuario usuario;
    
    // Hacemos uso del identificador del producto para ligarlo a una factura
    private Producto producto;
    private Date fecha;
    private double total;
    private int numeroSeguimiento;
}
