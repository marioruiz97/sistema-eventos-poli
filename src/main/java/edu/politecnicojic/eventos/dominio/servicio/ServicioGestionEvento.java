package edu.politecnicojic.eventos.dominio.servicio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionFlujo;
import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioEvento;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioLugar;

@Service
public class ServicioGestionEvento {

	private static final String EVENTO_NO_ENCONTRADO = "No se ha encontrado el evento que buscas";
	private static final String LUGAR_NO_ENCONTRADO = "No se encontró el lugar al que se asoció el evento, verifica la información";

	private final RepositorioEvento repositorioEvento;
	private final RepositorioLugar repositorioLugar;

	@Autowired
	public ServicioGestionEvento(RepositorioEvento repositorioEvento, RepositorioLugar repositorioLugar) {
		this.repositorioEvento = repositorioEvento;
		this.repositorioLugar = repositorioLugar;
	}

	public Evento crear(Evento evento) {
		validarEvento(evento);
		return repositorioEvento.crear(evento);
	}

	public void actualizarInformacionBasica(Evento evento) {
		validarEvento(evento);
		Evento viejoEvento = repositorioEvento.buscarPorId(evento.getIdEvento())
				.orElseThrow(() -> new ExcepcionElementoNoEncontrado(EVENTO_NO_ENCONTRADO));
		viejoEvento.actualizarInformacionBasica(evento);
		repositorioEvento.actualizarEvento(viejoEvento);
	}

	private void validarEvento(Evento evento) {
		Evento.validarCamposObligatorios(evento);
		validarLugarEvento(evento);
		validarFecha(evento);
	}

	private void validarFecha(Evento evento) {
		LocalDate fechaEvento = evento.getInformacionEvento().getFechaEvento();
		ValidadorArgumento.validarNulo(fechaEvento);
		ValidadorArgumento.validarFechaFutura(fechaEvento);
	}

	private void validarLugarEvento(Evento evento) {
		Lugar lugar = evento.getInformacionEvento().getLugar();
		try {
			lugar.validarCampos();
		} catch (ExcepcionFlujo excepcionFlujo) {
			if (lugar.getNombre() != null && lugar.getDireccion() != null) {
				lugar = repositorioLugar.buscarPorNombreYDireccion(lugar.getNombre(), lugar.getDireccion())
						.orElseThrow(() -> new ExcepcionElementoNoEncontrado(LUGAR_NO_ENCONTRADO));
				evento.getInformacionEvento().actualizarLugar(lugar);
			} else {
				throw excepcionFlujo;
			}
		}
	}

	public void agregarComentario(String idEvento, Comentario comentario) {
		Evento evento = repositorioEvento.buscarPorId(idEvento)
				.orElseThrow(() -> new ExcepcionElementoNoEncontrado(EVENTO_NO_ENCONTRADO));
		evento.agregarComentario(comentario);
		repositorioEvento.actualizarEvento(evento);
	}
}
