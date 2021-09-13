package edu.politecnicojic.eventos.aplicacion.manejador;

import edu.politecnicojic.eventos.aplicacion.fabrica.FabricaPais;
import edu.politecnicojic.eventos.dominio.modeloaborrar.Pais;
import edu.politecnicojic.eventos.dominio.repositorio.RepositorioPais;
import edu.politecnicojic.eventos.infraestructura.persistencia.dto.PaisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManejadorPais {

    FabricaPais fabricaPais;

    RepositorioPais repositorioPais;

    @Autowired
    public ManejadorPais(FabricaPais fabricaPais, RepositorioPais repositorioPais) {
        this.fabricaPais = fabricaPais;
        this.repositorioPais = repositorioPais;
    }

    public void crear(PaisDto paisDto) {
        Pais pais = fabricaPais.convertirDtoADominio(paisDto);
        repositorioPais.crearOEditar(pais);
    }
}
