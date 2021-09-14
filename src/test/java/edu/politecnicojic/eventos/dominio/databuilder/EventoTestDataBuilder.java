package edu.politecnicojic.eventos.dominio.databuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Facultad;
import edu.politecnicojic.eventos.dominio.modelo.evento.InformacionEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Organizador;
import edu.politecnicojic.eventos.dominio.modelo.evento.Programa;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;

public class EventoTestDataBuilder {

	private static final int CODIGO_AREA = 50;
	private static final String DESCRIPCION_EVENTO = "descripcionPrueba";
	private static final String NOMBRE_EVENTO = "prueba";
	private static final String ID_EVENTO = "1";
	private static final String CATEGORIA_PRUEBA = "Categoria prueba";
	private static final String INGENIERIA_INFORMATICA = "ingenieria informatica";
	private static final String TELEFONO_FACULTAD = "2015465";
	private static final String UBICACION_FACULTAD = "P13";
	private static final String INGENIERIA = "INGENIERIA";
	private static final String COMENTARIO = "Comentario de prueba";

	private String descripcionEvento;
	private String nombreEvento;
	private String idEvento;
	private List<Categoria> categorias;
	private Lugar lugar;
	private LocalDate fecha;

	public EventoTestDataBuilder() {
		this.descripcionEvento = DESCRIPCION_EVENTO;
		this.nombreEvento = NOMBRE_EVENTO;
		this.idEvento = ID_EVENTO;
		this.lugar = new LugarTestDataBuilder().build();
		this.categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria(CATEGORIA_PRUEBA));
		this.fecha = LocalDate.now().plusDays(10);
	}

	public EventoTestDataBuilder conDescripcion(String descripcion) {
		this.descripcionEvento = descripcion;
		return this;
	}

	public EventoTestDataBuilder conNombre(String nombre) {
		this.nombreEvento = nombre;
		return this;
	}

	public EventoTestDataBuilder conIdEvento(String idEvento) {
		this.idEvento = idEvento;
		return this;
	}

	public EventoTestDataBuilder conCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
		return this;
	}

	public EventoTestDataBuilder conLugar(Lugar lugar) {
		this.lugar = lugar;
		return this;
	}

	public EventoTestDataBuilder conFecha(LocalDate fecha) {
		this.fecha = fecha;
		return this;
	}

	public Evento buildEvento() {
		return new Evento(idEvento, buildInformacion(), buildFacilitadores(), buildOrganizadores());
	}

	private List<Organizador> buildOrganizadores() {
		List<Organizador> organizadores = new ArrayList<>();
		organizadores.add(new Facultad(1, INGENIERIA, UBICACION_FACULTAD, TELEFONO_FACULTAD));
		organizadores.add(new Programa(2, INGENIERIA_INFORMATICA, CODIGO_AREA));
		return organizadores;
	}

	private List<Facilitador> buildFacilitadores() {
		Facilitador facilitador = new Facilitador(buildUsuario());
		List<Facilitador> facilitadores = new ArrayList<>();
		facilitadores.add(facilitador);
		return facilitadores;
	}

	private InformacionEvento buildInformacion() {
		return new InformacionEvento(nombreEvento, descripcionEvento, categorias, fecha, lugar);
	}

	private static Usuario buildUsuario() {
		return new UsuarioTestDataBuilder().build();
	}

	public static Comentario construirComentario() {
		return new Comentario(COMENTARIO, buildUsuario());
	}

	public static Comentario construirComentario(String mensaje, Usuario usuario) {
		return new Comentario(mensaje, usuario);
	}

}
