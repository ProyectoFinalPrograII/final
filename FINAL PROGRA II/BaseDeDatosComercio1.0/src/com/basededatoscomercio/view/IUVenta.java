package com.basededatoscomercio.view;

import java.util.Scanner;

public class IUVenta {
	private Venta venta;
	private Scanner leer;
	
	public IUVenta(Scanner leer) {
		venta = new Venta();
		this.leer = leer;
	}

	public void ingresar() {
		
		this.setCodigoCliente();
		this.setCodigoVendedor();
		this.setFechaVenta();;
		this.setPrecioTotal();
	}
	
	public void actualizar(){
		
	}
	
	//public void setCodigo(){
		//venta.setCodigoVenta(ReadTypes.leerEntero(leer, "Ingrese el codigo del vendedor: "));
	//}
	public void setCodigoVendedor(){
		venta.setCodigoVendedor(ReadTypes.leerEntero(leer, "Ingrese el codigo del vendedor: "));
	}

	public void setFechaVenta(){
		venta.setFechaVenta(ReadTypes.leerFecha(leer, "Ingrese la fecha de la venta: "));
	}
	
	public void setCodigoCliente(){
		venta.setCodigoCliente(ReadTypes.leerEntero(leer, "Ingrese el codigo del cliente: "));
	}
	
	public void setPrecioTotal(){
		venta.setPrecioTotal(venta.getPrecioTotal());
	}
	
	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
}
