package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ComentarioDto {

    @NotEmpty
    String mensaje;

    // TODO: agregar usuario  que hace comentario
}
