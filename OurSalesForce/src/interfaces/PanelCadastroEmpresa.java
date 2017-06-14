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

import model.Empresa;

@SuppressWarnings("serial")
public class PanelCadastroEmpresa extends JPanel {
	public PanelCadastroEmpresa(ArrayList<Empresa> empresas) {
		setLayout(new GridLayout(2, 2));
		JButton butCadastroEmpresa = new JButton("Cadastrar Empresa");
		JTextField fieldNome = new JTextField();

		add(new JLabel("Nome: "));
		add(fieldNome);
		add(butCadastroEmpresa);

		butCadastroEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empresa empresa;
				String nome = fieldNome.getText();
				empresa = new Empresa(nome);
				System.out.println("Código da empresa: " + empresa.getId());
				empresas.add(empresa);
				JOptionPane.showMessageDialog(null, "Empresa cadastrado com sucesso!");
				fieldNome.setText("");
			}
		});
	}
}
