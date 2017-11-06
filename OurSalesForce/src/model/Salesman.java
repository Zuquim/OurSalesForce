package model;

import java.util.ArrayList;

public class Salesman extends Person {
	private Company company;
	private ArrayList<Product> products;

	public Salesman(String name, String documento) {
		super(documento, name);
		setId();
		this.products = new ArrayList<Product>();
	}

	public Salesman(String name, String documento, Company company) {
		super(documento, name);
		setId();
		this.company = company;
		this.products = new ArrayList<Product>();
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public ArrayList<Product> getProducts() {
		return this.products;
	}

	public boolean sell(Product product) {
		boolean isValidProduct = false;
		for (Product currentProduct : products) {
			if (product.getId() == currentProduct.getId()) {
				isValidProduct = true;
			}
		}
		return isValidProduct;
	}

	public String listProducts() {
		if (getProducts().isEmpty())
			return "Sem produtos!";
		else {
			String products = "";
			for (Product p : getProducts()) {
				products += p.toString();
			}
			return products;
		}
	}

	public void filiate(Company e) {
		this.company = e;
	}

	public String getFiliation() {
		return (this.company == null) ? "Autônomo" : this.company.toString();
	}

	@Override
	public String toString() {
		return super.toString() + "\nAfiliação: " + getFiliation() +
				"\nProdutos ofertados: " + listProducts();
	}

}
