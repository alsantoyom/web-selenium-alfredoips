package com.java;

public class Arrays {

	public static void main(String[] args) {
		// Arreglos: 
		
		/*
		 * Unidimensional
		 * Bidimensional
		 * Multidimensional
		 */
		
		String[] diasSemana = {"L", "M", "Mi", "J", "V", "S", "D"};		
		System.out.println("El dia de hoy es "+diasSemana[3]);
		
		String[] diasSemana2 = new String[7];
		
		diasSemana2[0] = "L";
		diasSemana2[1] = "M";
		System.out.println("El dia de hoy es "+diasSemana2[1]);
		
		int[] numeros = new int[1];
		numeros[0]=23;
		System.out.println("El dia de hoy es "+numeros[0]);
		
		String[][] nombres = new String[4][4];
		nombres[0][0]= "Ricardo";
		nombres[0][1]= "Ricardo";
		nombres[1][0]= "Ricardo";
		nombres[1][1]= "Ricardo";
		nombres[2][0]= "Ricardo";
		nombres[2][1]= "Ricardo";
		System.out.println("El nombre es "+nombres[2][1]);

		// Ejercicio #3 - Crear un arreglo unidimensional (como objeto) de 4 posiciones:
		
//		1- First Name
//		2- Middle Name
//		3- Last Name
//		4- Edad
		
//		**Imprimir el arreglo concatenando sus valores
	}

}
