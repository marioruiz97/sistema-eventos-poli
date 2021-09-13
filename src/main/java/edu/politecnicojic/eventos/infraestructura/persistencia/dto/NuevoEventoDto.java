package edu.politecnicojic.eventos.infraestructura.persistencia.dto;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Organizador;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class NuevoEventoDto {

    String idEvento;

    @NotEmpty
    String titulo;

    @NotEmpty
    String descripcion;

    @NotEmpty
    List<@Valid Categoria> categorias;

    @NotNull @FutureOrPresent
    LocalDate fecha;

    @NotNull @Valid
    Lugar lugar;

    @NotEmpty
    List<Facilitador> facilitadores;

    @NotEmpty
    List<Organizador> organizadores;
}
