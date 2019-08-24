package demo.strategy;

public class ClienteLevementeChateado extends Cliente {

	public ClienteLevementeChateado() {
		clienteStrategy = new EsculhambarLevemente();
	}
}
