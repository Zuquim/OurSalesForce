package model;

import java.util.ArrayList;
import java.util.Date;

public class Agenda {
	private Date data;
	private ArrayList<Visita> visitas;

	public Agenda() {
		visitas = new ArrayList<Visita>();
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void realizaAgendamento(Vendedor vendedor, Cliente cliente) {
		realizaAgendamento(new Visita(cliente, vendedor));
	}

	public void realizaAgendamento(Visita v) {
		visitas.add(v);
	}

	public String verAgenda() {
		String agenda = "";
		for (Visita v : visitas) {
			agenda += v.toString();
		}
		return agenda;
	}

}
