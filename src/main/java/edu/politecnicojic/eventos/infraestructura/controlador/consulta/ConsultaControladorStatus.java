package edu.politecnicojic.eventos.infraestructura.controlador.consulta;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.mongo.RepositorioEventoMongo;
import edu.politecnicojic.eventos.infraestructura.persistencia.repositorio.postgres.RepositorioUsuarioPostgres;

@RestController
@RequestMapping("/status")
public class ConsultaControladorStatus {

	private static final String MONGO_ACTIVO = "Mongo está funcionando correctamente";
	private static final String MONGO_INACTIVO = "El servicio de mongo está inactivo";
	private static final String POSTGRES_ACTIVO = "Postgres está funcionando correctamente";
	private static final String POSTGRES_INACTIVO = "El servicio de postgres está inactivo";

	private final RepositorioUsuarioPostgres repositorioPostgres;
	private final RepositorioEventoMongo repositorioMongo;

	@Autowired
	public ConsultaControladorStatus(RepositorioUsuarioPostgres repositorioPostgres,
			RepositorioEventoMongo repositorioMongo) {
		this.repositorioPostgres = repositorioPostgres;
		this.repositorioMongo = repositorioMongo;
	}

	@GetMapping
	public String estadoAplicacion(HttpServletRequest request) {
		try {
			String estadoMongo = repositorioMongo.count() >= 0 ? MONGO_ACTIVO : MONGO_INACTIVO;
			String estadoPostgres = repositorioPostgres.count() >= 0 ? POSTGRES_ACTIVO : POSTGRES_INACTIVO;
			String estadoControladores = "La aplicación está activa y corriendo en el puerto "
					+ request.getServerPort();
			return estadoMongo + "\n" + estadoPostgres + "\n" + estadoControladores;
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}
}
