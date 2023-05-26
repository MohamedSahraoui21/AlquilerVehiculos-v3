package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.Optional;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.TipoVehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class BuscarVehiculo extends Controlador{
	
	@FXML
    private Label lbMarca;

    @FXML
    private Label lbMatricula;

    @FXML
    private Label lbModelo;
	
	@FXML
    private Label lbCilindrada;

    @FXML
    private Label lbPlazas;

    @FXML
    private Label lbPma;
    
    Vehiculo vehiculo;
    
    @FXML
	void initialize() {
		System.out.println("Buscar Vehiculo");

	}
	
	 
	void buscar(Vehiculo vehiculo) {
		if(vehiculo!=null) {
			lbMarca.setText(vehiculo.getMarca());
			lbMatricula.setText(vehiculo.getMatricula());
			lbModelo.setText(vehiculo.getModelo());
           if (TipoVehiculo.get(vehiculo)==TipoVehiculo.TURISMO) {
        	   lbCilindrada.setText(String.valueOf(((Turismo)vehiculo).getCilindrada()));
        	   
        	   
			}else if (TipoVehiculo.get(vehiculo)==TipoVehiculo.AUTOBUS ) {
				lbPlazas.setText(String.valueOf(((Autobus)vehiculo).getPlazas()));
			
		}else if(TipoVehiculo.get(vehiculo)==TipoVehiculo.FURGONETA) {
			lbPlazas.setText(String.valueOf(((Furgoneta)vehiculo).getPlazas()));
    	   lbPma.setText(String.valueOf(((Furgoneta)vehiculo).getPma()));

			
		}

			

			
		}
		
	}

    @FXML
    void borrarVehiculo(ActionEvent event) {
        Vehiculo vehiculo =Vehiculo.getVehiculoConMatricula(lbMatricula.getText());
		
		if(vehiculo!=null) {
			Alert confirmacion=new Alert(AlertType.CONFIRMATION);
			confirmacion.setTitle("borrar vehiculo");
			confirmacion.setHeaderText("Quieres borrar este vehiculo?");
			
			Optional<ButtonType> resultado =confirmacion.showAndWait();
			if(resultado.get()==ButtonType.OK) {
				try {
					VistaGrafica.getInstancia().getControlador().borrar(vehiculo);
					Dialogos.mostrarDialogoConfirmacion("Borrar vehiculo", "Este vehiculo se ha borrado correctamente", getEscenario());
					getEscenario().close();
				}catch(OperationNotSupportedException e) {
					Dialogos.mostrarDialogoError("Borrar vehiculo",e.getMessage() , getEscenario());
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
		ListarAlquileres listarAlquileres = (ListarAlquileres) Controladores.get("vistas/ListarAlquileres.fxml",
				"ListarAlquileres", getEscenario());
		listarAlquileres.actualizar(VistaGrafica.getInstancia().getControlador().getAlquileres(Vehiculo.getVehiculoConMatricula(lbMatricula.getText())));
		listarAlquileres.getEscenario().showAndWait();
		
		
	}

}


