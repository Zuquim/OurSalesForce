package model;

import java.util.ArrayList;
import java.util.Date;

public class Agenda {
	private Date date;
	private ArrayList<Visit> visits;

	public Agenda() {
		visits = new ArrayList<Visit>();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void scheduleAppointment(Salesman salesman, Customer customer) {
		scheduleAppointment(new Visit(customer, salesman));
	}

	public void scheduleAppointment(Visit v) {
		visits.add(v);
	}

	public String checkAgenda() {
		String agenda = "";
		for (Visit v : visits) {
			agenda += v.toString();
		}
		return agenda;
	}

}
