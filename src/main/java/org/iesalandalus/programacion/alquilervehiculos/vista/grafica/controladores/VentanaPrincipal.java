package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;


import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controladores;

import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VentanaPrincipal extends Controlador {
	

	@FXML
	private void initialize() {
		System.out.println("metodo initialize de VentanaPrincipal");
	}

	@FXML
	void listarClientes( ActionEvent event) {
		//System.out.println("buton pulsado");
		ListarClientes listarClientes = (ListarClientes) Controladores.get("vistas/ListarClientes.fxml",
				"ListarClientes", getEscenario());
		listarClientes.actualizar(VistaGrafica.getInstancia().getControlador().getClientes());
		listarClientes.getEscenario().showAndWait();
	}

	@FXML
	void confirmarSalida() {
		if (Dialogos.mostrarDialogoConfirmacion("salir", "estas seguro que quieres salir de la aplicacion",
				getEscenario())) {
			getEscenario().close();
		}
	}

	@FXML
	void leerCliente(ActionEvent event) {
		LeerCliente leerCliente = (LeerCliente) Controladores.get("vistas/LeerCliente.fxml", 
				"leer Cliente",getEscenario());
		leerCliente.limpiar();
		leerCliente.getEscenario().showAndWait();
		try {
			Cliente cliente =leerCliente.getCliente();
			if(cliente!=null) {
				VistaGrafica.getInstancia().getControlador().insertar(cliente);
				Dialogos.mostrarDialogoAdvertencia("insertar cliente", "cliente insertado correctamente", getEscenario());
				}
		}catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			Dialogos.mostrarDialogoError("Insertar Cliente", e.getMessage(), getEscenario());
		}
	}

	@FXML
	void buscarConDni(ActionEvent event) {
		BuscarConDni buscarConDni = (BuscarConDni) Controladores.get("vistas/BuscarConDni.fxml", 
				"Buscar Con Dni",getEscenario());
		buscarConDni.limpiar();
		buscarConDni.getEscenario().showAndWait();
		try {
			String buscardni = buscarConDni.getDni();
			if(buscarConDni!=null) {
				Cliente clienteBuscado=VistaGrafica.getInstancia().getControlador().buscar(Cliente.getClienteConDni(buscardni));
				if(clienteBuscado!=null) {
					BuscarCliente buscarCliente = (BuscarCliente) Controladores.get("vistas/BuscarCliente.fxml", 
							"Buscar Cliente",getEscenario());
					buscarCliente.buscar(clienteBuscado);
					buscarCliente.getEscenario().showAndWait();
					
				}else {
					Dialogos.mostrarDialogoInformacion("buscar con dni", "No hay ningun cliente con este Dni", getEscenario());

				}
				
			}
			
			
		} catch ( IllegalArgumentException | NullPointerException e) {
			Dialogos.mostrarDialogoError("Buscar Cliente", e.getMessage(), getEscenario());
			
		}
}
	@FXML
	void listarVehiculo( ActionEvent event) {
		//System.out.println("buton pulsado");
		ListarVehiculo listarVehiculo = (ListarVehiculo) Controladores.get("vistas/ListarVehiculo.fxml",
				"ListarVehiculo", getEscenario());
		listarVehiculo.actualizar(VistaGrafica.getInstancia().getControlador().getVehiculos());
		listarVehiculo.getEscenario().showAndWait();
	}
	@FXML
	void leerVehiculo(ActionEvent event) {
		LeerVehiculo leerVehiculo = (LeerVehiculo) Controladores.get("vistas/LeerVehiculo.fxml", 
				"leer vehiculo",getEscenario());
		leerVehiculo.limpiar();
		leerVehiculo.getEscenario().showAndWait();
		try {
			Vehiculo vehiculo =leerVehiculo.getVehiculo();
			if(vehiculo!=null) {
				VistaGrafica.getInstancia().getControlador().insertar(vehiculo);
				Dialogos.mostrarDialogoAdvertencia("insertar vehiculo", "Vehiculo insertado correctamente", getEscenario());
				}
		}catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			Dialogos.mostrarDialogoError("Insertar Vehiculo", e.getMessage(), getEscenario());
		}
}
	@FXML
	void listarAlquileres( ActionEvent event) {
		//System.out.println("buton pulsado");
		ListarAlquileres listarAlquileres = (ListarAlquileres) Controladores.get("vistas/ListarAlquileres.fxml",
				"ListarAlquileres", getEscenario());
		listarAlquileres.actualizar(VistaGrafica.getInstancia().getControlador().getAlquileres());
		listarAlquileres.getEscenario().showAndWait();
	}
	@FXML
	void buscarConMatricula(ActionEvent event) {
		BuscarConMatricula buscarConMatricula = (BuscarConMatricula) Controladores.get("vistas/BuscarConMatricula.fxml", 
				"Buscar Con Matricula",getEscenario());
		buscarConMatricula.limpiar();
		buscarConMatricula.getEscenario().showAndWait();
		try {
			String buscarMatricula = buscarConMatricula.getMatricula();
			if(buscarMatricula!=null) {
				Vehiculo vehiculoBuscado=VistaGrafica.getInstancia().getControlador().buscar(Vehiculo.getVehiculoConMatricula(buscarMatricula));
				if(vehiculoBuscado!=null) {
					BuscarVehiculo buscarVehiculo = (BuscarVehiculo) Controladores.get("vistas/BuscarVehiculo.fxml", 
							"Buscar Vehiculo",getEscenario());
					buscarVehiculo.buscar(vehiculoBuscado);
					buscarVehiculo.getEscenario().showAndWait();
					
				}else {
					Dialogos.mostrarDialogoInformacion("buscar con matricula", "No hay ningun vehiculo con esta matricula", getEscenario());

				}
				
			}
			
			
		} catch ( IllegalArgumentException | NullPointerException e) {
			Dialogos.mostrarDialogoError("Buscar Vehiculo", e.getMessage(), getEscenario());
			
		}
}
	@FXML
	void buscarAlquilerConDniMatricula(ActionEvent event) {
		BuscarAlquilerConDniMatricula buscarAlquilerConDniMatricula = (BuscarAlquilerConDniMatricula) Controladores.get("vistas/BuscarAlquilerConDniMatricula.fxml", 
				"Buscar Alquiler Con Dni Matricula",getEscenario());
		buscarAlquilerConDniMatricula.limpiar();
		buscarAlquilerConDniMatricula.getEscenario().showAndWait();
		try {
			Alquiler buscarDniMatricula = buscarAlquilerConDniMatricula.getAlquiler();
			if(buscarDniMatricula!=null) {
				Alquiler alquilerBuscado=VistaGrafica.getInstancia().getControlador().buscar(buscarDniMatricula);
				if(alquilerBuscado!=null) {
					BuscarAlquiler buscarAlquiler = (BuscarAlquiler) Controladores.get("vistas/BuscarAlquiler.fxml", 
							"Buscar Alquiler",getEscenario());
					buscarAlquiler.buscar(alquilerBuscado);
					buscarAlquiler.getEscenario().showAndWait();
					
				}else {
					Dialogos.mostrarDialogoInformacion("buscar alquiler con dni matricula", "No hay ningun alquiler con este dni y matricula", getEscenario());

				}
				
			}
			
			
		} catch ( IllegalArgumentException | NullPointerException e) {
			Dialogos.mostrarDialogoError("Buscar Alquiler", e.getMessage(), getEscenario());
			
		}
}
	@FXML
	void leerAlquiler(ActionEvent event) {
		LeerAlquiler leerAlquiler = (LeerAlquiler) Controladores.get("vistas/LeerAlquiler.fxml", 
				"leer vehiculo",getEscenario());
		leerAlquiler.limpiar();
		leerAlquiler.getEscenario().showAndWait();
		try {
			Alquiler alquiler =leerAlquiler.getAlquiler();
			if(alquiler!=null) {
				VistaGrafica.getInstancia().getControlador().insertar(alquiler);
				Dialogos.mostrarDialogoAdvertencia("insertar alquiler", "Alquiler insertado correctamente", getEscenario());
				}
		}catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			Dialogos.mostrarDialogoError("Insertar Alquiler", e.getMessage(), getEscenario());
		}
}
	@FXML
	void acerca(ActionEvent event) {
		Acerca acerca = (Acerca) Controladores.get("vistas/Acerca.fxml", 
				"acerca",getEscenario());
		acerca.getEscenario().showAndWait();
	}
	
}