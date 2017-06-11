package interfaces;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GerenciadorInterface {

	public static JMenuBar criaBarraMenu() {
		JMenuBar menuBar = new JMenuBar();
		
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

		menuBar.add(menuCadastros);
		menuBar.add(menuAgendamento);
		
		return menuBar;
	}
}
