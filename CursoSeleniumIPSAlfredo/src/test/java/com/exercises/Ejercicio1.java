package com.exercises;

public class Ejercicio1 {

	public static void main(String[] args) {

		/*
		 * Ejercicio #1
		 * 
		 * 1- Cambiar el tipo de variable de int a double.
		 * 2- Agregar la condicion cuando sea "Zona escolar"
		 */
		
		double velocidad = 30.50;
		double limiteVelocidad = 80.50; //Avenida
		boolean isCarretera = false;
		boolean isZonaEscolar = true;
		
		if(isCarretera==true) {
			limiteVelocidad = 100.50; //Carretera
			
			if(velocidad>limiteVelocidad) {
				// Block code
				System.out.println("Carretera - Multa");
			}else {
				System.out.println("Carretera - Manejas bien!!");
			}
			
		}
		
		else if(isZonaEscolar==true) {
			limiteVelocidad = 20.00; //Zona Escolar
			
			if(velocidad>limiteVelocidad) {
				// Block code
				System.out.println("ZonaEscolar - Multa");
			}else {
				System.out.println("ZonaEscolar - Manejas bien!!");
			}
			
		}
		
		else if(velocidad>limiteVelocidad) {
			// Block code
			System.out.println("Calle - Multa");
		}else {
			System.out.println("Calle - Manejas bien!!");
		}		

	}

}