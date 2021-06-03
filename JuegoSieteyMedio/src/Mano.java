
public class Mano {
	private Carta[] cartas;
	private int primerPosNula;

	//Constructor
	public Mano() {
		this.cartas = new Carta[14];
		this.primerPosNula = 0;
	}

	//Se agrega la carta recibida y se la agrega al arreglo de cartas de la mano.
	void recibirCarta(Carta c) {
		this.cartas[this.primerPosNula] = c;
		this.primerPosNula++;
	}

	//Si la carta es menor a 10, se devuelve el valor de la carta, en caso contrario se devuelve 0.5.
	double puntos() {
		double p = 0;
		for (int i = 0; i < this.primerPosNula; i++) {
			if (this.cartas[i].getNumero() >= 10 && this.cartas[i].getNumero() <= 12) {
				p = p + 0.5;
			} else {
				p = p + this.cartas[i].getNumero();
			}
		}
		return p;
	}

	public void mostrar() {
		for (int i = 0; i < this.primerPosNula; i++) {
			this.cartas[i].mostrar();
		}
	}
}
