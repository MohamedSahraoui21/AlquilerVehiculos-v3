package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.time.LocalDate;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListarAlquileres extends Controlador {
	@FXML
	private Button btAceptar;
	@FXML
	private TableColumn<Alquiler, Cliente> tcCliente;

	@FXML
	private TableColumn<Alquiler, Vehiculo> tcVehiculo;

	@FXML
	private TableColumn<Alquiler, LocalDate> tcFechaAlquiler;

	@FXML
	private TableColumn<Alquiler, LocalDate> tcFechaDevolucion;

	@FXML
	private TableColumn<Alquiler, Integer> tcPrecio;

	@FXML
	private TableView<Alquiler> tvAlquileres;

	@FXML

	void aceptar(ActionEvent event) {
		getEscenario().close();

	}

	@FXML

	void initialize() {

		tcCliente.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getCliente()));
		tcVehiculo.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getVehiculo()));
		tcFechaAlquiler.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getFechaAlquiler()));
		tcFechaDevolucion.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getFechaDevolucion()));
		tcPrecio.setCellValueFactory(fila -> new SimpleIntegerProperty(fila.getValue().getPrecio()).asObject());

	}

	public void actualizar(List<Alquiler> alquileres) {
		tvAlquileres.setItems(FXCollections.observableArrayList(alquileres));

	}

}
