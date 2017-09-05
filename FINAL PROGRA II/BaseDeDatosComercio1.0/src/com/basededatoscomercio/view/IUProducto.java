package com.basededatoscomercio.view;


	import java.util.Scanner;

	public class IUProducto {
	
		private Producto producto;
		private Scanner leer;
		
		public IUProducto(Scanner leer) {
			producto = new Producto();
			this.leer = leer;
		}

		public void ingresar() {
			
			this.setNombre();
			this.setPrecio();
			this.setStock();
			this.setCategoria();
			this.setFechaVencimiento();
		
		}
		
		public void actualizar(){
			
		}
		
		public void setCodigo(){
			producto.setCodigoProducto(ReadTypes.leerEntero(leer, "Ingrese el cï¿½digo: "));
		}

		public void setNombre(){
			producto.setNombre(ReadTypes.leerCadena(leer, "Ingrese el nombre del Producto: "));
		}
		
		public void setPrecio(){
			producto.setPrecio(ReadTypes.leerReal(leer, "Ingrese el precio del producto: "));
		}
		
		public void setStock(){
			producto.setStock(ReadTypes.leerEntero(leer, "Ingrese la cantidad del producto: "));
		}
		
		
		public void setFechaVencimiento(){
			producto.setFechaVencimiento( ReadTypes.leerFecha(leer, "Ingrese la fecha de vencimiento: "));
		}
		
		
		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}
		
		public void setCategoria(){
			producto.setCategoria(ReadTypes.leerCadena(leer, "Ingrese categoria: "));
		}
	}


