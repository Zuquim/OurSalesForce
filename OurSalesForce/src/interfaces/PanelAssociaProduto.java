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

import model.Produto;
import model.Vendedor;

@SuppressWarnings("serial")
public class PanelAssociaProduto extends JPanel {
	public PanelAssociaProduto(ArrayList<Vendedor> vendedores, ArrayList<Produto> produtos) {
		setLayout(new GridLayout(3, 2));
		JComboBox<Vendedor> choiceVendedores = new JComboBox<Vendedor>();
		JComboBox<Produto> choiceProdutos = new JComboBox<Produto>();
		JButton butAssociarProduto = new JButton("Associar");
		
		for (Vendedor vendedor : vendedores) {
			choiceVendedores.addItem(vendedor);
		}
		
		for (Produto produto : produtos) {
			choiceProdutos.addItem(produto);
		}
		
		add(new JLabel("Vendedor: "));
		add(choiceVendedores);
		add(new JLabel("Produto: "));
		add(choiceProdutos);
		add(butAssociarProduto);

		butAssociarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendedor vendedor = (Vendedor) choiceVendedores.getSelectedItem();
				Produto produto = (Produto) choiceProdutos.getSelectedItem();
				
				vendedor.adicionaProduto(produto);
				JOptionPane.showMessageDialog(null, "Produto associado com sucesso!");
			}
		});
	}
}
