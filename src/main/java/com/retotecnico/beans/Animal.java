package com.retotecnico.beans;

public abstract class Animal {

	private String nombre;
	private String onomatopeya;

	public Animal(String nombre, String onomatopeya) {
		this.nombre = nombre;
		this.onomatopeya = onomatopeya;
	}

	public abstract String getTipo();

	public String emitirSonido() {
		return " hace: " + onomatopeya;
	}

	public String getNombre() {
		return nombre;
	}
}
