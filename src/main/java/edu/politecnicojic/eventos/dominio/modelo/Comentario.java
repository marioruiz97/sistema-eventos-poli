package edu.politecnicojic.eventos.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comentario {

    String mensaje;
    String nombreUsuario;
}
