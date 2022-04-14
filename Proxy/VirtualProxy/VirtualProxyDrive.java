
public class VirtualProxyDrive {

	public static void main(String[] args) {
		ObjectProxy proxy = new ObjectProxy();
		proxy.process();
		proxy.process();
	}

}

interface ObjectInterface {
	void process();
}

class ObjectImpl implements ObjectInterface {
	ObjectInterface proxy;
	
	public ObjectImpl() {
		creating();
	}
	
	@Override
	public void process() {
		System.out.println("Some process");
	}
	
	private void creating() {
		System.out.println("Object is creating");
	}
}

class ObjectProxy implements ObjectInterface {
	ObjectImpl obj;
		
	@Override
	public void process() {
		if(obj == null) {
			obj = new ObjectImpl();
		}
		obj.process();
	}
	
}