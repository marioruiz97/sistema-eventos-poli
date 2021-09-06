package edu.politecnicojic.eventos.dominio.modelo;

import lombok.Getter;

@Getter
public class Lugar {
    String nombre;
    String direccion;
    Ciudad ciudad;
}
