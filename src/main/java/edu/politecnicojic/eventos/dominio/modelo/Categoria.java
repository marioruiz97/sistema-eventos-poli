package edu.politecnicojic.eventos.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    String id;
    String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
