package testesCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Agenda;
import model.Cliente;
import model.Vendedor;
import model.Visita;

public class AgendaTest {

	@Test
	public void Agendartest() {
		Agenda a = new Agenda();
		Vendedor t = new Vendedor("Seu Barriga", "85636956225");
		Visita v = new Visita(new Cliente("14258632669", "Seu Madruga", "495944", 12.80, t), t);
		a.realizaAgendamento(v);
		assertEquals(a.verAgenda(), v.toString());
	}

}
