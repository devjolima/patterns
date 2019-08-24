package demo.strategy;

public class EsculhambarLevemente  implements ClienteStrategy{

	@Override
	public void agir() {
		System.out.println("RECLAMAR LEVEMENTE ...");
	}
}
