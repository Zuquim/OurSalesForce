package interfaces;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Select if you wish to initialize with GUI
		startInterfaceMode();
		//startNoInterfaceMode();
	}
	
	public static void startInterfaceMode() {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}

	public static void startNoInterfaceMode() {
		ArrayList<Company> companies = new ArrayList<Company>();
		ArrayList<Salesman> salesmen = new ArrayList<Salesman>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Product> products = new ArrayList<Product>();
		Agenda agenda = new Agenda();

		int choice = 1;

		while (choice != 0) {
			choice = optionsMenu();

			switch (choice) {
				case 0:
					System.out.println("Obrigado por utilizar nosso sistema.");
					break;
				case 1:
					registerCompany(companies);
					break;
				case 2:
					registerSalesman(salesmen);
					break;
				case 3:
					registerCustomer(customers, salesmen);
					break;
				case 4:
					registerProduct(products);
					break;
				case 5:
					associateProduct(salesmen, products);
					break;
				case 6:
					scheduleAppointment(agenda, customers, salesmen);
					break;
				default:
					System.out.println("A opcao selecionada nao e valida,"
							+ " digite novamente");
			}
		}
	}
	
	public static int optionsMenu() {
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

	public static void registerCompany(ArrayList<Company> empresas) {
		Company company;
		System.out.print("Nome da empresa: ");
		String name = in.next();
		company = new Company(name);
		System.out.println("Código da empresa: " + company.getId());
		empresas.add(company);
	}

	public static void registerSalesman(ArrayList<Salesman> salesmen) {
		Salesman salesman;
		System.out.print("Nome: ");
		String name = in.next();
		System.out.print("Documento: ");
		String doc = in.next();
		salesman = new Salesman(name, doc);
		salesmen.add(salesman);
		System.out.println("Codigo do vendedor: " + salesman.getId());
	}

	public static void registerCustomer(ArrayList<Customer> customers,
			ArrayList<Salesman> salesmen) {
		// String documento, String nome, String numeroConta, double saldo, Vendedor vendedor
		Customer customer;
		Salesman currentSalesman = null;
		System.out.print("Código do vendedor: ");
		int salesmanId = in.nextInt();

		// Busca vendedor pelo código
		for (Salesman salesman : salesmen) {
			if (salesman.getId() == salesmanId) {
				currentSalesman = salesman;
			}
		}

		// Valida se vendedor foi encontrado para criar novo cliente
		if (currentSalesman != null) {
			System.out.print("Nome: ");
			String name = in.next();
			System.out.print("Documento: ");
			String doc = in.next();
			System.out.print("Numero da conta: ");
			String accountNumber = in.next();
			customer = new Customer(doc, name, accountNumber, 0,
					currentSalesman);
			customers.add(customer);
			System.out.println("Código do cliente: " + customer.getId());
		} else {
			System.out.println("Não foi encontrado um vendedor com o código"
					+ " digitado.");
		}
	}

	public static void registerProduct(ArrayList<Product> products) {
		Product product;
		System.out.print("Nome do produto: ");
		String productName = in.next();
		product = new Product(productName, 0);
		System.out.println("Código do produto: " + product.getId());
		products.add(product);
	}

	public static void associateProduct(ArrayList<Salesman> salesmen,
			ArrayList<Product> products) {
		Salesman currentSalesman = null;
		System.out.print("Código do cliente: ");
		int customerId = in.nextInt();

		// Busca vendedor pelo codigo
		for (Salesman salesman: salesmen) {
			if (salesman.getId() == customerId) {
				currentSalesman = salesman;
			}
		}

		// Valida se vendedor foi encontrado
		if (currentSalesman != null) {
			Product currentProduct = null;
			System.out.print("Digite o código do produto para associar: ");
			int productId = in.nextInt();

			// Busca produto pelo codigo
			for (Product produto : products) {
				if (produto.getId() == productId) {
					currentProduct = produto;
				}
			}

			// Valida se produto foi encontrado
			if (currentProduct != null) {
				currentSalesman.addProduct(currentProduct);
				System.out.println("Produto associado com sucesso.");
			} else {
				System.out.println("Produto não encontrado.");
			}
		} else {
			System.out.println("Cliente não encontrado.");
		}
	}

	public static void scheduleAppointment(Agenda agenda, ArrayList<Customer> 
	clientes, ArrayList<Salesman> vendedores) {
		Salesman vendedorAtual = null;
		Customer clienteAtual = null;
		
		System.out.print("Código do vendedor: ");
		int codVendedor = in.nextInt();
		
		for (Salesman vendedor : vendedores) {
			if (vendedor.getId() == codVendedor) {
				vendedorAtual = vendedor;
			}
		}
		
		if (vendedorAtual != null) {
			System.out.print("Digite o código do cliente: ");
			int codCliente = in.nextInt();
			
			for (Customer cliente : clientes) {
				if (cliente.getId() == codCliente) {
					clienteAtual = cliente;
				}
			}
			
			if (clienteAtual == null) {
				agenda.scheduleAppointment(vendedorAtual, clienteAtual);
				System.out.println("Agendado com sucesso.");
			} else {
				System.out.println("Cliente não encontrado.");
			}
		} else {
			System.out.println("Vendedor não encontrado.");
		}
	}

}
