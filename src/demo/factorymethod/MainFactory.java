package demo.factorymethod;

public class MainFactory {
	
	public static void main(String[] args) {
		
		FactoryPessoa fp = new FactoryPessoa();
		fp.getPessoa("14785236987");
		
		FactoryPessoa fp2 = new FactoryPessoa();
		fp2.getPessoa("26577442000199");
	}

}
