package edu.politecnicojic.eventos.aplicacion.manejador.eventos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaEvento;
import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorLugar;
import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorOrganizador;
import edu.politecnicojic.eventos.aplicacion.manejador.ManejadorUsuario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Organizador;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import edu.politecnicojic.eventos.dominio.servicio.ServicioGestionEvento;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.NuevoEventoDto;

@Service
public class ManejadorCreacionEvento {

	private final FabricaEvento fabricaEvento;
	private final ServicioGestionEvento servicioGestionEvento;
	private final ManejadorLugar manejadorLugar;
	private final ManejadorUsuario manejadorUsuario;
	private final ManejadorOrganizador manejadorOrganizador;

	@Autowired
	public ManejadorCreacionEvento(FabricaEvento fabricaEvento, ServicioGestionEvento servicioGestionEvento,
			ManejadorLugar manejadorLugar, ManejadorUsuario manejadorUsuario,
			ManejadorOrganizador manejadorOrganizador) {
		this.fabricaEvento = fabricaEvento;
		this.servicioGestionEvento = servicioGestionEvento;
		this.manejadorLugar = manejadorLugar;
		this.manejadorUsuario = manejadorUsuario;
		this.manejadorOrganizador = manejadorOrganizador;
	}

	public Evento crear(NuevoEventoDto eventoDto) {
		Lugar lugar = manejadorLugar.buscarPorNombreYDireccion(eventoDto.getLugar());
		List<Facilitador> facilitadores = manejadorUsuario.buscarFacilitadores(eventoDto.getFacilitadores());
		List<Organizador> organizadores = manejadorOrganizador.buscarOrganizadores(eventoDto.getOrganizadores());
		Evento evento = fabricaEvento.convertirNuevoDtoADominio(eventoDto, lugar, facilitadores, organizadores);
		return servicioGestionEvento.crear(evento);
	}

	public void editar(NuevoEventoDto eventoDto) {
		Lugar lugar = manejadorLugar.buscarPorNombreYDireccion(eventoDto.getLugar());
		List<Facilitador> facilitadores = manejadorUsuario.buscarFacilitadores(eventoDto.getFacilitadores());
		List<Organizador> organizadores = manejadorOrganizador.buscarOrganizadores(eventoDto.getOrganizadores());
		Evento evento = fabricaEvento.convertirNuevoDtoADominio(eventoDto, lugar, facilitadores, organizadores);
		servicioGestionEvento.actualizarInformacionBasica(evento);
	}

}
