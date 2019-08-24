package demo.strategy;

public class ClienteChateado extends Cliente {
	
	public ClienteChateado() {
		clienteStrategy = new EsculhambarForte();
	}

}
