class Singleton {

	public static void main(String[] args) {
		System.out.println(getInstance());
		System.out.println(getInstance());
	}

	private static Singleton uniqueInstance;

	private Singleton() {}

	public static Singleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}

class SingletonSync { //with synchronized
	private static SingletonSync uniqueInstance;

	private SingletonSync() {}

	public static synchronized SingletonSync getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new SingletonSync();
		}
		return uniqueInstance;
	}
}

class SingletonMultiThr {
	private static SingletonMultiThr uniqueInstance = new SingletonMultiThr();

	private SingletonMultiThr() {}

	public static SingletonMultiThr getInstance() {
		return uniqueInstance;
	}
}

class SingletonVol {
	private volatile static SingletonVol uniqueInstance;

	private SingletonVol() {}

	public static SingletonVol getInstance() {
		if(uniqueInstance == null) {
			synchronized (SingletonVol.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new SingletonVol();
				}
			}
		}
		return uniqueInstance;
	}
}