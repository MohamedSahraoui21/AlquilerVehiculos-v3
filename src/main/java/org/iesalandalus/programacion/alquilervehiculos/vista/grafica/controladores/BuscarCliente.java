package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class BuscarCliente extends Controlador{

	@FXML private Label lbNombre;
	@FXML private Label lbDni;
	@FXML private Label lbTelefono;
	
	
	@FXML
	void initialize() {
		System.out.println("Buscar Cliente");

	}
	
	 
	void buscar(Cliente cliente) {
		if(cliente!=null) {
			lbNombre.setText(cliente.getNombre());
			lbDni.setText(cliente.getDni());
			lbTelefono.setText(cliente.getTelefono());

		}
		
	}
	
	
	
		
	
	@FXML
	void cancelar() {
		
		getEscenario().close();
	}
	@FXML
	void modificar() {
		
		
	}
	@FXML
	void borrarCliente(ActionEvent event) {
		Cliente cliente =Cliente.getClienteConDni(lbDni.getText());
		
		if(cliente!=null) {
			Alert confirmacion=new Alert(AlertType.CONFIRMATION);
			confirmacion.setTitle("borrar cliente");
			confirmacion.setHeaderText("Quieres borrar este cliente?");
			
			Optional<ButtonType> resultado =confirmacion.showAndWait();
			if(resultado.get()==ButtonType.OK) {
				try {
					VistaGrafica.getInstancia().getControlador().borrar(cliente);
					Dialogos.mostrarDialogoConfirmacion("Borrar cliente", "Este cliente se ha borrado correctamente", getEscenario());
					getEscenario().close();
				}catch(OperationNotSupportedException e) {
					Dialogos.mostrarDialogoError("Borrar cliente",e.getMessage() , getEscenario());
				}
			}

		}
		
		
		
	}
	@FXML 
	void devolver() {
		
		
	}
	@FXML
	void listarAlquileres(ActionEvent event) {
		ListarAlquileres listarAlquileres = (ListarAlquileres) Controladores.get("vistas/ListarAlquileres.fxml",
				"ListarAlquileres", getEscenario());
		listarAlquileres.actualizar(VistaGrafica.getInstancia().getControlador().getAlquileres(Cliente.getClienteConDni(lbDni.getText())));
		listarAlquileres.getEscenario().showAndWait();
		
		
	}
	

}
