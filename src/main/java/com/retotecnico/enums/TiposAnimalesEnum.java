package com.retotecnico.enums;

public enum TiposAnimalesEnum {

	TERRESTRE, ACUATICO, VOLADOR;

	public static TiposAnimalesEnum fromString(String tipo) {
		try {
			return TiposAnimalesEnum.valueOf(tipo.toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println("Tipo desconocido: " + tipo);
			return null;
		}
	}
}
