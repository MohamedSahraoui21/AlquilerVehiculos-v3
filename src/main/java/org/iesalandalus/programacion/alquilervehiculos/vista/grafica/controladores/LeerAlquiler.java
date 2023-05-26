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

public class LeerAlquiler extends Controlador {

	@FXML private TextField tfDni;
	@FXML private TextField tfMatricula;
	@FXML
    private DatePicker dpFecha;	
	private boolean cancelado;
	
	
	@FXML
	void initialize() {
		tfDni.textProperty().addListener((ob,ov,nv)-> Controles.validarCampoTexto(Cliente.ER_DNI,tfDni));
		tfMatricula.textProperty().addListener((ob,ov,nv)-> Controles.validarCampoTexto(Vehiculo.ER_MATRICULA ,tfMatricula));

	}
	
	public Alquiler getAlquiler() {
		String dni=tfDni.getText();
		String matricula=tfMatricula.getText();
        
		Cliente cliente = Cliente.getClienteConDni(dni);
		Vehiculo vehiculo = Vehiculo.getVehiculoConMatricula(matricula);
		LocalDate fechaAlquiler=dpFecha.getValue();
		
		return cancelado ? null : new Alquiler(cliente, vehiculo,fechaAlquiler);
		
		
	}
	
	public void limpiar() {
		tfDni.setText("");
		tfMatricula.setText("");
		dpFecha.setValue(null);

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
		
	




