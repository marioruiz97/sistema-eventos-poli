package edu.politecnicojic.eventos.infraestructura.persistencia.mongodb.modelo;

import edu.politecnicojic.eventos.dominio.modelos.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "eventos")
public class EventoPersistente {

    @Id
    String codigoEvento;
    String titulo;
    String descripcion;

    List<CategoriaPersistente> categorias;
    Date fecha;
    SedePersistente sede;
    LugarPersistente lugar;
    FacultadPersistente facultadOrganizadora;
    List<ComentarioPersistente> comentarios;
}
