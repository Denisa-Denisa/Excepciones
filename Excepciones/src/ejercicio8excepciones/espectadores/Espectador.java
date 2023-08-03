package ejercicio8excepciones.espectadores;

public class Espectador {
	private String nombre;
	private int edad;
	private double dinero;

	public Espectador(String nombre, int edad, double dinero) throws EspectadorException {
		// NombreEspectadorException, EdadEspectadorException, DineroEspectadorException
		// {
		super();

		this.setNombre(nombre);
		this.setEdad(edad);
		this.setDinero(dinero);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreEspectadorException {
		if (nombre.equals(""))
			throw new NombreEspectadorException("El nombre no puede ser vacio.");
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws EdadEspectadorException {
		if (edad < 0)
			throw new EdadEspectadorException("La edad es incorrecta. Debe ser mayor de 0.");
		this.edad = edad;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) throws DineroEspectadorException {
		if (dinero < 0)
			throw new DineroEspectadorException("El dinero no puede ser negativo");
		this.dinero = dinero;
	}

}
