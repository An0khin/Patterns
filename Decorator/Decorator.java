class Decorator {
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		beverage.display();

		Beverage beverage2 = new Espresso();
		beverage2 = new Mocha(beverage2);
		beverage2.display();
	}
}

abstract class Beverage {
	String description = "Unknown beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();

	public void display() {
		System.out.println(getDescription() + " $" + cost());
	}
}

abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}

class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}

	public double cost() {
		return 1.99;
	}
}

class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	public double cost() {
		return 0.89;
	}
}

class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return 0.2 + beverage.cost();
	}
}