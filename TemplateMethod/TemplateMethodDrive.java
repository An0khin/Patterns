class TemplateMethodDrive {
	public static void main(String[] args) {
		ElectroCar electro = new ElectroCar();
		electro.dailyAction();

		UsualCar car = new UsualCar();
		car.dailyAction();
	}
}

abstract class Car {
	final void dailyAction() { //template method
		drive();
		refuel();
	}

	void drive() {
		System.out.println("You are driving the car");
	}
	abstract void refuel();
}

class ElectroCar extends Car {
	void refuel() {
		System.out.println("Your electrocar is recharging");
	}
}

class UsualCar extends Car {
	void refuel() {
		System.out.println("Your car is refueling");
	}
}