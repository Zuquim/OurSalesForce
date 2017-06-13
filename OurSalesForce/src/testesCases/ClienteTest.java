package testesCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Cliente;
import model.Produto;
import model.Vendedor;

public class ClienteTest {

	@Test
	public void produtosCompradostest() {
		Vendedor v = new Vendedor("Perdeneiras", "47859666600");
		Cliente c = new Cliente("52943685200", "Jô Soares", v);
		assertEquals(c.produtosComprados(),"Sem produtos!");
		Produto p = new Produto("Fritadoura elétrica 2000", 188.20);
		v.adicionaProduto(p);
		c.comprar(p);
		assertEquals(c.produtosComprados(),p.toString());
	}

}
