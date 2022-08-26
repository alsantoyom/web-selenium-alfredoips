package com.java;

public class Main {

	// Ejercicio# 5
	
	/*
	 * Crear una clase que se llame Motos y vamos a crear 3 diferentes tipos de motos con estados y comportamientos.
	 */
	
	public static void main(String[] args) {

		Motos Moto1 = new Motos(2, 1, "Gasolina", "Italika", "2020");
		System.out.println("Mi motocicleta tiene un motor de: "+ Moto1.motor);
		Moto1.encendido();
		
		Motos Moto2 = new Motos(2, 1, "Gasolina", "BMW", "2021");
		System.out.println("Mi motocicleta es de la marca: "+ Moto2.marca);
		Moto2.frenar();
		
		Motos Moto3 = new Motos(2, 1, "Gasolina", "Ducati", "2022");
		System.out.println("Mi motocicleta cuenta con: "+ Moto3.asientos + " asiento");
		Moto3.acelerar();
	}

}
