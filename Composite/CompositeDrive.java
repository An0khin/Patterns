import java.util.ArrayList;

class CompositeDrive {
	public static void main(String[] args) throws Exception {
		ArrayList<Composite> array = new ArrayList<>();
		
		CompositeImpl comp = new CompositeImpl();
		comp.add(new Leaf("A1"));
		comp.add(new Leaf("A2"));
		CompositeImpl comp1 = new CompositeImpl();

		comp1.add(new Leaf("B1"));
		comp1.add(new Leaf("B2"));
		comp.add(comp1);

		comp.add(new Leaf("A3"));

		comp.print();

	}
}

interface Composite {
	void print();
	void add(Composite el) throws Exception;
}

class CompositeImpl implements Composite {
	ArrayList<Composite> list = new ArrayList<>();

	public void print() {
		for(Composite el : list) {
			el.print();
		}
	}

	public void add(Composite el) {
		list.add(el);
	}

}

class Leaf implements Composite {
	private String name;

	Leaf(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(name);
	}
	public void add(Composite el) throws Exception {
		throw new Exception();
	}
}