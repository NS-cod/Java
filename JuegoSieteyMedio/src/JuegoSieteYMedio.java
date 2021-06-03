import java.util.Scanner;

public class JuegoSieteYMedio {

	public static void main(String[] args) {
		// Creo el mazo
		Mazo m = new Mazo();
		// Creo el jugador y la banca.
		Mano jugador = new Mano();
		Mano banca = new Mano();
		m.mezclar();
		Scanner sc = new Scanner(System.in);

		// Comienza a jugar el juegador
		Carta c = m.proxima();
		System.out.println("===JUEGA EL JUGADOR===");
		jugador.recibirCarta(c);
		jugador.recibirCarta(m.proxima());
		jugador.mostrar();
		System.out.println(jugador.puntos());
		boolean sigue = true;
		while (jugador.puntos() < 7.5 && sigue) {
			System.out.println("¿Una carta mas? ¿S o N?");
			char res = sc.next().charAt(0);
			if (res == 's') {
				jugador.recibirCarta(m.proxima());
				jugador.mostrar();
				System.out.println(jugador.puntos());
			} else {
				sigue = false;
			}
			// sc.nextLine();
		}

		System.out.println("===JUEGA LA BANCA===");
		sigue = true;
		banca.recibirCarta(m.proxima());
		while (sigue) {
			if (banca.puntos() < 7.5) {
				banca.recibirCarta(m.proxima());
				banca.mostrar();
			}
			sigue = sigue && banca.puntos() < 7.5;
			System.out.println(banca.puntos());
		} //4 --> 7.5 = 7.5 - 4 = 3.5 --> 3.5
		//13 --> 7.5 = 7.5 - 13 = -5.5 --> 5.5

		double distanciaJugador = calcularDistancia7_5(jugador.puntos());
		double distanciaBanca = calcularDistancia7_5(banca.puntos());
		if(distanciaJugador == distanciaBanca) {
			System.out.println("¡¡EMPATE!!");
		}
		else {
			String ganador = distanciaJugador > distanciaBanca ? "LA BANCA" : "EL JUGADOR";
			System.out.println("EL GANADOR ES: " + ganador);
		}
	}

	static double calcularDistancia7_5(double puntos) {
		double r = 7.5 - puntos;
		return r < 0 ? r * -1 : r;
	}
}
