package testesCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Empresa;
import model.Vendedor;

public class EmpresaTest {

	@Test
	public void contratarTest() {
		Vendedor v = new Vendedor("Shulambs", "145285314-89");
		Vendedor v1 = new Vendedor("Ednaldo Pereira", "548261658-42");
		Empresa e = new Empresa("Shulamb's inc");
		e.contratar(v);
		e.contratar(v1);
		assertEquals(e.getVendedores().size(),2);
	}
	
	@Test
	public void criarEmpresasTest(){
		Empresa e = new Empresa("Fell Good inc");
		Empresa x = new Empresa("Shulambs inc");
		assertEquals(e.getId(),0);
		assertEquals(x.getId(),1);
	}

}
