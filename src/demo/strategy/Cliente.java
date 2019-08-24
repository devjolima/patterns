package demo.strategy;

public abstract class Cliente {
	
	protected ClienteStrategy clienteStrategy;
	

	public ClienteStrategy getClienteStrategy() {
		return clienteStrategy;
	}

	public void setClienteStrategy(ClienteStrategy clienteStrategy) {
		this.clienteStrategy = clienteStrategy;
	}
	
	
	public void realizarAcao() {
		clienteStrategy.agir();
	}
	

}
