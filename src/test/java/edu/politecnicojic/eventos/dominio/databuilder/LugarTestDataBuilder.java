package edu.politecnicojic.eventos.dominio.databuilder;

import edu.politecnicojic.eventos.dominio.modelo.lugar.Lugar;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Sede;
import edu.politecnicojic.eventos.dominio.modelo.lugar.Ciudad;

public class LugarTestDataBuilder {

	private static final String NOMBRE = "P40";
	private static final String DIRECCION = "Clle 10 # 43a - 120";
	private static final Ciudad CIUDAD = new Ciudad("MEDELLIN", "ANTIOQUIA");
	private static final Sede SEDE = new Sede("POBLADO", CIUDAD);

	private String nombre;
	private String direccion;
	private Ciudad ciudad;
	private Sede sede;

	public LugarTestDataBuilder() {
		this.nombre = NOMBRE;
		this.direccion = DIRECCION;
		this.ciudad = CIUDAD;
		this.sede = SEDE;
	}

	public LugarTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public LugarTestDataBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public LugarTestDataBuilder conSede(Sede sede) {
		this.sede = sede;
		return this;
	}

	public Lugar build() {
		return new Lugar(nombre, direccion, ciudad, sede);
	}

}