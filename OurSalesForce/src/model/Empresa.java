package model;
import java.util.ArrayList;

public class Empresa {
	private static int id = 0;
	private String nome;
	private ArrayList<Vendedor> vendedores;
	
	public Empresa(String nome) {
		Empresa.id++;
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

	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
	
}
