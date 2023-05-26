package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.TipoVehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controles;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class LeerVehiculo extends Controlador {
	@FXML
	private ComboBox<String> cbTipoDeVehiculo;

	@FXML
	private TextField tfCilindrada;

	@FXML
	private TextField tfMarca;

	@FXML
	private TextField tfMatricula;

	@FXML
	private TextField tfModelo;

	@FXML
	private TextField tfNplazas;

	@FXML
	private TextField tfPMA;

	private boolean cancelado;

	@FXML
	void initialize() {
		cbTipoDeVehiculo.setItems(FXCollections.observableArrayList(TipoVehiculo.TURISMO.toString(),
				TipoVehiculo.FURGONETA.toString(), TipoVehiculo.AUTOBUS.toString()));
		tfMarca.textProperty().addListener((ob, ov, nv) -> Controles.validarCampoTexto(Vehiculo.ER_MARCA, tfMarca));
		tfMatricula.textProperty()
				.addListener((ob, ov, nv) -> Controles.validarCampoTexto(Vehiculo.ER_MATRICULA, tfMatricula));

	}

	public Vehiculo getVehiculo() {
		String marca = tfMarca.getText();
		String modelo = tfModelo.getText();
		String matricula = tfMatricula.getText();
		Vehiculo coche = Vehiculo.getVehiculoConMatricula(matricula);
		TipoVehiculo tipoV = TipoVehiculo.get(coche);
		if (tipoV == TipoVehiculo.TURISMO) {
			int cilindrada = Integer.parseInt(tfCilindrada.getText());

			coche = new Turismo(marca, modelo, cilindrada, matricula);

		}
		if (tipoV == TipoVehiculo.FURGONETA) {
			int pma = Integer.parseInt(tfPMA.getText());
			int plazas = Integer.parseInt(tfNplazas.getText());

			coche = new Furgoneta(marca, modelo, pma, plazas, matricula);

		}
		if (tipoV == TipoVehiculo.AUTOBUS) {
			int plazas = Integer.parseInt(tfNplazas.getText());
			coche = new Autobus(marca, modelo, plazas, matricula);
		}
		return cancelado ? null : coche;
	}

	public void deshabilitarHabilitarCampos() {
	    if (cbTipoDeVehiculo.getValue().equals(TipoVehiculo.TURISMO.toString())) {
	        Controles.deshabilitarCamposTexto(tfPMA, tfNplazas);
	        Controles.habilitarCamposTexto(tfCilindrada);
	    } else if (cbTipoDeVehiculo.getValue().equals(TipoVehiculo.AUTOBUS.toString())) {
	        Controles.deshabilitarCamposTexto(tfCilindrada, tfPMA);
	        Controles.habilitarCamposTexto(tfNplazas);
	    } else if (cbTipoDeVehiculo.getValue().equals(TipoVehiculo.FURGONETA.toString())) {
	        Controles.deshabilitarCamposTexto(tfCilindrada, tfNplazas);
	        Controles.habilitarCamposTexto(tfPMA);
	    }
	}


	public void limpiar() {
		tfCilindrada.setText("");
		tfMarca.setText("");
		tfMatricula.setText("");
		tfModelo.setText("");
		tfNplazas.setText("");
		tfPMA.setText("");

		cancelado = true;

	}

	@FXML
	void aceptar() {
		cancelado = false;
		getEscenario().close();
	}

	@FXML
	void cancelar() {
		cancelado = true;
		getEscenario().close();
	}

}
