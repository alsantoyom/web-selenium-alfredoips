package com.java;

public class Ejercicio4 {

	public static void main(String[] args) 
	{
		// Ejercicio #4
		
		/*
		 * Crear un metodo que imprima la multiplicacion de 3 numeros.
		 *  - Metodo tipo void
		 */
	
		int multTotal = multiplicacion(1,2,3);
		System.out.println(multTotal);
		
		int multTotal2 = multiplicacion(2,2,2);
		System.out.println(multTotal2);
	}
		

	// Metodo
	public static int multiplicacion(int x, int y, int z) {
		int total = x*y*z;
		return total;
	}

	
}

