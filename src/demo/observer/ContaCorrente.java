package demo.observer;

import java.util.Observable;

public class ContaCorrente extends Observable {
	
	private double deposito;
	
	public void setNovoDeposito(double valor) {
		this.deposito=valor;
		
		setChanged();
		notifyObservers();
	}

	public double getDeposito() {
		return deposito;
	}

}
