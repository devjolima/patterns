package demo.singleton;

public class SingletonPattern {
	
	private static SingletonPattern uniqueInstance;
	
	private SingletonPattern() {
	}

	public static synchronized SingletonPattern getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new SingletonPattern();
		}
		return uniqueInstance;
	}
}
