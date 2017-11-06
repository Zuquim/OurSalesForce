package model;

public class Product {
	private int id;
	private String name;
	private double price;

	private static final double minPrice = 7.99;
	private static int instances = 0;
	// @toDo: implementar um tipo de produto (usando Enum) depois de saber sobre
	// o que se trata o sales force

	public Product(String name, double price) {
		id = instances;
		instances++;
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		price = (price < getMinPrice()) ? getMinPrice() : price;
		this.price = price;
	}

	public static double getMinPrice() {
		return minPrice;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nNome: " + name + " Preço: " + price + "\n";
	}
}
