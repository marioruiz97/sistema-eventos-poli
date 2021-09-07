package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class PaisDto {

    @NotEmpty
    Integer codigoPais;

    @NotEmpty
    String nombre;

}
