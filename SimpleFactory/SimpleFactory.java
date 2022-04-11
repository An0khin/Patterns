class SimpleFactory {
	public static void main(String[] args) {
		PizzaStore store = new PizzaStore(new SimplePizzaFactory());

		System.out.println(store.orderPizza("cheese"));
	}
}

class PizzaStore {
	SimplePizzaFactory factory;

	PizzaStore(SimplePizzaFactory fact) {
		this.factory = fact;
	}

	public Pizza orderPizza(String type) {
		Pizza pizza;

		pizza = factory.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

abstract class Pizza {
	public void prepare() {
		//
	}
	public void bake() {
		//
	}
	public void cut() {
		//
	}
	public void box() {
		//
	}
}

class CheesePizza extends Pizza {

}
class PepperoniPizza extends Pizza {

}

class SimplePizzaFactory {
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if(type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if(type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		}
		return pizza;
	}
}