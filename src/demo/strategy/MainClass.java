package demo.strategy;

public class MainClass {
	
	public static void main(String[] args) {
		
		Cliente chateado = new ClienteChateado();
		Cliente menosChateado = new ClienteLevementeChateado();
		
		chateado.realizarAcao();
		menosChateado.realizarAcao();
	}

}
