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

import model.Product;

@SuppressWarnings("serial")
public class PanelRegisterProduct extends JPanel {
	public PanelRegisterProduct(ArrayList<Product> products) {
		setLayout(new GridLayout(2, 2));
		JTextField fieldName = new JTextField();
		JButton buttonRegisterProduct = new JButton("Cadastrar Produto");

		add(new JLabel("Nome: "));
		add(fieldName);
		add(buttonRegisterProduct);

		buttonRegisterProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product;
				String productName = fieldName.getText();
				product = new Product(productName, 0);
				products.add(product);
				JOptionPane.showMessageDialog(null,
						"Produto cadastrado com sucesso!");
				fieldName.setText("");
			}
		});
	}
}
