package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "paises")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadPais implements Serializable {

    @Id
    private Integer codigo;

    @Size(max = 20)
    @NotEmpty
    private String nombre;

}
