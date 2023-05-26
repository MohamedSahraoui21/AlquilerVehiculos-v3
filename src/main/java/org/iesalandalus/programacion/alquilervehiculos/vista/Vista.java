//MOHAMED SAHRAOUI 1DAW

package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public abstract class Vista {

	private Controlador controlador;

	
	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("El controlador no puede ser nulo");
		}
		this.controlador = controlador;
	}

	public abstract void comenzar();

	public abstract void terminar();
}