package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import edu.politecnicojic.eventos.dominio.modelo.Categoria;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class NuevoEventoDto {

    @NotEmpty
    String titulo;

    @NotEmpty
    String descripcion;

    @NotEmpty
    List<@Valid Categoria> categorias;

    @NotNull @FutureOrPresent
    LocalDateTime fechaInicio;

    @NotNull @FutureOrPresent
    LocalDateTime fechaFin;

    //@NotNull @Valid TODO: agregar lógica de lugares
    //Lugar lugar;

}
