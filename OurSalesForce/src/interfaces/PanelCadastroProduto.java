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

import model.Produto;

@SuppressWarnings("serial")
public class PanelCadastroProduto extends JPanel {
	public PanelCadastroProduto(ArrayList<Produto> produtos) {
		setLayout(new GridLayout(2, 2));
		JTextField fieldNome = new JTextField();
		JButton butCadastroProduto = new JButton("Cadastrar Produto");

		add(new JLabel("Nome: "));
		add(fieldNome);
		add(butCadastroProduto);

		butCadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto;
				String nomeProduto = fieldNome.getText();
				produto = new Produto(nomeProduto, 0);
				produtos.add(produto);
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
				fieldNome.setText("");
			}
		});
	}
}
