package demo.factorymethod;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(String tipo) {
		this.tipoPessoa = tipo;
		System.out.println("Sou uma pessoa com CPF: "+ tipoPessoa);
	}
}
