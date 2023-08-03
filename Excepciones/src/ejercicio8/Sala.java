package ejercicio8;

public class Sala {
	private static final int CANTIDAD_FILAS = 8;
	private static final int CANTIDAD_COLUMNAS = 9;
	private static final char LETRA_PRIMERA_COLUMNA = 'A';
	private static final boolean LIBRE = false;
	private static final boolean OCUPADO = true;

	private boolean[][] asientos = new boolean[CANTIDAD_FILAS][CANTIDAD_COLUMNAS];

	public Sala() {
		super();
	}

	private boolean getAsiento(int fila, char columna) {
		return asientos[getIndiceFila(fila)][getIndiceColumna(columna)];
	}

	private boolean getAsiento(int fila, int columna) {
		return asientos[fila][columna];
	}

	private void setAsiento(int fila, char columna, boolean value) {
		asientos[getIndiceFila(fila)][getIndiceColumna(columna)] = value;
	}

	private void setAsiento(int fila, int columna, boolean value) {
		asientos[fila][columna] = value;
	}

	public void colocarEspectador(int fila, char columna) {
		if (estaLibre(fila, columna)) {
			setAsiento(fila, columna, true);
		} else {
			asignarSiguienteAsientoLibre(fila, columna);
		}
	}

	private void asignarSiguienteAsientoLibre(int fila, char columna) {
		int initFila = getIndiceFila(fila);
		int initCol = getIndiceColumna(columna);

		int f = initFila;
		int c = initCol + 1;
		if (c >= CANTIDAD_COLUMNAS) {

			c = 0;
			f++;
		}
		boolean colocado = false;
		while (!colocado && !(initFila == f && initCol == c)) {
			while (!colocado && c < CANTIDAD_COLUMNAS) {
				if (estaLibre(f, c)) {
					setAsiento(f, c, true);
					colocado = true;
				}
				c++;
			}
			f++;
			c = 0;
			if (f >= CANTIDAD_FILAS) {
				f = 0;
			}
		}

	}

	public boolean estaLibre(int fila, char columna) {
		return getAsiento(fila, columna) == LIBRE;
	}

	private boolean estaLibre(int fila, int columna) {
		return getAsiento(fila, columna) == LIBRE;
	}

	public boolean hayAsientoLibre() {
		for (int fila = 0; fila < asientos.length; fila++) {
			for (int col = 0; col < asientos[fila].length; col++) {
				if (estaLibre(fila, col)) {
					return true;
				}
			}
		}
		return false;
	}

	private int getIndiceFila(int fila) {
		return CANTIDAD_FILAS - fila;
	}

	private int getIndiceColumna(char columna) {
		// columna = 'c'
		return Character.getNumericValue(Character.toUpperCase(columna))
				- Character.getNumericValue(LETRA_PRIMERA_COLUMNA);
	}
}
