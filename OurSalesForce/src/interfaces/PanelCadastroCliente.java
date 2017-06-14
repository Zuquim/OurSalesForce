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

import model.Cliente;
import model.Vendedor;

@SuppressWarnings("serial")
public class PanelCadastroCliente extends JPanel {
	
	public PanelCadastroCliente(ArrayList<Cliente> clientes,  ArrayList<Vendedor> vendedores) {
		setLayout(new GridLayout(5, 2));
		JComboBox<Vendedor> choiceVendedores = new JComboBox<Vendedor>();
		JTextField fieldNome = new JTextField();
		JTextField fieldDoc = new JTextField();
		JTextField fieldNumeroConta = new JTextField();
		JButton butCadastroCliente = new JButton("Cadastrar");
		
		for (Vendedor vendedor : vendedores) {
			choiceVendedores.addItem(vendedor);
		}
		
		add(new JLabel("Vendedor: "));
		add(choiceVendedores);
		add(new JLabel("Nome: "));
		add(fieldNome);
		add(new JLabel("Documento: "));
		add(fieldDoc);
		add(new JLabel("Numero da conta:"));
		add(fieldNumeroConta);
		add(butCadastroCliente);

		butCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendedor vendedor = (Vendedor) choiceVendedores.getSelectedItem();
				String nome = fieldNome.getText();
				String doc = fieldDoc.getText();
				String numeroConta = fieldNumeroConta.getText();
				clientes.add(new Cliente(doc, nome, numeroConta, 0, vendedor));
				JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
				fieldNome.setText("");
				fieldDoc.setText("");
				fieldNumeroConta.setText("");
			}
		});
	}
	
}
