package edu.politecnicojic.eventos.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Facultad {

    private Integer codigo;
    private String nombre;
    private String ubicacion;
    private String numeroTelefono;
}
