package edu.politecnicojic.eventos.dominio.modelo;

import java.util.Date;
import java.util.List;


public class Evento {

    String codigoEvento;
    String titulo;
    String descripcion;
    List<Categoria> categorias;
    Date fecha;
    Sede sede;
    Lugar lugar;
    Facultad facultadOrganizadora;
    List<Comentario> comentarios;
}
