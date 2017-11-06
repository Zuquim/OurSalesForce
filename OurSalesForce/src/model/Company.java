package model;

import java.util.ArrayList;

public class Company {
	private static int instances = 0;
	private int id;
	private String name;
	private ArrayList<Salesman> salesmen;

	public Company(String name) {
		id = instances;
		Company.instances++;
		this.name = name;
		this.salesmen = new ArrayList<Salesman>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Salesman> getSalesmen() {
		return salesmen;
	}

	public void hire(Salesman sm) {
		getSalesmen().add(sm);
	}

	@Override
	public String toString() {
		return "Empresa: " + name;
	}

}
