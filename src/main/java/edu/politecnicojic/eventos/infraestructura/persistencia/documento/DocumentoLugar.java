package edu.politecnicojic.eventos.infraestructura.persistencia.documento;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Document(collection = "lugares")
public class DocumentoLugar extends Lugar {

	@Id
	private String idLugar;

	public DocumentoLugar(String idLugar, String nombre, String direccion, Ciudad ciudad, Sede sede) {
		super(nombre, direccion, ciudad, sede);
		this.idLugar = idLugar;
	}

}
