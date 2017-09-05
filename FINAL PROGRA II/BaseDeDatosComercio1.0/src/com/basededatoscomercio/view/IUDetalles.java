package com.basededatoscomercio.view;
import java.util.Scanner;

public class IUDetalles {
  private Detalles detalles;
private Scanner leer;

public IUDetalles(Scanner leer) {
  detalles = new Detalles();
  this.leer = leer;
}

public void insertar() {
  
  this.setStock();
  this.setPrecio();
 
}

public void actualizar(){
  
}

//public void setCodigo(){
  //proveedor.setCodigoProducto(ReadTypes.leerEntero(leer, "Ingrese el cÃ¯Â¿Â½digo: "));
//}

public void setStock(){
  detalles.setStock(ReadTypes.leerEntero(leer, "Ingrese la cantidad del producto: "));
}

public void setPrecio(){
  detalles.setPrecio(ReadTypes.leerEntero(leer, "Ingrese el precio: "));
}


public Detalles getDetalles() {
  return detalles;
}

public void setDetalles(Detalles detalles) {
  this.detalles = detalles;
}

}