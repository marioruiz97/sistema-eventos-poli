package edu.politecnicojic.eventos.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    private String id;

    private String titulo;
    private String descripcion;

    @Indexed
    private List<Categoria> categorias;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    private Sede sede;

    private Lugar lugar;

    private Facultad facultadOrganizadora;

    private List<Comentario> comentarios;

    // TODO: borrar constructor si es necesario
    public Evento(String titulo, String descripcion, List<Categoria> categorias, LocalDateTime fechaInicio, LocalDateTime fechaFin, Lugar lugar) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
    }

    public Evento(String titulo, String descripcion, List<Categoria> categorias, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public void agregarComentario(Comentario comentario) {
        if (comentarios == null || comentarios.isEmpty()) {
            comentarios = new ArrayList<>();
        }
        getComentarios().add(comentario);
    }
}
