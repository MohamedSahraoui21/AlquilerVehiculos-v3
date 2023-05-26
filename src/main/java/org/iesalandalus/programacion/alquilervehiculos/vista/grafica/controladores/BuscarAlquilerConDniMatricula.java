package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;
import java.time.LocalDate;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controles;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BuscarAlquilerConDniMatricula extends Controlador {
	@FXML
    private TextField tfDni;
	@FXML
    private TextField tfMatricula;
	@FXML
    private DatePicker dpFechaAlquiler;
	
	private boolean cancelado;
	
	 @FXML
		void initialize() {
	    	
	    	tfMatricula.textProperty().addListener((ob,ov,nv)-> Controles.validarCampoTexto(Vehiculo.ER_MATRICULA,tfMatricula));
			tfDni.textProperty().addListener((ob,ov,nv)-> Controles.validarCampoTexto(Cliente.ER_DNI,tfDni));
			
			
	 }
			public Alquiler getAlquiler() {
				Cliente cliente=Cliente.getClienteConDni(tfDni.getText());
				Vehiculo vehiculo=Vehiculo.getVehiculoConMatricula(tfMatricula.getText());
				LocalDate fechaAlquiler=dpFechaAlquiler.getValue();
				
				return cancelado ? null : new Alquiler(cliente,vehiculo,fechaAlquiler);
				


	    }
			public void limpiar() {
				tfMatricula.setText("");
				tfDni.setText("");
				dpFechaAlquiler.setValue(null);
				
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
