package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class PaisDto {

    @NotEmpty
    String codigoPais;

    @NotEmpty
    String nombre;

}
