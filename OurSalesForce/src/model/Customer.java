package model;

import java.util.ArrayList;

public class Customer extends Person {
	private String accountNumber;
	private double balance;
	private Salesman salesman;
	private ArrayList<Product> items;

	public Customer(String document, String name, String accountNumber,
double balance, Salesman salesman) {
		super(document, name);
		setId();
		setAccountNumber(accountNumber);
		setBalance(balance);
		setSalesman(salesman);
		this.items = new ArrayList<>();
	}

	public Customer(String document, String accountNumber, Salesman salesman) {
		super(document);
		setAccountNumber(accountNumber);
		setBalance(0);
		setSalesman(salesman);
		this.items = new ArrayList<>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}

	public ArrayList<Product> getItems() {
		return items;
	}

	public void buy(Product product) {
		if (getSalesman().sell(product)) {
			getItems().add(product);
		}
	}

	public String boughtProducts() {
		if (getItems().isEmpty())
			return "Sem produtos!";
		else {
			String products = "";
			for (Product p : getItems()) {
				products += p.toString();
			}
			return products;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nNúmero da conta: " + getAccountNumber() 
		+ "\nVendedor: " + getSalesman().toString()
		+ "\nProdutos comprados: " + boughtProducts();
	}

}