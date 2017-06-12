package testesCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Empresa;
import model.Produto;
import model.Vendedor;

public class VendedorTest {

	@Test
	public void comprarProdutosTest() {
		Vendedor v = new Vendedor("Shulambs", "123695258-39");
		Produto p = new Produto("Filme de terror trash dos anos 80", 15);
		v.adicionaProduto(p);
		assertEquals(v.getProdutos().size(), 1);
		assertEquals(v.getProdutos().get(0).getPreco(), 15, 0.1);
		assertEquals(v.getProdutos().get(0).getNome(), "Filme de terror trash dos anos 80");
	}

	@Test
	public void getProdutosTest() {
		Vendedor v = new Vendedor("Cool Jesus", "8484949111-25");
		assertEquals(v.listaProdutos(), "Sem produtos!");
		Produto p = new Produto("Boné zika demais", 40);
		v.adicionaProduto(p);
		assertEquals(v.listaProdutos(), p.toString());
	}

	@Test
	public void venderTest() {
		Vendedor v = new Vendedor("That guy over there", "8420936851-25");
		Produto p = new Produto("Ações da Petrobras", 9.20);
		v.adicionaProduto(p);
		assertEquals(v.vender(p), true);
	}

	@Test
	public void afiliacaoTest() {
		Vendedor v = new Vendedor("Marla Stinger", "7560916798-45");
		assertEquals(v.getAfiliacao(), "Autonômo");
		Empresa e = new Empresa("Umbrella Corporation");
		v.filiar(e);
		assertEquals(v.getAfiliacao(), e.toString());
	}

}
