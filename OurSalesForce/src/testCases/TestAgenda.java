package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Agenda;
import model.Customer;
import model.Salesman;
import model.Visit;

public class TestAgenda {

	@Test
	public void testSchedule() {
		Agenda a = new Agenda();
		Salesman t = new Salesman("Seu Barriga", "85636956225");
		Visit v = new Visit(new Customer("14258632669", "Seu Madruga",
				"495944", 12.80, t), t);
		a.scheduleAppointment(v);
		assertEquals(a.checkAgenda(), v.toString());
	}

}
