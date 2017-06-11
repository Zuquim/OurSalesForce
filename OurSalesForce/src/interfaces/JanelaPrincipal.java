package interfaces;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {
	final static String CADASTROEMPRESAPANEL = "Cadastro de Empresa";
	final static String CADASTROVENDEDORPANEL = "Cadastro de Vendedor";
	ActionListener handleMenuClick;

	JanelaPrincipal() {
		super("OurSalesForce - Pongelupe e Baldi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Barra de menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menuCadastros = new JMenu("Cadastros");
		JMenuItem menuItemEmpresa = new JMenuItem("Empresa");
		menuItemEmpresa.addActionListener(handleMenuClick);
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
		setJMenuBar(menuBar);

		JPanel screens = new JPanel(new CardLayout());
		
		JPanel panelCadastroEmpresa = new JPanel(new GridLayout(2, 2));		
		JButton butCadastroEmpresa = new JButton("Cadastrar Empresa");
		panelCadastroEmpresa.add(new JLabel("Nome: "));
		panelCadastroEmpresa.add(new JTextField());
		panelCadastroEmpresa.add(butCadastroEmpresa);
		

		JPanel panelCadastroVendedor = new JPanel(new GridLayout(2, 2));
		panelCadastroVendedor.add(new JLabel("Nome: "));
		panelCadastroVendedor.add(new JTextField());
		panelCadastroVendedor.add(new JLabel("Documento: "));
		panelCadastroVendedor.add(new JTextField());

		screens.add(panelCadastroEmpresa, CADASTROVENDEDORPANEL);
		screens.add(panelCadastroVendedor, CADASTROVENDEDORPANEL);

		getContentPane().add(screens);
		
		handleMenuClick = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.out.println(e.getSource());
		    }
		};

		pack();
		setLocationRelativeTo(null);
	}
}
