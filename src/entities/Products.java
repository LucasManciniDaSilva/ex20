package entities;

public class Products {

	private String name;
	private double value;
	
	public Products(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Products [name=" + name + ", value=" + value + "]";
	}
	
}
