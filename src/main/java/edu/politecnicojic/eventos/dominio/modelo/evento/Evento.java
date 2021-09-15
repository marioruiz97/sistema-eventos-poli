package edu.politecnicojic.eventos.dominio.modelo.evento;

import java.util.ArrayList;
import java.util.List;

import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Asistente;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Conferencista;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
	
    private String idEvento;

    private InformacionEvento informacionEvento;

    private List<Asistente> asistentes;

    private List<Facilitador> facilitadores;

    private List<Conferencista> conferencistas;

    private List<Organizador> organizadores;

    private List<Comentario> comentarios;

    public Evento(String idEvento, InformacionEvento informacionEvento, List<Facilitador> facilitadores,
                  List<Organizador> organizadores) {
        this.idEvento = idEvento;
        this.informacionEvento = informacionEvento;
        this.facilitadores = facilitadores;
        this.organizadores = organizadores;
    }

    public static void validarCamposObligatorios(Evento evento) {
        ValidadorArgumento.validarNulo(evento);
        List<Object> atributos = new ArrayList<>();
        atributos.add(evento.getInformacionEvento());
        atributos.add(evento.getOrganizadores());
        atributos.forEach(ValidadorArgumento::validarNulo);
        ValidadorArgumento.validarVacio(evento.getOrganizadores());
        InformacionEvento.validarCamposObligatorios(evento.getInformacionEvento());
    }

    public void agregarComentario(Comentario comentario) {
        comentario.validarComentario();
        if (comentarios == null) {
            comentarios = new ArrayList<>();
        }
        comentarios.add(comentario);
    }

	public void actualizarInformacionBasica(Evento evento) {
		this.informacionEvento = evento.getInformacionEvento();
		this.facilitadores = evento.getFacilitadores();
		this.organizadores = evento.getOrganizadores();
	}

}
