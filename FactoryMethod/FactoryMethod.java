class FactoryMethod {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		System.out.println(nyStore.orderPizza("pepperoni"));

		System.out.println(chicagoStore.orderPizza("cheese"));
	}
}

abstract class PizzaStore {
	public abstract Pizza createPizza(String type);
	public abstract Pizza orderPizza(String type);
}

class NYPizzaStore extends PizzaStore {
	public Pizza createPizza(String type) { //factory method
		Pizza pizza = null;

		if(type.equals("cheese")) {
			pizza = new NYCheesePizza();
		} else if(type.equals("pepperoni")) {
			pizza = new NYPepperoniPizza();
		}

		return pizza;
	}
	public Pizza orderPizza(String type) {
		Pizza pizza;

		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

class ChicagoPizzaStore extends PizzaStore {
	public Pizza createPizza(String type) { //factory method
		Pizza pizza = null;

		if(type.equals("cheese")) {
			pizza = new ChicagoCheesePizza();
		} else if(type.equals("pepperoni")) {
			pizza = new ChicagoPepperoniPizza();
		}

		return pizza;
	}
	public Pizza orderPizza(String type) {
		Pizza pizza;

		pizza = createPizza(type);

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

class NYCheesePizza extends Pizza {

}
class NYPepperoniPizza extends Pizza {

}

class ChicagoCheesePizza extends Pizza {

}
class ChicagoPepperoniPizza extends Pizza {

}