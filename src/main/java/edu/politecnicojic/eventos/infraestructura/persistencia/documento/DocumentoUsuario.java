package edu.politecnicojic.eventos.infraestructura.persistencia.documento;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.politecnicojic.eventos.dominio.modelo.usuario.TipoRelacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndex(unique = true, def = "{ 'email':1, 'nombreUsuario': 1 }")
@Document(collection = "usuarios")
public class DocumentoUsuario {

	@Id
	private String identificacion;
	private String nombres;
	private String apellidos;
	private String email;
	private TipoRelacion tipoRelacion;
	private String nombreUsuario;
	private String contrasena;

}
