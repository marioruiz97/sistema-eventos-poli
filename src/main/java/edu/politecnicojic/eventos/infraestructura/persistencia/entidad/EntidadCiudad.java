package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ciudades")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadCiudad implements Serializable {

    @Id
    private Integer codigo;

    @Size(max = 20)
    @NotEmpty
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_dpto", nullable = false)
    private EntidadDepartamento entidadDepartamento;

}
