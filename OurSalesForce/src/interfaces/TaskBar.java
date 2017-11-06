package interfaces;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Salesman;

@SuppressWarnings("serial")
public class TaskBar extends JMenuBar {
	
	public TaskBar(JPanel menuBar, ArrayList<Salesman> salesmen) {
		JMenu menuRegistries = new JMenu("Cadastros");
		JMenuItem menuItemCompany = new JMenuItem("Empresa");
		JMenuItem menuItemSalesman = new JMenuItem("Vendedor");
		JMenuItem menuItemCustomer = new JMenuItem("Cliente");
		JMenuItem menuItemProduct = new JMenuItem("Produto");
		JMenuItem menuItemAssociateProduct = new JMenuItem("Associar Produto");

		menuRegistries.add(menuItemCompany);
		menuRegistries.add(menuItemSalesman);
		menuRegistries.add(menuItemCustomer);
		menuRegistries.add(menuItemProduct);
		menuRegistries.addSeparator();
		menuRegistries.add(menuItemAssociateProduct);

		JMenu menuAppointment = new JMenu("Agendamento");
		JMenuItem menuItemAppointment = new JMenuItem("Realizar Agendamento");

		menuAppointment.add(menuItemAppointment);

		add(menuRegistries);
		add(menuAppointment);
		
		ActionListener handleGenericClick = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String screenName = e.getActionCommand().toLowerCase();
		        CardLayout cl = (CardLayout)(menuBar.getLayout());
		        cl.show(menuBar, screenName);
		    }
		};
		
		// Realiza o bind da troca de telas
		menuItemCompany.addActionListener(handleGenericClick);
		menuItemSalesman.addActionListener(handleGenericClick);
		menuItemCustomer.addActionListener(handleGenericClick);
		menuItemProduct.addActionListener(handleGenericClick);
		menuItemAssociateProduct.addActionListener(handleGenericClick);
		menuItemAppointment.addActionListener(handleGenericClick);
	}
}
