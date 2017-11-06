package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Company;
import model.Salesman;

public class TestCompany {

	@Test
	public void testHire() {
		Salesman v = new Salesman("Shulambs", "145285314-89");
		Salesman v1 = new Salesman("Ednaldo Pereira", "548261658-42");
		Company e = new Company("Shulamb's inc");
		e.hire(v);
		e.hire(v1);
		assertEquals(e.getSalesmen().size(),2);
	}
	
	@Test
	public void testCreateCompany(){
		Company e = new Company("Fell Good inc");
		Company x = new Company("Shulambs inc");
		assertEquals(e.getId(),0);
		assertEquals(x.getId(),1);
	}

}
