package interfaces;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.Agenda;
import model.Customer;
import model.Company;
import model.Product;
import model.Salesman;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private ArrayList<Company> company = new ArrayList<Company>();
	private ArrayList<Salesman> salesmen = new ArrayList<Salesman>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private Agenda agenda = new Agenda();

	MainWindow() {
		super("OurSalesForce - B.D.G.M.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Telas de cadastro
		JPanel screens = new JPanel(new CardLayout());
		JPanel panelRegisterCompany = new PanelRegisterCompany(company);
		JPanel panelRegisterSalesman = new PanelRegisterSalesman(salesmen);
		JPanel panelRegisterCustomer = new PanelRegisterCustomer(customers,
				salesmen);
		JPanel panelRegisterProduct = new PanelRegisterProduct(products);
		JPanel panelAssociateProduct = new PanelAssociateProduct(salesmen, 
				products);
		JPanel panelScheduleAppointment = new PanelScheduleAppointment(agenda,
				customers, salesmen);

		// Adiciona as telas no card layout com o id para realizar a troca das telas em BarraTarefas
		screens.add(panelRegisterCompany, "empresa");
		screens.add(panelRegisterSalesman, "vendedor");
		screens.add(panelRegisterCustomer, "cliente");
		screens.add(panelRegisterProduct, "produto");
		screens.add(panelAssociateProduct, "associar produto");
		screens.add(panelScheduleAppointment, "realizar agendamento");

		// Barra de menu
		JMenuBar menuBar = new TaskBar(screens, salesmen);
		setJMenuBar(menuBar);

		getContentPane().add(screens);

		pack();
		setLocationRelativeTo(null);
	}
}
