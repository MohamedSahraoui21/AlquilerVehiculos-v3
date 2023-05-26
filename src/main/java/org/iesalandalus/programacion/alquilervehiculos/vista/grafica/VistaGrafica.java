package org.iesalandalus.programacion.alquilervehiculos.vista.grafica;

import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class VistaGrafica extends Vista {
	private static VistaGrafica instancia;
	public static VistaGrafica getInstancia() {
		if(instancia==null) {
			instancia=new VistaGrafica();
		}
		return instancia;
	}
	public VistaGrafica() {
		
	}
	
	@Override
	public void comenzar() {
		LanzadorVentanaPrincipal.comenzar();
		getInstancia().terminar();
	}

	@Override
	public void terminar() {
		System.out.println("Hasta Luego");
		
	}
	
}
