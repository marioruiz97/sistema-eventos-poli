package edu.politecnicojic.eventos.dominio.modelo.evento;

import edu.politecnicojic.eventos.dominio.modelo.ValidadorArgumento;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {

	private String mensaje;

	private Usuario usuario;

	public void validarComentario() {
		ValidadorArgumento.validarNulo(usuario);
		ValidadorArgumento.validarCampo(mensaje);
	}
}
