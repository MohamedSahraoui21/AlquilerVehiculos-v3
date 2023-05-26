package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.time.LocalDate;
import java.util.Optional;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class BuscarAlquiler extends Controlador {

	Alquiler alquiler;
	@FXML
	private Label lbCilindrada;

	@FXML
	private Label lbDni;

	@FXML
	private Label lbFechaAlquiler;

	@FXML
	private Label lbFechaDevolution;

	@FXML
	private Label lbMarca;

	@FXML
	private Label lbMatricula;

	@FXML
	private Label lbModelo;

	@FXML
	private Label lbNombre;

	@FXML
	private Label lbPlazas;

	@FXML
	private Label lbPma;

	@FXML
	private Label lbPrecio;

	@FXML
	private Label lbTelefono;

	@FXML
	void initialize() {
		System.out.println("Buscar Alquiler");

	}

	void buscar(Alquiler alquiler) {
		LocalDate fechadev = alquiler.getFechaDevolucion();
		if (alquiler != null) {
			lbFechaAlquiler.setText(alquiler.getFechaAlquiler().format(Alquiler.FORMATO_FECHA));
			lbMarca.setText(alquiler.getVehiculo().getMarca());
			lbTelefono.setText(alquiler.getCliente().getTelefono());
			lbNombre.setText(alquiler.getCliente().getNombre());
			lbDni.setText(alquiler.getCliente().getDni());
			lbModelo.setText(alquiler.getVehiculo().getModelo());
			lbMatricula.setText(alquiler.getVehiculo().getMatricula());
			if (fechadev != null) {
				lbFechaDevolution.setText(alquiler.getFechaDevolucion().format(Alquiler.FORMATO_FECHA));

			} else {

				lbFechaDevolution.setText("");

			}
			lbPrecio.setText(String.valueOf(alquiler.getPrecio()));
			Vehiculo vehiculo = alquiler.getVehiculo();
			if (vehiculo instanceof Turismo) {

				lbCilindrada.setText(String.valueOf(((Turismo) vehiculo).getCilindrada()));

			} else if (vehiculo instanceof Autobus) {
				lbPlazas.setText(String.valueOf(((Autobus) vehiculo).getPlazas()));

			} else if (vehiculo instanceof Furgoneta) {
				lbPlazas.setText(String.valueOf(((Furgoneta) vehiculo).getPlazas()));
				lbPma.setText(String.valueOf(((Furgoneta) vehiculo).getPma()));

			}

		}
	}

	@FXML
	void borrarAlquiler(ActionEvent event) {

		if (alquiler != null) {
			Alert confirmacion = new Alert(AlertType.CONFIRMATION);
			confirmacion.setTitle("borrar alquiler");
			confirmacion.setHeaderText("Quieres borrar este alquiler?");

			Optional<ButtonType> resultado = confirmacion.showAndWait();
			if (resultado.get() == ButtonType.OK) {
				try {
					VistaGrafica.getInstancia().getControlador().borrar(alquiler);
					Dialogos.mostrarDialogoConfirmacion("Borrar alquiler", "Este alquiler se ha borrado correctamente",
							getEscenario());
					getEscenario().close();
				} catch (OperationNotSupportedException e) {
					Dialogos.mostrarDialogoError("Borrar alquiler", e.getMessage(), getEscenario());
				}
			}

		}

	}

	@FXML
	void cancelar(ActionEvent event) {
		getEscenario().close();

	}

	@FXML
	void devolver(ActionEvent event) {

	}

	@FXML
	void listarAlquileres(ActionEvent event) {

	}

}
