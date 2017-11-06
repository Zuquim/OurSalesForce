package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Product;

public class TestProduct {

	@Test
	public void testMinPrice() {
		Product p = new Product("Rosas de plástico", 5);
		assertEquals(p.getPrice(), 7.99, 0.1);
		Product r = new Product("Rosas de verdade", 15);
		assertEquals(r.getPrice(), 15, 0.1);
	}

}
