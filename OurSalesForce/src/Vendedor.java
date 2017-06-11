import java.util.ArrayList;

public class Vendedor extends Pessoa {
	private static int id = 0;
	private ArrayList<Produto> produtos;
	
	public Vendedor() {
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
}