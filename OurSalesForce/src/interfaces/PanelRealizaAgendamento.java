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
import model.Cliente;
import model.Vendedor;

@SuppressWarnings("serial")
public class PanelRealizaAgendamento extends JPanel {
	public PanelRealizaAgendamento(Agenda agenda, ArrayList<Cliente> clientes, ArrayList<Vendedor> vendedores) {
		setLayout(new GridLayout(3, 2));
		JComboBox<Vendedor> choiceVendedores = new JComboBox<Vendedor>();
		JComboBox<Cliente> choiceClientes = new JComboBox<Cliente>();
		JButton butAgendamento = new JButton("Realizar Agendamento");
		
		for (Vendedor vendedor : vendedores) {
			choiceVendedores.addItem(vendedor);
		}
		
		for (Cliente cliente : clientes) {
			choiceClientes.addItem(cliente);
		}
		
		add(new JLabel("Vendedor: "));
		add(choiceVendedores);
		add(new JLabel("Cliente: "));
		add(choiceClientes);
		add(butAgendamento);
		
		butAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendedor vendedor = (Vendedor) choiceVendedores.getSelectedItem();
				Cliente cliente = (Cliente) choiceClientes.getSelectedItem();
				
				agenda.realizaAgendamento(vendedor, cliente);
				JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
			}
		});
	}
}
