package testesCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Produto;

public class ProdutoTest {

	@Test
	public void precoMintest() {
		Produto p = new Produto("Rosas de plástico", 5);
		assertEquals(p.getPreco(), 7.99, 0.1);
		Produto r = new Produto("Rosas de verdade", 15);
		assertEquals(r.getPreco(), 15, 0.1);
	}

}
