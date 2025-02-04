package com.retotecnico.animales;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.retotecnico.beans.Acuatico;
import com.retotecnico.beans.Animal;
import com.retotecnico.beans.Terrestre;
import com.retotecnico.beans.Volador;
import com.retotecnico.enums.TiposAnimalesEnum;

public class App {

	 private static List<Animal> listaAnimales = new ArrayList<>();

	    public static void main(String[] args) {
	        if (args != null && args.length > 0) {
	            procesarArgumentos(args);
	        } else {
	            solicitarEntradaManual();
	        }

	        mostrarAnimalesAgrupados(listaAnimales);
	    }

	    private static void procesarArgumentos(String[] args) {
	        System.out.println("Procesando argumentos de línea de comandos...");

	        for (String entrada : args) {
	            agregarAnimal(entrada);
	        }
	    }

	    private static void solicitarEntradaManual() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Ingrese los datos de los animales (nombre|tipo|onomatopeya).");
	        System.out.println("Una vez registrado, ingrese 'enviar' para ver el resultado.");

	        while (true) {
	            System.out.print("Ingrese animal: ");
	            String entrada = scanner.nextLine();

	            if (entrada.equalsIgnoreCase("enviar")) {
	                break;
	            }

	            agregarAnimal(entrada);
	        }

	        scanner.close();
	    }

	    private static void agregarAnimal(String entrada) {
	        String[] partes = entrada.split("\\|");
	        if (partes.length != 3) {
	            System.out.println("Formato incorrecto. Debe ser: nombre|tipo|onomatopeya.");
	            return;
	        }

	        String nombre = partes[0];
	        TiposAnimalesEnum tipo = TiposAnimalesEnum.fromString(partes[1]);
	        String onomatopeya = partes[2];

	        switch (tipo) {
	            case TERRESTRE:
	                listaAnimales.add(new Terrestre(nombre, onomatopeya));
	                break;
	            case VOLADOR:
	                listaAnimales.add(new Volador(nombre, onomatopeya));
	                break;
	            case ACUATICO:
	                listaAnimales.add(new Acuatico(nombre, onomatopeya));
	                break;
	            default:
	                System.out.println("Tipo desconocido: " + tipo);
	        }
	    }

	    private static void mostrarAnimalesAgrupados(List<Animal> animales) {
	        Map<String, List<Animal>> agrupados = animales.stream()
	                .collect(Collectors.groupingBy(Animal::getTipo));

	        agrupados.forEach((tipo, lista) -> {
	            System.out.println("\nAnimales " + tipo + "s:");
	            lista.forEach(animal -> System.out.println("  - " + animal.getNombre() + " → " + animal.emitirSonido()));
	        });
	    }
}
