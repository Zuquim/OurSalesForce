package model;

public class Produto {
	private int id;
	private String nome;
	private double preco;

	private static final double precoMin = 7.99;
	private static int instancias = 0;
	// @toDo: implementar um tipo de produto (usando Enum) depois de saber sobre
	// o que se trata o sales force

	public Produto(String nome, double preco) {
		id = instancias;
		instancias++;
		setNome(nome);
		setPreco(preco);
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		preco = (preco < getPrecoMin()) ? getPrecoMin() : preco;
		this.preco = preco;
	}

	public static double getPrecoMin() {
		return precoMin;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nNome: " + nome + " Preço: " + preco + "\n";
	}
}
