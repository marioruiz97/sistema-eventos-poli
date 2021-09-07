package edu.politecnicojic.eventos.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "facultades")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadFacultad implements Serializable {

    @Id
    private Integer codigo;

    @Size(max = 30)
    @NotEmpty
    private String nombre;

    @Size(max = 15)
    @NotEmpty
    private String ubicacion;

    @Size(max = 15)
    @NotEmpty
    @Column(name = "nro_telefono", nullable = false)
    private String numeroTelefono;

    @OneToOne
    @JoinColumn(name = "id_decano")
    private EntidadEmpleado decano;

}
