package edu.politecnicojic.eventos.dominio.modelo;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document
public class Pais {

    @Id
    String id;

    String codigoPais;
    String nombre;

    public Pais(String codigoPais, String nombre) {
        this.codigoPais = codigoPais;
        this.nombre = nombre;
    }
}
