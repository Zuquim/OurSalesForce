package interfaces;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Vendedor;

@SuppressWarnings("serial")
public class BarraTarefas extends JMenuBar {
	
	public BarraTarefas(JPanel menuBar, ArrayList<Vendedor> vendedores) {
		JMenu menuCadastros = new JMenu("Cadastros");
		JMenuItem menuItemEmpresa = new JMenuItem("Empresa");
		JMenuItem menuItemVendedor = new JMenuItem("Vendedor");
		JMenuItem menuItemCliente = new JMenuItem("Cliente");
		JMenuItem menuItemProduto = new JMenuItem("Produto");
		JMenuItem menuItemAssociaProduto = new JMenuItem("Associar Produto");

		menuCadastros.add(menuItemEmpresa);
		menuCadastros.add(menuItemVendedor);
		menuCadastros.add(menuItemCliente);
		menuCadastros.add(menuItemProduto);
		menuCadastros.addSeparator();
		menuCadastros.add(menuItemAssociaProduto);

		JMenu menuAgendamento = new JMenu("Agendamento");
		JMenuItem menuItemAgendamento = new JMenuItem("Realizar Agendamento");

		menuAgendamento.add(menuItemAgendamento);

		add(menuCadastros);
		add(menuAgendamento);
		
		ActionListener handleGenericClick = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String screenName = e.getActionCommand().toLowerCase();
		        CardLayout cl = (CardLayout)(menuBar.getLayout());
		        cl.show(menuBar, screenName);
		    }
		};
		
		// Realiza o bind da troca de telas
		menuItemEmpresa.addActionListener(handleGenericClick);
		menuItemVendedor.addActionListener(handleGenericClick);
		menuItemCliente.addActionListener(handleGenericClick);
		menuItemProduto.addActionListener(handleGenericClick);
		menuItemAssociaProduto.addActionListener(handleGenericClick);
		menuItemAgendamento.addActionListener(handleGenericClick);
	}
}
