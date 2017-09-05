package com.basededatoscomercio.view;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuProducto {public static int menu(Scanner scanner, String tipo) {

	int opcion;

	while (true) {
		try {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar " + tipo);
			System.out.println("2. Eliminar " + tipo);
			System.out.println("3. Listar " + tipo + "s");
			System.out.println("4. Actualizar ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = scanner.nextInt();
			scanner.nextLine();

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}

		} catch (java.util.InputMismatchException e) {
			System.out.println("Ingrese solo valores numericos");
			System.out.println();
			scanner.nextLine();
		}
	}
}

public static void subMenu(Scanner leer, String tipo) {
	boolean salir = false;
	IUProducto iUProducto;
	Producto producto;


	while (!salir) {
		switch (menu(leer, tipo)) {
		case 0:
			salir = true;
			break;
		case 1:
			iUProducto = new IUProducto(leer);
			iUProducto.ingresar();
			iUProducto.getProducto().insert();
			break;
		case 2:
			producto = new Producto();
			producto.delete(ReadTypes.leerEntero(leer, "Ingrese el codigo a eliminar: "));
			break;
		case 3:
			ArrayList<Producto> productos;
			int tamaño;
			producto = new Producto();
			productos = producto.list();
			tamaño = productos.size();
			for (int i = 0; i < tamaño; i++){
				System.out.println(productos.get(i));
			}
			break;
		case 4:
			producto = new Producto();
			producto.search(ReadTypes.leerEntero(leer, "Ingrese el codigo a actualizar: "));
			if (producto.getCodigoProducto() == 0) {
				System.out.println("Codigo inexistente! ");
			} else {
				System.out.println(producto);
				System.out.println();
				subMenuActualizar(leer, "producto", producto);
				System.out.println(producto);
				producto.update(producto);
			}
			break;
		}
	}

}

public static int actualizar(Scanner leer, String tipo) {
	int opcion;

	while (true) {
		try {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Nombre " + tipo);
			System.out.println("2. Precio " + tipo);
			System.out.println("3. Cantidad " + tipo);
			System.out.println("4. Fecha vencimiento ");
			System.out.println("5. Codigo Proveedor ");
			System.out.println("6. Salir");
			System.out.println();

			opcion = leer.nextInt();

			if (opcion >= 0 && opcion <= 6) {
				leer.nextLine();
				return opcion;
			}

		} catch (java.util.InputMismatchException e) {
			System.out.println("Ingrese solo valores numericos");
			System.out.println();
			leer.nextLine();
		}
	}
}

public static void subMenuActualizar(Scanner leer, String tipo, Producto producto) {
	boolean salir = false;
	IUProducto iUProducto = new IUProducto(leer);

	iUProducto.setProducto(producto);
	while (!salir) {
		switch (actualizar(leer, tipo)) {
		case 0:
			salir = true;
			break;
		case 1:
			iUProducto.setNombre();
			break;
		case 2:
			iUProducto.setPrecio();
			break;
		case 3:
			iUProducto.setStock();
			break;
		case 4:
			iUProducto.setCategoria();
			break;
		case 5:
			iUProducto.setFechaVencimiento();
			break;
		
		}
	}

}	


}
