package edu.politecnicojic.eventos.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {

    private Integer codigo;

    @Size(max = 20)
    @NotEmpty
    private String nombre;

    private Departamento departamento;

}
