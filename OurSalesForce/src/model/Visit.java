package model;

import java.util.Date;

public class Visit {
	private static int instances = 0;
	private int id;
	private Salesman salesman;
	private Customer customer;
	private Date date;

	public Visit(Customer customer, Salesman salesman) {
		id = instances;
		instances++;
		this.customer = customer;
		this.salesman = salesman;
		this.date = new Date();
	}

	@Override
	public String toString() {
		return "Visita [id=" + id + ", vendedor=" + salesman + ", cliente=" +
	customer + ", data=" + date + "]";
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
