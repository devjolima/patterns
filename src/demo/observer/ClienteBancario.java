package demo.observer;

import java.util.Observable;
import java.util.Observer;

public class ClienteBancario implements Observer{

	Observable contaCorrente;
	
	double novoDeposito;
	
	public ClienteBancario(Observable contaCorrente) {
		
		this.contaCorrente = contaCorrente;
		contaCorrente.addObserver(this);
	}
	
	@Override
	public void update(Observable contaCorrenteInfSubject, Object arg) {
		
		if(contaCorrenteInfSubject instanceof ContaCorrente) {
			ContaCorrente cc = (ContaCorrente) contaCorrenteInfSubject;
			novoDeposito = cc.getDeposito();
			System.out.println("ATENÇÃO, UM NOVO DEPOSITO FOI REALIZADO NO VALOR DE: "+novoDeposito);
		}
		
	}

}
