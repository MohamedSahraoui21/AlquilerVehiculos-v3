package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controles;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BuscarConDni extends Controlador{
	 
	    @FXML
	    private TextField tfDni;
	    
		private boolean cancelado;

	    
	    
	    @FXML
		void initialize() {
	    	
		tfDni.textProperty().addListener((ob,ov,nv)-> Controles.validarCampoTexto(Cliente.ER_DNI,tfDni));

	    }
		public String getDni() {
			
		
		return cancelado ? null : tfDni.getText();

		
		
		}
		public void limpiar() {
			tfDni.setText("");
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




