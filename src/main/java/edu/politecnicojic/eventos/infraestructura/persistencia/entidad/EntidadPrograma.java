package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "programas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadPrograma implements Serializable {

    @Id
    private Integer codigo;

    @Size(max = 40)
    @NotEmpty
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_area", nullable = false)
    private EntidadArea area;

}
