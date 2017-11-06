package interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Company;

@SuppressWarnings("serial")
public class PanelRegisterCompany extends JPanel {
	public PanelRegisterCompany(ArrayList<Company> companies) {
		setLayout(new GridLayout(2, 2));
		JButton buttonRegisterCompany = new JButton("Cadastrar Empresa");
		JTextField fieldName = new JTextField();

		add(new JLabel("Nome: "));
		add(fieldName);
		add(buttonRegisterCompany);

		buttonRegisterCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Company company;
				String name = fieldName.getText();
				company = new Company(name);
				System.out.println("Código da empresa: " + company.getId());
				companies.add(company);
				JOptionPane.showMessageDialog(null,
						"Empresa cadastrado com sucesso!");
				fieldName.setText("");
			}
		});
	}
}
