package ejercicio8;

import java.util.Random;

public class Ejercicio8 {
	/*
	 * Nos piden hacer un programa orientado a objetos sobre un cine (solo de una
	 * sala) tiene un conjunto de asientos (8 filas por 9 columnas, por ejemplo).
	 * Del cine nos interesa conocer: - la pel�cula que se est� reproduciendo y - el
	 * precio de la entrada en el cine. De las pel�culas nos interesa saber: - el
	 * t�tulo, - duraci�n, - edad m�nima y - director. Del espectador, nos interesa
	 * saber su: - nombre, - edad y - el dinero que tiene. Los asientos son
	 * etiquetados por una letra (columna) y un n�mero (fila), la fila 1 empieza al
	 * final de la matriz como se muestra en la tabla. Tambi�n deberemos saber si
	 * est� ocupado o no el asiento. 8 A 8 B 8 C 8 D 8 E 8 F 8 G 8 H 8 I 7 A 7 B 7 C
	 * 7 D 7 E 7 F 7 G 7 H 7 I 6 A 6 B 6 C 6 D 6 E 6 F 6 G 6 H 6 I 5 A 5 B 5 C 5 D 5
	 * E 5 F 5 G 5 H 5 I 4 A 4 B 4 C 4 D 4 E 4 F 4 G 4 H 4 I 3 A 3 B 3 C 3 D 3 E 3 F
	 * 3 G 3 H 3 I 2 A 2 B 2 C 2 D 2 E 2 F 2 G 2 H 2 I 1 A 1 B 1 C 1 D 1 E 1 F 1 G 1
	 * H 1 I Realizaremos una peque�a simulaci�n, en el que generaremos muchos
	 * espectadores y los sentaremos aleatoriamente (no podemos donde ya este
	 * ocupado). En esta versi�n sentaremos a los espectadores de uno en uno. Solo
	 * se podr� sentar si tienen el suficiente dinero, hay espacio libre y tiene
	 * edad para ver la pel�cula, en caso de que el asiento este ocupado le buscamos
	 * uno libre. Los datos del espectador y la pel�cula pueden ser totalmente
	 * aleatorios.
	 */
	public static void main(String[] args) {
		int CANTIDAD_ESPECTADORES = 100;

		Pelicula pelicula = generarPelicula();
		double precio = dameAleatorio(0, 20);
		Cine cine = new Cine(precio, pelicula);

		for (int i = 1; i < CANTIDAD_ESPECTADORES; i++) {
			System.out.println(i);
			cine.cobrarEntrada(generarEspectador());
		}
	}

	public static Pelicula generarPelicula() {
		String[] titulos = { "Terminator", "Depredador", "La guerra de las Galaxias", "E.T.", "Spider-Man",
				"El padrino", "Encuentros en la tercera fase" };
		String[] directores = { "Spielberg", "Felini", "Hitchkock", "Pepito", "Salaniendro", "Federico", "Mengano" };
		int[] edades = { 0, 8, 13, 16, 18 };
		String titulo = titulos[dameAleatorio(0, titulos.length)];
		String director = directores[dameAleatorio(0, directores.length)];
		int edadMinima = edades[dameAleatorio(0, edades.length)];
		int duracion = dameAleatorio(70, 250);
		return new Pelicula(titulo, duracion, edadMinima, director);
	}

	public static Espectador generarEspectador() {
		String[] nombres = { "Federico", "Felix", "Ana", "Monica", "Alejandro", "Rosa", "Juan", "Jos�", "Azucena",
				"Oscar", "Alejandra", "Felisa" };
		String[] apellidos = { "Garcia", "Alonso", "Santaolla", "Casas", "Manzano", "Olivo", "Fernandez", "Gutierrez" };
		String nombre = nombres[dameAleatorio(0, nombres.length - 1)] + " "
				+ apellidos[dameAleatorio(0, apellidos.length - 1)];
		int edad = dameAleatorio(0, 99);
		double dinero = dameAleatorio(0, 100);
		return new Espectador(nombre, edad, dinero);
	}

	public static int dameAleatorio(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
}
