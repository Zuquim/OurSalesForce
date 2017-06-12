package model;

import java.util.Date;

public class Visita {
	private static int instancias = 0;
	private int id;
	private Vendedor vendedor;
	private Cliente cliente;
	private Date data;

	public Visita(Cliente cliente, Vendedor vendedor) {
		id = instancias;
		instancias++;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.data = new Date();
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
