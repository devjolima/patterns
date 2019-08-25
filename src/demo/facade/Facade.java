package demo.facade;

public class Facade {
	
	private AbrirConexao abrirConexao;
	
	private FecharConexao fecharConexao;
	
	private UsandoConexao usandoConexao;

	public Facade() {
		this.abrirConexao = new AbrirConexao();
		this.fecharConexao = new FecharConexao();
		this.usandoConexao = new UsandoConexao();
	}
	
	public void executarFacade() {
		abrirConexao.realizarAberturaConexao();
		usandoConexao.metodoFuncional();
		fecharConexao.encerrandoConexaoAberta();
	}

}
