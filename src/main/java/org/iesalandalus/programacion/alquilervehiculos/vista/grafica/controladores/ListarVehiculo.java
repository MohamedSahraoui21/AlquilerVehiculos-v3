package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.List;


import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarVehiculo extends Controlador {
	@FXML

	private Button btAceptar;

	@FXML

	private TableColumn<Vehiculo, String> tcMatricula;

	@FXML

	private TableColumn<Vehiculo, String> tcMarca;

	@FXML

	private TableColumn<Vehiculo, String> tcModelo;
	@FXML

	private TableColumn<Vehiculo, String> tcCilindrada;
	@FXML

	private TableColumn<Vehiculo, String> tcPlazas;
	@FXML

	private TableColumn<Vehiculo, String> tcPMA;

	@FXML

	private TableView<Vehiculo> tvVehiculos;

	@FXML

	void aceptar(ActionEvent event) {

		getEscenario().close();

	}

	@FXML

	void initialize() {

		tcMatricula.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getMatricula()));

		tcMarca.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getMarca()));

		tcModelo.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getModelo()));
		tcCilindrada.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));
		tcPlazas.setCellValueFactory(new PropertyValueFactory<>("plazas"));
		tcPMA.setCellValueFactory(new PropertyValueFactory<>("pma"));




	}

	public void actualizar(List<Vehiculo> vehiculos) {

		tvVehiculos.setItems(FXCollections.observableArrayList(vehiculos));

	}

}


