package interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Agenda;
import model.Customer;
import model.Salesman;

@SuppressWarnings("serial")
public class PanelScheduleAppointment extends JPanel {
	public PanelScheduleAppointment(Agenda agenda, ArrayList<Customer>
	customers, ArrayList<Salesman> salesmen) {
		setLayout(new GridLayout(3, 2));
		JComboBox<Salesman> choiceSalesmen = new JComboBox<Salesman>();
		JComboBox<Customer> choiceCustomers = new JComboBox<Customer>();
		JButton buttonAppointment = new JButton("Realizar Agendamento");
		
		for (Salesman salesman : salesmen) {
			choiceSalesmen.addItem(salesman);
		}
		
		for (Customer customer : customers) {
			choiceCustomers.addItem(customer);
		}
		
		add(new JLabel("Vendedor: "));
		add(choiceSalesmen);
		add(new JLabel("Cliente: "));
		add(choiceCustomers);
		add(buttonAppointment);
		
		buttonAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salesman salesman = (Salesman) choiceSalesmen.
						getSelectedItem();
				Customer customer = (Customer) choiceCustomers.
						getSelectedItem();
				
				agenda.scheduleAppointment(salesman, customer);
				JOptionPane.showMessageDialog(null,
						"Agendamento realizado com sucesso!");
			}
		});
	}
}
