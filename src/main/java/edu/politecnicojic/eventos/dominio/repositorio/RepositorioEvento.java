package edu.politecnicojic.eventos.dominio.repositorio;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
//import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
//import edu.politecnicojic.eventos.dominio.modelo.usuario.Asistente;
//import edu.politecnicojic.eventos.dominio.modelo.usuario.Conferencista;

import java.util.List;
import java.util.Optional;

public interface RepositorioEvento {

    Evento crear(Evento evento);

    List<Evento> buscarTodos();

    //List<Evento> buscarPorCategorias(List<Categoria> categorias);

    Optional<Evento> buscarPorId(String idEvento);

    void actualizarEvento(Evento evento);

    /* TODO: descomentar cuando se agregue la lógica de cada método
    void agregarAsistentes(String idEvento, List<Asistente> asistentes)

    void agregarConferencistas(String idEvento, List<Conferencista> conferencistas);

    void agregarComentario(String idEvento, Comentario comentario);

    void eliminarPorId(String idEvento);*/

}
