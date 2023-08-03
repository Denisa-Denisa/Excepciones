package ejercicio8excepciones.peliculas;

public class Pelicula {
	private String titulo;
	private int duracionMinutos;
	private int edadMinima;
	private String director;

	public Pelicula(String titulo, int duracionMinutos, int edadMinima, String director) throws TituloPeliculaException,
			DuracionPeliculaException, EdadMinimaPeliculaException, DirectorPeliculaException {
		super();
		this.setTitulo(titulo);
		this.setDuracionMinutos(duracionMinutos);
		this.setEdadMinima(edadMinima);
		this.setDirector(director);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws TituloPeliculaException {
		if (titulo.isEmpty())
			throw new TituloPeliculaException("El titulo de la pelicula no puede ser vacio.");
		this.titulo = titulo;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) throws DuracionPeliculaException {
		if (duracionMinutos < 70)
			throw new DuracionPeliculaException("La duracion de la pelicula no puede ser inferior de 70 minutos.");
		this.duracionMinutos = duracionMinutos;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) throws EdadMinimaPeliculaException {
		if (edadMinima < 0 || edadMinima > 18)
			throw new EdadMinimaPeliculaException("La edad minima debe estar entre 0 y 18 años.");
		this.edadMinima = edadMinima;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) throws DirectorPeliculaException {
		if (director.isEmpty())
			throw new DirectorPeliculaException("El director no puede estar vacio.");
		this.director = director;
	}

}
