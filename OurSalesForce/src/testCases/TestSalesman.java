package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Company;
import model.Product;
import model.Salesman;

public class TestSalesman {

	@Test
	public void testBuyProducts() {
		Salesman sm = new Salesman("Shulambs", "123695258-39");
		Product p = new Product("Filme de terror trash dos anos 80", 15);
		sm.addProduct(p);
		assertEquals(sm.getProducts().size(), 1);
		assertEquals(sm.getProducts().get(0).getPrice(), 15, 0.1);
		assertEquals(sm.getProducts().get(0).getName(), 
				"Filme de terror trash dos anos 80");
	}

	@Test
	public void getProdutosTest() {
		Salesman sm = new Salesman("Cool Jesus", "8484949111-25");
		assertEquals(sm.listProducts(), "Sem produtos!");
		Product p = new Product("Bon zika demais", 40);
		sm.addProduct(p);
		assertEquals(sm.listProducts(), p.toString());
	}

	@Test
	public void venderTest() {
		Salesman sm = new Salesman("That guy over there", "8420936851-25");
		Product p = new Product("Ações da Petrobras", 9.20);
		sm.addProduct(p);
		assertEquals(sm.sell(p), true);
	}

	@Test
	public void afiliacaoTest() {
		Salesman sm = new Salesman("Marla Stinger", "7560916798-45");
		assertEquals(sm.getFiliation(), "Autônomo");
		Company e = new Company("Umbrella Corporation");
		sm.filiate(e);
		assertEquals(sm.getFiliation(), e.toString());
	}

}
