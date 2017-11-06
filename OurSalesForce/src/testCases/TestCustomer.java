package testCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Customer;
import model.Product;
import model.Salesman;

public class TestCustomer {

	@Test
	public void testBoughtProducts() {
		Salesman sm = new Salesman("Perdeneiras", "47859666600");
		Customer c = new Customer("52943685200", "Jô Soares", sm);
		assertEquals(c.boughtProducts(),"Sem produtos!");
		Product p = new Product("Fritadoura elétrica 2000", 188.20);
		sm.addProduct(p);
		c.buy(p);
		assertEquals(c.boughtProducts(),p.toString());
	}

}
