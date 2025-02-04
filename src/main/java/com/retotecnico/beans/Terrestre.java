package com.retotecnico.beans;

public class Terrestre extends Animal {
	
	public Terrestre(String nombre, String onomatopeya) {
		super(nombre, onomatopeya);
	}

	@Override
	public String getTipo() {
		return "Terrestre";
	}
}
