package edu.politecnicojic.eventos.infraestructura.persistencia.documento;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import edu.politecnicojic.eventos.dominio.modelo.usuario.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@CompoundIndex(unique = true, def = "{ 'nombreUsuario': 1 }")
@Document(collection = "usuarios")
public class DocumentoUsuario extends Usuario {

	@Id
	private String id;

	public DocumentoUsuario(
			String identificacion, 
			String nombres, 
			String apellidos, 
			String email,
			TipoRelacion tipoRelacion, 
			String nombreUsuario, 
			String contrasena) {
		super(identificacion, nombres, apellidos, email, tipoRelacion, nombreUsuario, contrasena);
		this.id = identificacion;
	}

}
