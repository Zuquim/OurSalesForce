package model;

import java.util.ArrayList;

public class Empresa {
	private static int instancias = 0;
	private int id;
	private String nome;
	private ArrayList<Vendedor> vendedores;

	public Empresa(String nome) {
		id = instancias;
		Empresa.instancias++;
		this.nome = nome;
		this.vendedores = new ArrayList<Vendedor>();
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}

	public void contratar(Vendedor v) {
		getVendedores().add(v);
	}

	@Override
	public String toString() {
		return "Empresa: " + nome;
	}

}
