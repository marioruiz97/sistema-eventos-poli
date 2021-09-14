package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class PaisDto {

    @NotNull
    Integer codigoPais;

    @NotEmpty
    String nombre;

}
