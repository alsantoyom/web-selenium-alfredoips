package com.java;

public class Motos {

	// Ejercicio# 5
	
	/*
	 * Crear una clase que se llame Motos y vamos a crear 3 diferentes tipos de motos con estados y comportamientos.
	 */
	
	public int llantas;
	public int asientos;
	public String motor;
	public boolean ac;
	public String marca;
	public String modelo;

	public Motos(int llantas, int asientos, String motor, String marca, String modelo) {
		this.llantas = llantas;
		this.asientos = asientos;
		this.motor = motor;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public void acelerar() {
		System.out.println("La motocicleta esta acelerando");
	}
	
	
	public void frenar() {
		System.out.println("La motocicleta esta frenando");
	}
	
	public void encendido() {
		System.out.println("La motocicleta esta encendida");
	}
}