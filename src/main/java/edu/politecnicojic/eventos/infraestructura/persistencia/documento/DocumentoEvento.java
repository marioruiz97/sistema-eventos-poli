package edu.politecnicojic.eventos.infraestructura.persistencia.documento;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.politecnicojic.eventos.dominio.modelo.evento.Categoria;
import edu.politecnicojic.eventos.dominio.modelo.evento.Comentario;
import edu.politecnicojic.eventos.dominio.modelo.evento.Evento;
import edu.politecnicojic.eventos.dominio.modelo.evento.InformacionEvento;
import edu.politecnicojic.eventos.dominio.modelo.evento.Organizador;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Asistente;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Conferencista;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Facilitador;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Document(collection = "eventos")
public class DocumentoEvento extends Evento {

	@Id
	private String id;
	private List<Categoria> categorias;

	public DocumentoEvento(
			String idEvento, 
			InformacionEvento informacionEvento, 
			List<Asistente> asistentes,
			List<Facilitador> facilitadores, 
			List<Conferencista> conferencistas, 
			List<Organizador> organizadores,
			List<Comentario> comentarios) {
		super(idEvento, informacionEvento, asistentes, facilitadores, conferencistas, organizadores, comentarios);
		this.id = idEvento;
		this.categorias = informacionEvento.getCategorias();
	}

	public DocumentoEvento(
			String idEvento, 
			InformacionEvento informacionEvento, 
			List<Facilitador> facilitadores,
			List<Organizador> organizadores) {
		super(idEvento, informacionEvento, facilitadores, organizadores);
		this.id = idEvento;
		this.categorias = informacionEvento.getCategorias();
	}

}
