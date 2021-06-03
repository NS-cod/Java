import java.util.Random;

public class Mazo {
	private Carta[] cartas;
	private int siguiente;

	public Mazo() {
		// Creamos el arreglo
		this.siguiente = 0;
		this.cartas = new Carta[40];
		int j = 0;
		for (int palo = 1; palo <= 4; palo++) {
			for (int num = 1; num <= 7; num++) {
				this.cartas[j] = new Carta(palo, num);
				j++;
			}
			for (int num = 10; num <= 12; num++) {
				this.cartas[j] = new Carta(palo, num);
				j++;
			}
		}
	}

	public void mostrar() {
		for (int i = this.siguiente; i < this.cartas.length; i++) {
			this.cartas[i].mostrar();
		}
	}

	public void mezclar() {
		Random rand = new Random();
		for (int i = this.siguiente; i < this.cartas.length; i++) {
			int j = rand.nextInt(this.cartas.length - this.siguiente) + this.siguiente;
			Carta c = this.cartas[i];
			this.cartas[i] = this.cartas[j];
			this.cartas[j] = c;
		}
	}

	public Carta proxima() {
		Carta c = this.cartas[this.siguiente];
		this.cartas[this.siguiente] = null;
		this.siguiente++;
		return c;
	}
}