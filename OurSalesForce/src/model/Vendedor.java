package model;
import java.util.ArrayList;

public class Vendedor extends Pessoa {
	private static int id = 0;
	private ArrayList<Produto> produtos;
	
	public Vendedor(String nome, String documento) {
		super(documento, nome);
		id++;
		this.produtos = new ArrayList<Produto>();
	}
	
	public void adicionaProduto(Produto produto) {
		this.produtos.add(produto);
	}
	
	public ArrayList<Produto> getProdutos() {
		return this.produtos;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean vender(Produto produto) {
		boolean ehProdutoValido = false;
		for (Produto produtoAtual : produtos) {
			if (produto.getId() == produtoAtual.getId()) {
				ehProdutoValido = true;
			}
		}
		return ehProdutoValido;
	}
}
