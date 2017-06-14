package interfaces;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.Agenda;
import model.Cliente;
import model.Empresa;
import model.Produto;
import model.Vendedor;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	private ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Agenda agenda = new Agenda();

	JanelaPrincipal() {
		super("OurSalesForce - Pongelupe e Baldi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Telas de cadastro
		JPanel screens = new JPanel(new CardLayout());
		JPanel panelCadastroEmpresa = new PanelCadastroEmpresa(empresas);
		JPanel panelCadastroVendedor = new PanelCadastroVendedor(vendedores);
		JPanel panelCadastroCliente = new PanelCadastroCliente(clientes, vendedores);
		JPanel panelCadastroProduto = new PanelCadastroProduto(produtos);
		JPanel panelAssociaProduto = new PanelAssociaProduto(vendedores, produtos);
		JPanel panelRealizaAgendamento = new PanelRealizaAgendamento(agenda, clientes, vendedores);

		// Adiciona as telas no card layout com o id para realizar a troca das telas em BarraTarefas
		screens.add(panelCadastroEmpresa, "empresa");
		screens.add(panelCadastroVendedor, "vendedor");
		screens.add(panelCadastroCliente, "cliente");
		screens.add(panelCadastroProduto, "produto");
		screens.add(panelAssociaProduto, "associar produto");
		screens.add(panelRealizaAgendamento, "realizar agendamento");

		// Barra de menu
		JMenuBar menuBar = new BarraTarefas(screens, vendedores);
		setJMenuBar(menuBar);

		getContentPane().add(screens);

		pack();
		setLocationRelativeTo(null);
	}
}
