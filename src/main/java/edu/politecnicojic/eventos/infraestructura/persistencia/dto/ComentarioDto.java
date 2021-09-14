package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ComentarioDto {

    @NotEmpty
    String mensaje;

    @NotEmpty
    String usuario;

}
