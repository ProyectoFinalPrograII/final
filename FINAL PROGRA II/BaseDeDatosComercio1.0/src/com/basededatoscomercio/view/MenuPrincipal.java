package com.basededatoscomercio.view;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

	public static int menu(Scanner scanner, String tipo) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Registrar Usuario ");
				System.out.println("2. Usuario Registrado ");

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
		IUVendedor iUVendedor;
		Vendedor vendedor;
	

		while (!salir) {
			switch (menu(leer, tipo)) {
			case 0:
				salir = true;
				break;
			case 1:
				iUVendedor = new IUVendedor(leer);
				iUVendedor.ingresar();
				iUVendedor.getVendedor().insert();
				//iUVendedor.ingresar();
				
				//iUMedicamento = new IUMedicamento(leer);
				//iUMedicamento.ingresar();
				//iUMedicamento.getMedicamento().insert();
				break; 
			case 2:
				vendedor = new Vendedor();
				int codigo = 0;
				String contraseña = "";
				
				System.out.println("Ingrese su codigo:");
				codigo = leer.nextInt();
				leer.nextLine();
				System.out.println("Ingrese su contraseña:");
				contraseña = leer.nextLine();
				vendedor.search(codigo);
				if (codigo == vendedor.getCodigoVendedor())//vendedor.getCodigoVendedor())
				{
					//if (contraseña == "a")
					//{
						MenuVendedor.menu(leer);
					}
					else
					{
						System.out.println("Ingresar Menu Administrador");
					
					}
					//System.out.println("Codigo y contraseña incorrectas!");
				
				
				//vendedor.delete(ReadTypes.leerEntero(leer, "Ingrese el codigo a eliminar: "));
				break;
			/*case 3:
				ArrayList<Product> products;
				int tamaño;
				product = new Producto();
				productos = producto.list();
				tamaño = productos.size();
				for (int i = 0; i < tamaño; i++){
					System.out.println(medicamentos.get(i));
				}
				break;
			case 4:
				producto = new Producto();
				medicamento.search(ReadTypes.leerEntero(leer, "Ingrese el codigo a actualizar: "));
				if (producto.getCodigoProducto() == 0) {
					System.out.println("Codigo inexistente! ");
				} else {
					System.out.println(producto);
					System.out.println();
					subMenuActualizar(leer, "producto", producto);
					System.out.println(producto);
					medicamento.update(producto);
				}
				break; 
				*/
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
			case 6:
				iUProducto.setCodigo();
				break;
			}
		}

	}
	
}

