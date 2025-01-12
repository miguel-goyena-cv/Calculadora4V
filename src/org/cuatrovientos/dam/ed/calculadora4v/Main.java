package org.cuatrovientos.dam.ed.calculadora4v;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 1.- Variables necesarias para la calculadora
		Scanner scanner = new Scanner(System.in);
		double resultado = Double.NaN; // Inicializo a NaN y así se se he podido realizar la operación.
		
		
		// 2.- Presento una entrada al programa
		mostrarInstrucciones();
		
		
		// 3.- Pido los operandos
		System.out.print("Dime el operando 1: ");
		double operando1 = scanner.nextDouble();
		System.out.print("Dime el operando 2: ");
		double operando2 = scanner.nextDouble();
		
		
		// 4.- Pido la operacion a realizar
		mostrarMenuOperando();
		int operando = scanner.nextInt();
		
		
		// 5.- Evaluo la operacion y la realizo
		switch (operando) {
			case 1:
				resultado = suma(operando1, operando2);
				break;
			case 2:
				resultado = resta(operando1, operando2);
				break;
			case 3:
				resultado = multiplicacion(operando1, operando2);
				break;
			case 4:
				resultado = division(operando1, operando2);
				break;
			default:
				System.err.println("Operación inválida, elige de 1-4");
				break;
		}
		
		
		// 6- Presento el resultado
		if (resultado == Double.NaN) // FIXME (BUG, porque eso siempre da false debido a especificación IEEE 754)
										// Utilizar siempre Double.isNaN
			System.err.println("No he podido obtener un resultado valido");
		else
			System.out.println("Enhorabuena!!! Tu resultado es: " + resultado);
		
		
		// 7- Cierro el scanner
		scanner.close();
	}

	private static void mostrarInstrucciones() {
		System.out.println("==========================");
		System.out.println("Calculadora 4V");
		System.out.println("Dime 2 operandos y una operación a realizar y yo te sacaré el resultado");
		System.out.println("==========================");
	}

	private static void mostrarMenuOperando() {
		System.out.println("Operaciones disponibles: ");
		System.out.println("\t1.- Suma ");
		System.out.println("\t2.- Resta ");
		System.out.println("\t3.- Multiplicación ");
		System.out.println("\t4.- División ");
		System.out.print("Que operación quieres realizar: ");
	}

	/**
	 * Hace una division entre 2 numeros,no dejando dividir entre 0
	 * 
	 * @param operando1
	 * @param operando2
	 * @return NaN si no se puede dividir y sino el resultado
	 */
	private static double division(double operando1, double operando2) {

		// No se puede dividir por 0
		if (operando2 == 0) {
			System.err.println("No podemos dividor por 0!!!!");
			return Double.NaN;
		}

		return operando1 / operando2;

	}

	/**
	 * Hace una multiplicación de 2 numeros double
	 * 
	 * @param operando1
	 * @param operando2
	 * @return Resultado de la operacion
	 */
	private static double multiplicacion(double operando1, double operando2) {

		return operando1 * operando2;

	}

	/**
	 * Hace una resta de 2 numeros double
	 * 
	 * @param operando1
	 * @param operando2
	 * @return Resultado de la operacion
	 */
	private static double resta(double operando1, double operando2) {

		return operando1 - operando2;

	}

	/**
	 * Hace una suma de 2 numeros double
	 * 
	 * @param operando1
	 * @param operando2
	 * @return Resultado de la operacion
	 */
	private static double suma(double operando1, double operando2) {
		
		//TODO Comprobar limites de double en la operacion de suma
		return operando1 + operando2;

	}

}
