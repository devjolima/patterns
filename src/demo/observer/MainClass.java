package demo.observer;

public class MainClass {
	
	public static void main(String[] args) {
		
		double deposito = 200d;
		
		ContaCorrente cc = new ContaCorrente();
		ClienteBancario cb = new ClienteBancario(cc);
		
		cc.setNovoDeposito(deposito);
	}

}
