package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ComentarioDto {

    @NotEmpty
    String mensaje;

    @NotNull
    Usuario usuario;

}
