package edu.politecnicojic.eventos.aplicacion.manejador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.politecnicojic.eventos.dominio.excepcion.ExcepcionElementoNoEncontrado;
import edu.politecnicojic.eventos.dominio.modelo.evento.Facultad;
import edu.politecnicojic.eventos.dominio.modelo.evento.Organizador;
import edu.politecnicojic.eventos.dominio.modelo.evento.Programa;
import edu.politecnicojic.eventos.dominio.modelo.evento.TipoOrganizador;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioOrganizador;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.OrganizadorDto;

@Service
public class ManejadorOrganizador {

	private static final String ORGANIZADOR_NO_ENCONTRADA = "No se ha encontrado el/la %s con código %s en base de datos";

	private final RepositorioOrganizador<Facultad> repositorioFacultad;
	private final RepositorioOrganizador<Programa> repositorioPrograma;

	@Autowired
	public ManejadorOrganizador(RepositorioOrganizador<Facultad> repositorioFacultad,
			RepositorioOrganizador<Programa> repositorioPrograma) {		
		this.repositorioFacultad = repositorioFacultad;
		this.repositorioPrograma = repositorioPrograma;
	}

	public List<Organizador> buscarOrganizadores(List<OrganizadorDto> organizadoresDto) {
		return organizadoresDto.stream().map(dto -> {
			if (dto.getTipoOrganizador().equals(TipoOrganizador.FACULTAD)) {
				return repositorioFacultad.buscar(dto.getCodigo()).orElseThrow(() -> new ExcepcionElementoNoEncontrado(
						String.format(ORGANIZADOR_NO_ENCONTRADA, "facultad", dto.getCodigo())));
			} else {
				return repositorioPrograma.buscar(dto.getCodigo()).orElseThrow(() -> new ExcepcionElementoNoEncontrado(
						String.format(ORGANIZADOR_NO_ENCONTRADA, "programa", dto.getCodigo())));
			}
		}).collect(Collectors.toList());

	}

}
