import java.util.Scanner;


public class JuegoAhorcado {

	public static void main(String[] args) {
		Ahorcado juego = new Ahorcado("concurso");
		juego.mostrar();
		Scanner sc = new Scanner(System.in);
		while(!juego.termino()){
			System.out.println("ingrese letra o palabra");
			String p = sc.nextLine();
			if(p.length()==1){
				juego.arriesgarLetra(p.charAt(0));
			}
			else{
				juego.arriesgarPalabra(p);
			}
			juego.mostrar();
		}
		if(juego.ganado()){
			System.out.println("GANADO!!!");
		}
		else{
			System.out.println(":(");
		}
		
	}

}











