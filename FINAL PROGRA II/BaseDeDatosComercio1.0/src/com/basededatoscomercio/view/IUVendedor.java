package com.basededatoscomercio.view;
import java.util.Scanner;

public class IUVendedor {
	private Vendedor vendedor;
	private Scanner leer;
	
	public IUVendedor(Scanner leer) {
		vendedor = new Vendedor();
		this.leer = leer;
	}

	public void ingresar() {
		
		this.setNombre();
		this.setApellidos();
		this.setFechaNacimiento();
		this.setTelefono();
		this.setEmail();
		this.setContraseña();
	}
	
	public void actualizar(){
		
	}
	
	public void setCodigo(){
		vendedor.setCodigoVendedor(ReadTypes.leerEntero(leer, "Ingrese el codigo del vendedor: "));
	}
	public void getCodigo(){
		vendedor.setCodigoVendedor(ReadTypes.leerEntero(leer, "Ingrese el codigo del vendedor: "));
	}

	public void setNombre(){
		vendedor.setNombre(ReadTypes.leerCadena(leer, "Ingrese su nombre: "));
	}
	
	public void setApellidos(){
		vendedor.setApellidos(ReadTypes.leerCadena(leer, "Ingrese sus apellidos: "));
	}
	
	public void setFechaNacimiento(){
		vendedor.setFechaNacimiento(ReadTypes.leerFecha(leer, "Ingrese su fecha de nacimiento: "));
	}
	
	
	public void setTelefono(){
		vendedor.setTelefono( ReadTypes.leerEntero(leer, "Ingrese su numero de telefono: "));
	}
	
	public void setEmail(){
		vendedor.setEmail(ReadTypes.leerCadena(leer, "Ingrese su email: "));
	}
	
	
	public void setContraseña(){
		vendedor.setContraseña(ReadTypes.leerCadena(leer, "Ingrese su contraseÃ±a: "));
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}

