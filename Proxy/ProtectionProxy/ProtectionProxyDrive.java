
public class ProtectionProxyDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectInterface obj1 = new ObjectImplOwner();
		
		ObjectProtectionProxy proxy = new ObjectProtectionProxy(obj1);
		obj1.setProxy(proxy);
		obj1.process();
		
		ObjectInterface obj2 = new ObjectImplNotOwner();
		
		ObjectProtectionProxy proxy1 = new ObjectProtectionProxy(obj2);
		obj2.setProxy(proxy1);
		obj2.process();
		
	}

}

interface ObjectInterface {
	boolean isOwner();
	void setProxy(ObjectProxyInterface proxy);
	void process();
}

interface ObjectProxyInterface {
	void process();
}

class ObjectImplOwner implements ObjectInterface {
	ObjectProxyInterface proxy;
	
	@Override
	public void setProxy(ObjectProxyInterface proxy) {
		// TODO Auto-generated method stub
		this.proxy = proxy;
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		proxy.process();
	}

	@Override
	public boolean isOwner() {
		// TODO Auto-generated method stub
		return true;
	}
}

class ObjectImplNotOwner implements ObjectInterface {
	ObjectProxyInterface proxy;
	
	@Override
	public void setProxy(ObjectProxyInterface proxy) {
		// TODO Auto-generated method stub
		this.proxy = proxy;
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		proxy.process();
	}

	@Override
	public boolean isOwner() {
		// TODO Auto-generated method stub
		return false;
	}
}

class ObjectProtectionProxy implements ObjectProxyInterface {
	ObjectInterface obj;
	
	public ObjectProtectionProxy(ObjectInterface obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		if(obj.isOwner()) {
			System.out.println("You're owner");
		} else {
			System.out.println("You aren't owner");
		}
	}
	
}