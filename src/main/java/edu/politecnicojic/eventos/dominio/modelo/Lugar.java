package edu.politecnicojic.eventos.dominio.modelo;

import lombok.Getter;

@Getter
public class Lugar {
    
    private String nombre;
    private String direccion;
    private Ciudad ciudad;
}
