package edu.politecnicojic.eventos.dominio.modelo.evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InformacionEvento {

	private String titulo;

	private String descripcion;

	private List<Categoria> categorias;

	private LocalDate fechaEvento;

	private Lugar lugar;

	public static void validarCamposObligatorios(InformacionEvento info) {
		ValidadorArgumento.validarNulo(info);
		ValidadorArgumento.validarVacio(info.getCategorias());
		ValidadorArgumento.validarNulo(info.getFechaEvento());
		ValidadorArgumento.validarNulo(info.getLugar());
		List<String> campos = new ArrayList<>();
		campos.add(info.getTitulo());
		campos.add(info.getDescripcion());
		ValidadorArgumento.validarCampos(campos);
	}

	public void actualizarLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}
