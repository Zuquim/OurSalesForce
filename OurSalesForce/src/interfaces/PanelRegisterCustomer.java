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
import javax.swing.JTextField;

import model.Customer;
import model.Salesman;

@SuppressWarnings("serial")
public class PanelRegisterCustomer extends JPanel {
	
	public PanelRegisterCustomer(ArrayList<Customer> customers,
			ArrayList<Salesman> salesmen) {
		setLayout(new GridLayout(5, 2));
		JComboBox<Salesman> choiceSalesmen = new JComboBox<Salesman>();
		JTextField fieldName = new JTextField();
		JTextField fieldDoc = new JTextField();
		JTextField fieldAccountNumber = new JTextField();
		JButton buttonRegisterCustomer = new JButton("Cadastrar");
		
		for (Salesman salesman : salesmen) {
			choiceSalesmen.addItem(salesman);
		}
		
		add(new JLabel("Vendedor: "));
		add(choiceSalesmen);
		add(new JLabel("Nome: "));
		add(fieldName);
		add(new JLabel("Documento: "));
		add(fieldDoc);
		add(new JLabel("Numero da conta:"));
		add(fieldAccountNumber);
		add(buttonRegisterCustomer);

		buttonRegisterCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salesman vendedor = (Salesman) choiceSalesmen.
						getSelectedItem();
				String name = fieldName.getText();
				String doc = fieldDoc.getText();
				String accountNumber = fieldAccountNumber.getText();
				customers.add(new Customer(doc, name, accountNumber, 0,
						vendedor));
				JOptionPane.showMessageDialog(null,
						"Vendedor cadastrado com sucesso!");
				fieldName.setText("");
				fieldDoc.setText("");
				fieldAccountNumber.setText("");
			}
		});
	}
	
}
