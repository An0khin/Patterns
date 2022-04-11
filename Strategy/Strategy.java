class Strategy {
	public static void main(String[] args) {
		MallardDuck mallard = new MallardDuck();
		mallard.display();
	}
}

class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	public void display() {
		performFly();
		performQuack();
	}
}

abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}

interface FlyBehavior {
	public void fly();
}

class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying");
	}
}
class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}

interface QuackBehavior {
	public void quack();
}
class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack");
	}
}
class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<Silence>");
	}
}