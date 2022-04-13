class AdapterRealization {
	public static void main(String[] args) {
		PenImpl pen = new PenImpl();
		pen.open();
		pen.write();

		AdapterPen adapter = new AdapterPen(new Pencil());
		adapter.open();
		adapter.write();
	}
}

interface Pen {
	void open();
	void write();
}

class PenImpl implements Pen{
	public void open() {
		System.out.println("Pen is opened");
	}
	public void write() {
		System.out.println("Pen is writing");
	}
}

class Pencil {
	public void cut() {
		System.out.println("Pencil is cutted");
	}
	public void write() {
		System.out.println("Pencil is writing");
	}
}

class AdapterPen implements Pen {
	Pencil pencil;

	AdapterPen(Pencil pencil) {
		this.pencil = pencil;
	}

	public void open() {
		pencil.cut();
	}
	public void write() {
		pencil.write();
	}
}
