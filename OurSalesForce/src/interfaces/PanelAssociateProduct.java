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

import model.Product;
import model.Salesman;

@SuppressWarnings("serial")
public class PanelAssociateProduct extends JPanel {
	public PanelAssociateProduct(ArrayList<Salesman> salesmen, 
			ArrayList<Product> products) {
		setLayout(new GridLayout(3, 2));
		JComboBox<Salesman> choiceSalesmen = new JComboBox<Salesman>();
		JComboBox<Product> choiceProducts = new JComboBox<Product>();
		JButton buttonAssociateProduct = new JButton("Associar");
		
		for (Salesman salesman : salesmen) {
			choiceSalesmen.addItem(salesman);
		}
		
		for (Product product : products) {
			choiceProducts.addItem(product);
		}
		
		add(new JLabel("Vendedor: "));
		add(choiceSalesmen);
		add(new JLabel("Produto: "));
		add(choiceProducts);
		add(buttonAssociateProduct);

		buttonAssociateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salesman salesman = (Salesman) choiceSalesmen.
						getSelectedItem();
				Product product = (Product) choiceProducts.getSelectedItem();
				
				salesman.addProduct(product);
				JOptionPane.showMessageDialog(null, 
						"Produto associado com sucesso!");
			}
		});
	}
}
