package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controles;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BuscarConMatricula extends Controlador {
	@FXML
    private TextField tfMatricula;
    
	private boolean cancelado;

    
    
    @FXML
	void initialize() {
    	
    	tfMatricula.textProperty().addListener((ob,ov,nv)-> Controles.validarCampoTexto(Vehiculo.ER_MATRICULA,tfMatricula));

    }
	public String getMatricula() {
		
	
	return cancelado ? null : tfMatricula.getText();

	
	
	}
	public void limpiar() {
		tfMatricula.setText("");
		cancelado=true;
		
	}
	@FXML
	void aceptar() {
		cancelado=false;
		getEscenario().close();
	}
	@FXML
	void cancelar() {
		cancelado=true;
		getEscenario().close();
	}
	
	
}







