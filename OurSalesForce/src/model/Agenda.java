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
		visitas.add(new Visita(cliente, vendedor));
	}
	
}
