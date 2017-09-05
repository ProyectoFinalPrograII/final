package com.basededatoscomercio.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadTypes {

	public static Date leerFecha(Scanner leer, String msg) {
		Date fecha;
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		while (true) {
			System.out.print(msg);
			try {
				fecha = formato.parse(leer.nextLine());
				return fecha;
			} catch (ParseException e) {
				System.out.println("Error en el formato de fecha");
			}
		}
	}

	public static java.sql.Date cASqlDate (java.util.Date uDate) {
		return new java.sql.Date(uDate.getTime());
        
    }
	
	public static int leerEntero(Scanner read, String msg) {
		int numero = 0;

		while (true) {
			System.out.print(msg);
			try {
				numero = read.nextInt();
				read.nextLine();
				return numero;
			} catch (java.util.InputMismatchException e) {
				read.nextLine();
				System.out.println(" ERROR EN FORMATO NUM�RICO!! ");
			}
		}
	}
	
	public static double leerReal(Scanner read, String msg) {
		double numero = 0;

		while (true) {
			System.out.print(msg);
			try {
				numero = read.nextDouble();
				read.nextLine();
				return numero;
			} catch (java.util.InputMismatchException e) {
				read.nextLine();
				System.out.println(" ERROR EN FORMATO NUM�RICO!! ");
			}
		}
	}
	
	public static String leerCadena(Scanner read, String msg) {
		String cadena = "";

		while (true) {
			System.out.print(msg);
			try {
				cadena = read.nextLine();
				return cadena;
			} catch (java.util.InputMismatchException e) {
				System.out.println(" ERROR EN FORMATO DE CADENA!! ");
			}
		}
	}
}

