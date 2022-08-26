package com.java;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Ejercicio #3 - Crear un arreglo unidimensional (como objeto) de 4 posiciones:
		
//		1- First Name
//		2- Middle Name
//		3- Last Name
//		4- Edad
		
//		**Imprimir el arreglo concatenando sus valores
		
		String[] datosPersonales = new String[4];
		
		datosPersonales[0] = "Alfredo";
		datosPersonales[1] = "Santoyo";
		datosPersonales[2] = "Miranda";
		datosPersonales[3] = "30";
		System.out.println(datosPersonales[0]+ " " +datosPersonales[1]+ " " + datosPersonales[2]+ " " + "Tiene" + " " + datosPersonales[3] + " " + "años");

	}

}