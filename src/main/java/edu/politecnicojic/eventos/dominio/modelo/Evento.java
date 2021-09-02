package edu.politecnicojic.eventos.dominio.modelo;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
public class Evento {

    @Id
    String id;

    String titulo;
    String descripcion;

    @Indexed(unique = false)
    List<Categoria> categorias;

    LocalDateTime fechaInicio;
    LocalDateTime fechaFin;

    Sede sede;

    Lugar lugar;

    Facultad facultadOrganizadora;

    List<Comentario> comentarios;

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
}
