class StateDrive {
	public static void main(String[] args) {
		Fridge fridge = new Fridge();
		fridge.open();
		fridge.open();
		fridge.close();
		fridge.close();
		fridge.open();
		fridge.close();
	}
}

class Fridge {
	private State stateOpen;
	private State stateClose;

	private State state;

	Fridge() {
		stateOpen = new StateOpenFridge(this);
		stateClose = new StateCloseFridge(this);

		state = stateClose;
	}

	public void open() {
		state.open();
	}

	public void close() {
		state.close();
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getStateClose() {
		return stateClose;
	}

	public State getStateOpen() {
		return stateOpen;
	}
}

interface State {
	public void open();
	public void close();
}

class StateOpenFridge implements State {
	Fridge fridge;

	StateOpenFridge(Fridge fridge) {
		this.fridge = fridge;
	}

	public void open() {
		System.out.println("It's already opened");
	}

	public void close() {
		System.out.println("It's closing");
		fridge.setState(fridge.getStateClose());
	}
}

class StateCloseFridge implements State {
	Fridge fridge;

	StateCloseFridge(Fridge fridge) {
		this.fridge = fridge;
	}

	public void open() {
		System.out.println("It's opening");
		fridge.setState(fridge.getStateOpen());
	}

	public void close() {
		System.out.println("It's already closed");
	}
}