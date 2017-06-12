package model;

import java.util.ArrayList;

public class Vendedor extends Pessoa {
	private Empresa empresa;
	private ArrayList<Produto> produtos;

	public Vendedor(String nome, String documento) {
		super(documento, nome);
		setId();
		this.produtos = new ArrayList<Produto>();
	}

	public Vendedor(String nome, String documento, Empresa empresa) {
		super(documento, nome);
		setId();
		this.empresa = empresa;
		this.produtos = new ArrayList<Produto>();
	}

	public void adicionaProduto(Produto produto) {
		this.produtos.add(produto);
	}

	public ArrayList<Produto> getProdutos() {
		return this.produtos;
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

	public String listaProdutos() {
		if (getProdutos().isEmpty())
			return "Sem produtos!";
		else {
			String produtos = "";
			for (Produto p : getProdutos()) {
				produtos += p.toString();
			}
			return produtos;
		}
	}

	public void filiar(Empresa e) {
		this.empresa = e;
	}

	public String getAfiliacao() {
		return (this.empresa == null) ? "Autonômo" : this.empresa.toString();
	}

	@Override
	public String toString() {
		return super.toString() + "\nAfiliação: " + getAfiliacao() + "\nProdutos ofertados: " + listaProdutos();
	}

}
