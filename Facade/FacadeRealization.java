class FacadeRealization {
	public static void main(String[] args) {
		PenImpl pen = new PenImpl();
		pen.open();
		pen.write();

		FacadePen adapter = new FacadePen(new Pencil(), new PencilSharpener());
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

class FacadePen implements Pen {
	PencilSharpener sharpener;
	Pencil pencil;

	FacadePen(Pencil pencil, PencilSharpener sharpener) {
		this.pencil = pencil;
		this.sharpener = sharpener;
	}

	public void open() {
		sharpener.use();
		pencil.cut();
	}
	public void write() {
		pencil.write();
	}
}

class PencilSharpener {
	public void use() {
		System.out.println("Pencil sharpener is using");
	}
}