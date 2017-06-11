package model;

public class Produto {
	private static int id = 0;
	private String nome;
	// @toDo: implementar um tipo de produto (usando Enum) depois de saber sobre o que se trata o sales force
	
	public Produto(String nome) {
		id++;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	
}
