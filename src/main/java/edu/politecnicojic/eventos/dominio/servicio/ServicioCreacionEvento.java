package edu.politecnicojic.eventos.dominio.servicio;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;
import edu.politecnicojic.eventos.dominio.modelo.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.Evento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCreacionEvento {

    private final ServicioLugar servicioLugar;
    private final RepositorioEvento repositorioEvento;

    @Autowired
    public ServicioCreacionEvento(ServicioLugar servicioLugar, RepositorioEvento repositorioEvento) {
        this.servicioLugar = servicioLugar;
        this.repositorioEvento = repositorioEvento;
    }

    public Evento crear(Evento evento) {
        //validarLugarEvento(evento);
        Evento nuevoEvento = repositorioEvento.crear(evento);
        //validarAsistentesAlEvento();
        return nuevoEvento;
    }

    private void validarLugarEvento(Evento evento) {
        if (servicioLugar.buscar(evento.getLugar()) == null)
            throw new ExcepcionFlujo("El lugar asociado al evento no se encuentra registrado en el sistema, asegúrese de que existe");
    }

    private void validarAsistentesAlEvento() {
        //TODO: realizar la logica cuando se agregue asistentes e invitados al evento
        //TODO: ir recolectando los usuarios que no existen e informar de manera controlada
    }

    public void agregarComentario(String idEvento, Comentario comentario) {
        Evento evento = repositorioEvento.buscarPorId(idEvento).orElse(null);
        if (evento == null) throw new ExcepcionElementoNoEncontrado("No se ha encontrado el evento que buscas");
        evento.agregarComentario(comentario);
        repositorioEvento.guardarEvento(evento);
    }
}
