package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "areas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadArea implements Serializable {

    @Id
    private Integer codigo;

    @Size(max = 40)
    @NotEmpty
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_facultad", nullable = false)
    private EntidadFacultad facultad;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_coordinador", unique = true)
    private EntidadEmpleado coordinador;

}
