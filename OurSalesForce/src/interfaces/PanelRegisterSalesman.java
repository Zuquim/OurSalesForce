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

import model.Salesman;

@SuppressWarnings("serial")
public class PanelRegisterSalesman extends JPanel {
	public PanelRegisterSalesman(ArrayList<Salesman> salesmen) {
		setLayout(new GridLayout(3, 3));
		JTextField fieldName = new JTextField();
		JTextField fieldDoc = new JTextField();
		JButton buttonRegisterSalesman = new JButton("Cadastrar");

		add(new JLabel("Nome: "));
		add(fieldName);
		add(new JLabel("Documento: "));
		add(fieldDoc);
		add(buttonRegisterSalesman);

		buttonRegisterSalesman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salesman salesman;
				String name = fieldName.getText();
				String doc = fieldDoc.getText();
				salesman = new Salesman(name, doc);
				salesmen.add(salesman);
				System.out.println("Codigo do vendedor: " + salesman.getId());
				JOptionPane.showMessageDialog(null, 
						"Vendedor cadastrado com sucesso!");
				fieldName.setText("");
				fieldDoc.setText("");
			}
		});
	}
}
