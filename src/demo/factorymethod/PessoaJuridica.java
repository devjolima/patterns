package demo.factorymethod;

public class PessoaJuridica extends Pessoa{
	
	public PessoaJuridica(String tipo) {
		this.tipoPessoa = tipo;
		System.out.println("Sou um CNPJ : "+tipo);
	}

}
