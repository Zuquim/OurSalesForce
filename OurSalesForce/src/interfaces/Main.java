package interfaces;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Selecione se deseja inicializar com ou sem interface gráfica
		startInterfaceMode();
		//startNoInterfaceMode();
	}
	
	public static void startInterfaceMode() {
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		janelaPrincipal.setVisible(true);
	}

	public static void startNoInterfaceMode() {
		ArrayList<Empresa> empresas = new ArrayList<Empresa>();
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		Agenda agenda = new Agenda();

		int choice = 1;

		while (choice != 0) {
			choice = menuOpcoes();

			switch (choice) {
				case 0:
					System.out.println("Obrigado por utilizar nosso sistema.");
					break;
				case 1:
					cadastraEmpresa(empresas);
					break;
				case 2:
					cadastraVendedor(vendedores);
					break;
				case 3:
					cadastraCliente(clientes, vendedores);
					break;
				case 4:
					cadastraProduto(produtos);
					break;
				case 5:
					associaProduto(vendedores, produtos);
					break;
				case 6:
					realizaAgendamento(agenda, clientes, vendedores);
					break;
				default:
					System.out.println("A opcao selecionada nao e valida, digite novamente");
			}
		}
	}
	
	public static int menuOpcoes() {
		int resp;

	    System.out.println("\n=== Cadastros ===\n");
	    System.out.println("1. Cadastrar empresa");
	    System.out.println("2. Cadastrar vendedor");
	    System.out.println("3. Cadastrar cliente");
	    System.out.println("4. Cadastrar produto");
	    System.out.println("5. Associar produtos ao cliente");
	    System.out.println("6. Realizar agendamento");
	    System.out.println("\n0. Sair");
	    System.out.print("\nSelecione a opcao desejada: ");
	    resp = in.nextInt();

	    return resp;
	}

	public static void cadastraEmpresa(ArrayList<Empresa> empresas) {
		Empresa empresa;
		System.out.print("Nome da empresa: ");
		String nome = in.next();
		empresa = new Empresa(nome);
		System.out.println("Código da empresa: " + empresa.getId());
		empresas.add(empresa);
	}

	public static void cadastraVendedor(ArrayList<Vendedor> vendedores) {
		Vendedor vendedor;
		System.out.print("Nome: ");
		String nome = in.next();
		System.out.print("Documento: ");
		String doc = in.next();
		vendedor = new Vendedor(nome, doc);
		vendedores.add(vendedor);
		System.out.println("Codigo do vendedor: " + vendedor.getId());
	}

	public static void cadastraCliente(ArrayList<Cliente> clientes, ArrayList<Vendedor> vendedores) {
		// String documento, String nome, String numeroConta, double saldo, Vendedor vendedor
		Cliente cliente;
		Vendedor vendedorAtual = null;
		System.out.print("Código do vendedor: ");
		int codVendedor = in.nextInt();

		// Busca vendedor pelo código
		for (Vendedor vendedor : vendedores) {
			if (vendedor.getId() == codVendedor) {
				vendedorAtual = vendedor;
			}
		}

		// Valida se vendedor foi encontrado para criar novo cliente
		if (vendedorAtual != null) {
			System.out.print("Nome: ");
			String nome = in.next();
			System.out.print("Documento: ");
			String doc = in.next();
			System.out.print("Numero da conta: ");
			String numeroConta = in.next();
			cliente = new Cliente(doc, nome, numeroConta, 0, vendedorAtual);
			clientes.add(cliente);
			System.out.println("Código do cliente: " + cliente.getId());
		} else {
			System.out.println("Não foi encontrado um vendedor com o código digitado.");
		}
	}

	public static void cadastraProduto(ArrayList<Produto> produtos) {
		Produto produto;
		System.out.print("Nome do produto: ");
		String nomeProduto = in.next();
		produto = new Produto(nomeProduto, 0);
		System.out.println("Código do produto: " + produto.getId());
		produtos.add(produto);
	}

	public static void associaProduto(ArrayList<Vendedor> vendedores, ArrayList<Produto> produtos) {
		Vendedor vendedorAtual = null;
		System.out.print("Código do cliente: ");
		int codCliente = in.nextInt();

		// Busca vendedor pelo codigo
		for (Vendedor vendedor: vendedores) {
			if (vendedor.getId() == codCliente) {
				vendedorAtual = vendedor;
			}
		}

		// Valida se vendedor foi encontrado
		if (vendedorAtual != null) {
			Produto produtoAtual = null;
			System.out.print("Digite o código do produto para associar: ");
			int codProduto = in.nextInt();

			// Busca produto pelo codigo
			for (Produto produto : produtos) {
				if (produto.getId() == codProduto) {
					produtoAtual = produto;
				}
			}

			// Valida se produto foi encontrado
			if (produtoAtual != null) {
				vendedorAtual.adicionaProduto(produtoAtual);
				System.out.println("Produto associado com sucesso.");
			} else {
				System.out.println("Produto não encontrado.");
			}
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}

	public static void realizaAgendamento(Agenda agenda, ArrayList<Cliente> clientes, ArrayList<Vendedor> vendedores) {
		Vendedor vendedorAtual = null;
		Cliente clienteAtual = null;
		
		System.out.print("Código do vendedor: ");
		int codVendedor = in.nextInt();
		
		for (Vendedor vendedor : vendedores) {
			if (vendedor.getId() == codVendedor) {
				vendedorAtual = vendedor;
			}
		}
		
		if (vendedorAtual != null) {
			System.out.print("Digite o código do cliente: ");
			int codCliente = in.nextInt();
			
			for (Cliente cliente : clientes) {
				if (cliente.getId() == codCliente) {
					clienteAtual = cliente;
				}
			}
			
			if (clienteAtual == null) {
				agenda.realizaAgendamento(vendedorAtual, clienteAtual);
				System.out.println("Agendado com sucesso.");
			} else {
				System.out.println("Cliente não encontrado.");
			}
		} else {
			System.out.println("Vendedor não encontrado.");
		}
	}

}
