package com.basededatoscomercio.view;
import java.util.Scanner;

import com.basededatoscomercio.view.MenuPrincipal;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		MenuPrincipal.subMenu(scanner, "Producto");;
		scanner.close();

	}

}