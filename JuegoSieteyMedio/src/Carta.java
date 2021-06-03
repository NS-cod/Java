
public class Carta {
	//varibles de instancia
	private int numero;
	private int palo; //1a4
	
	Carta(int p,int n){
		this.numero=n;
		this.palo=p;
	}
	
	public void mostrar(){
		String[] palos = {"oro", "copa", "basto", "espada"};
		System.out.println("C "+ this.numero + " de "+ palos[this.palo-1]);
	}
	
	public int getNumero() {
		return this.numero;
	}
}
