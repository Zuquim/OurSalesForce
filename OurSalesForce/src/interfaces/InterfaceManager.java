package interfaces;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InterfaceManager {

	public static JMenuBar makeMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuRegistry = new JMenu("Cadastros");
		JMenuItem menuItemCompany = new JMenuItem("Empresa");
		JMenuItem menuItemSalesman = new JMenuItem("Vendedor");
		JMenuItem menuItemCustomer = new JMenuItem("Cliente");
		JMenuItem menuItemProduct = new JMenuItem("Produto");
		JMenuItem menuItemAssociateProduct = new JMenuItem("Associar Produto");

		menuRegistry.add(menuItemCompany);
		menuRegistry.add(menuItemSalesman);
		menuRegistry.add(menuItemCustomer);
		menuRegistry.add(menuItemProduct);
		menuRegistry.addSeparator();
		menuRegistry.add(menuItemAssociateProduct);

		JMenu menuAppointment = new JMenu("Agendamento");
		JMenuItem menuItemAppointment = new JMenuItem("Realizar Agendamento");

		menuAppointment.add(menuItemAppointment);

		menuBar.add(menuRegistry);
		menuBar.add(menuAppointment);
		
		return menuBar;
	}
}
