package model;

import java.util.ArrayList;

public class Cliente extends Pessoa {
	private String numeroConta;
	private double saldo;
	private Vendedor vendedor;
	private ArrayList<Produto> items;

	public Cliente(String documento, String nome, String numeroConta, double saldo, Vendedor vendedor) {
		super(documento, nome);
		setId();
		setNumeroConta(numeroConta);
		setSaldo(saldo);
		setVendedor(vendedor);
		this.items = new ArrayList<>();
	}

	public Cliente(String documento, String numeroConta, Vendedor vendedor) {
		super(documento);
		setNumeroConta(numeroConta);
		setSaldo(0);
		setVendedor(vendedor);
		this.items = new ArrayList<>();
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public ArrayList<Produto> getItems() {
		return items;
	}

	public void comprar(Produto produto) {
		if (getVendedor().vender(produto)) {
			getItems().add(produto);
		}
	}

	public String produtosComprados() {
		if (getItems().isEmpty())
			return "Sem produtos!";
		else {
			String produtos = "";
			for (Produto p : getItems()) {
				produtos += p.toString() + "\n";
			}
			return produtos;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nNúmero da conta: " + getNumeroConta() + "\nVendedor: " + getVendedor().toString()
				+ "\nProdutos comprados: " + produtosComprados();
	}

}