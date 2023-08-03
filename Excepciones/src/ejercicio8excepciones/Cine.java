package ejercicio8excepciones;

import java.util.Random;

import ejercicio8excepciones.espectadores.Espectador;
import ejercicio8excepciones.peliculas.Pelicula;

public class Cine {
	private Pelicula pelicula;
	private double precioEntrada;
	private Sala sala;
	
	public Cine(double precioEntrada, Pelicula pelicula) {
		super();
		this.precioEntrada = precioEntrada;
		this.pelicula = pelicula;
		sala = new Sala();
	}
	
	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
	
	public void cobrarEntrada(Espectador espectador) {
		if (espectador.getDinero() < precioEntrada) {
			System.out.printf("El espectador %s no tiene sufiente dinero.%n", espectador.getNombre());
			return;
		}
		if (espectador.getEdad() < pelicula.getEdadMinima()) {
			System.out.printf("El espectador %s no tiene edad sufiente.%n", espectador.getNombre());
			return;
		}
		if (!sala.hayAsientoLibre()) {
			System.out.println("La sala esta llena.");
			return;
		}
		sala.colocarEspectador(dameFila(), dameColumna());
	}
	
	private int dameFila() {
		Random r = new Random();
		return r.nextInt(8) + 1;
	}
	private char dameColumna() {
		Random r = new Random();
		return (char)(r.nextInt(8) + 65); // 65 es A 
	}
	
}
