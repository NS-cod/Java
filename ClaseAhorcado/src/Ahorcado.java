
public class Ahorcado {
	// variables de instancia
	private String palabraSecreta;
	private char[] letrasArriesgadas;
	private int intentos;

	// Constructor --> recibe la palabra secreta.
	public Ahorcado(String secreta) {
		this.palabraSecreta = secreta;
		this.intentos = 5;
		this.letrasArriesgadas = new char[secreta.length()];
		for (int i = 0; i < this.letrasArriesgadas.length; i++) {
			this.letrasArriesgadas[i] = '_';
		}
	}
	
	//constructor adicional --> recibe la palabra secreta y la cantidad de intentos.
	public Ahorcado(String secreta, int cantidadIntentos) {
		this.palabraSecreta = secreta;
		this.intentos = cantidadIntentos;
		this.letrasArriesgadas = new char[secreta.length()];
		for (int i = 0; i < this.letrasArriesgadas.length; i++) {
			this.letrasArriesgadas[i] = '_';
		}
	}


	// void mostrar() --> Muestra el estado del juego
	void mostrar() {
		for (int i = 0; i < this.letrasArriesgadas.length; i++) {
			System.out.print(this.letrasArriesgadas[i] + " ");
		}
		System.out.println();
		System.out.println("Intentos: " + this.intentos);
	}

	// boolean arriesgarLetra(char c) --> Verifica que la letra pertenezca a la
	// palabra, sino pertenece reduce la cantidad de intentos. Devuelve true si la
	// letra pertenece al String, false caso contrario.
	boolean arriesgarLetra(char c) {
		boolean esta = false;
		for (int i = 0; i < this.palabraSecreta.length(); i++) {
			if (this.palabraSecreta.charAt(i) == c) {
				this.letrasArriesgadas[i] = c;
				esta = true;
			}
		}
		if (!esta) {
			this.intentos--;
		}
		return esta;
	}

	// void arriesgarPalabra(String p) --> Verifica que la palabra ingresada sea
	// igual a la palabra secreta, si coinciden el jugador gana la partida, caso
	// contrario, los intentos se reducen a 0
	void arriesgarPalabra(String p) {
		if (p.equals(this.palabraSecreta)) {
			for (int i = 0; i < this.palabraSecreta.length(); i++) {
				this.letrasArriesgadas[i] = this.palabraSecreta.charAt(i);
			}
		} else {
			this.intentos = 0;
		}
	}

	//boolean ganado() --> Verifica si el jugador, gana la partida.
	boolean ganado() {
		for (int i = 0; i < this.letrasArriesgadas.length; i++) {
			if (this.letrasArriesgadas[i] == '_') {
				return false;
			}
		}
		return true;
	}

	//boolean termino() --> Verifica si la partida terminó.
	boolean termino() {
		return this.ganado() || this.intentos == 0;
	}
}