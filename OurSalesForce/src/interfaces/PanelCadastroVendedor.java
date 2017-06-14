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

import model.Vendedor;

@SuppressWarnings("serial")
public class PanelCadastroVendedor extends JPanel {
	public PanelCadastroVendedor(ArrayList<Vendedor> vendedores) {
		setLayout(new GridLayout(3, 3));
		JTextField fieldNome = new JTextField();
		JTextField fieldDoc = new JTextField();
		JButton butCadastroVendedor = new JButton("Cadastrar");

		add(new JLabel("Nome: "));
		add(fieldNome);
		add(new JLabel("Documento: "));
		add(fieldDoc);
		add(butCadastroVendedor);

		butCadastroVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendedor vendedor;
				String nome = fieldNome.getText();
				String doc = fieldDoc.getText();
				vendedor = new Vendedor(nome, doc);
				vendedores.add(vendedor);
				System.out.println("Codigo do vendedor: " + vendedor.getId());
				JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
				fieldNome.setText("");
				fieldDoc.setText("");
			}
		});
	}
}
