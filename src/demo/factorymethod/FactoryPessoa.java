package demo.factorymethod;

public class FactoryPessoa {
	
	public Pessoa getPessoa(String tipo) {
		
		if(tipo.length() <= 11) 
			return new PessoaFisica(tipo);
		
		
		if(tipo.length() > 11) 
			return new PessoaJuridica(tipo);
		
		
		return null;
		
	}

}
