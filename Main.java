import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Cliente[] clientes = new Cliente[3];
		Empregado[] empregados = new Empregado[3];

		Scanner teclado = new Scanner(System.in);
		String line;
		int indexCli = 0;
		int indexEmp = 0;
		do {
			System.out.print("> ");
			line = teclado.nextLine();
			switch (line.toLowerCase()) {
			case "help":
				printMenu();
				break;
			case "1":
				if (indexEmp >= empregados.length) {
					System.out.println("Número máximo de cadastros atingido!");
					break;
				}
				empregados[indexEmp] = cadastrarEmpregado();
				if (indexEmp != 0) {
					for (int i = 0; i != indexEmp; i++) {
						if (empregados[indexEmp].cpf.equals(empregados[i].cpf)) {
							System.out.println("Cadastro não aceito, CPF já registrado em Empregado!");
							empregados[indexEmp] = null;

							indexEmp--;
							break;
						}

					}
				}
				if (indexCli != 0) {
					for (int i = 0; i < clientes.length; i++) {
						if (clientes[i] != null) {
							if (empregados[indexEmp].cpf.equals(clientes[i].cpf)) {
								System.out.println("Cadastro não aceito, CPF já registrado em Cliente!");
								empregados[indexEmp] = null;

								indexEmp--;
								break;
							}
						}
					}
				}

				indexEmp++;
				break;
			case "2":
				if (indexCli >= clientes.length) {
					System.out.println("Número máximo de cadastros atingido!");
					break;
				}
				clientes[indexCli] = cadastrarCliente();
				if (indexCli != 0) {
					for (int i = 0; i != indexCli; i++) {
						if (clientes[indexCli].cpf.equals(clientes[i].cpf)) {
							System.out.println("Cadastro não aceito, CPF já registrado em Cliente!");
							clientes[indexCli] = null;

							indexCli--;
							break;
						}

					}
				}
				if (indexEmp != 0) {
					for (int i = 0; i < empregados.length; i++) {
						if (empregados[i] != null) {
							if (clientes[indexCli].cpf.equals(empregados[i].cpf)) {
								System.out.println("Cadastro não aceito, CPF já registrado em Empregado!");
								clientes[indexCli] = null;

								indexCli--;
								break;
							}
						}
					}
				}
				indexCli++;
				break;
			case "3":
				System.out.println("Favor insira o CPF a ser buscado:");
				String aux = teclado.nextLine();
				int aux2 = pesquisarEmp(empregados, aux);

				if (pesquisarEmp(empregados, aux) == -2) {
					if (pesquisarCli(clientes, aux) == -1) {
						System.out.println("CPF não consta no sistema!");
						break;
					} else {
						System.out.println("CPF pertencente ao Cliente " + clientes[pesquisarCli(clientes, aux)].nome);
						break;
					}
				} else {
					System.out
							.println("CPF pertencente ao Empregado " + empregados[pesquisarEmp(empregados, aux)].nome);
					break;
				}

			case "4":
				System.out.println("Listando Empregados");
				for (int i = 0; i < empregados.length; i++) {
					System.out.println(empregados[i]);
				}
				break;
			case "5":
				System.out.println("Listando Clientes");
				for (int i = 0; i < empregados.length; i++) {
					System.out.println(clientes[i]);
				}
				break;
			case "6":
				System.out.println("Favor insira o CPF a ser buscado:");
				aux = teclado.nextLine();
				if (pesquisarEmp(empregados, aux) == -2) {
					if (pesquisarCli(clientes, aux) == -1) {
						System.out.println("CPF não consta no sistema!");
						break;
					} else {
						System.out
								.println("CPF pertencente ao Cliente " + clientes[(pesquisarCli(clientes, aux))].nome);
						String auxConf = inputConfirmacao();
						if (auxConf.equalsIgnoreCase("S")) {
							indexCli--;
							clientes[(pesquisarCli(clientes, aux))] = null;
							for (int i = 0; i < clientes.length; i++) {
								if (clientes[i] == null) {
									for (int j = i + 1; j < clientes.length; j++) {
										clientes[j - 1] = clientes[j];
									}
									clientes[clientes.length - 1] = null;
									break;
								}
							}
						}
						break;
					}
				} else {
					System.out.println(
							"CPF pertencente ao Empregado " + empregados[(pesquisarEmp(empregados, aux))].nome);
					String auxConf = inputConfirmacao();
					if (auxConf.equalsIgnoreCase("S")) {
						indexEmp--;
						empregados[(pesquisarEmp(empregados, aux))] = null;
						for (int i = 0; i < empregados.length; i++) {
							if (empregados[i] == null) {
								for (int j = i + 1; j < empregados.length; j++) {
									empregados[j - 1] = empregados[j];
								}
								empregados[empregados.length - 1] = null;
								break;
							}
						}
					}
					break;
				}
			case "7":
				break;
			default:
				System.out.println("Opcao invalida");
			}

		} while (!line.equals("7"));

	}

	public static int pesquisarEmp(Empregado[] empregados, String aux) {
		for (int i = 0; i < empregados.length; i++) {
			if (empregados[i] == null) {
				return -2;
			} else if (empregados[i].cpf.equals(aux)) {
				return i;
			}
		}
		return -2; 
	}

	public static int pesquisarCli(Cliente[] clientes, String aux) {
		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				return -1;
			} else if (clientes[i].cpf.equals(aux)) {
				return i;
			}
		}
		return -1;
	}

	public static Empregado cadastrarEmpregado() {
		Scanner teclado = new Scanner(System.in);
		Empregado empregado = null;

		String tipoEmpregado = inputTipoEmpregado();
		switch (tipoEmpregado) {
		case "g":
			empregado = cadastrarG();
			break;
		case "v":
			empregado = cadastrarV();
			break;
		}

		return empregado;
	}

	private static String inputTipoEmpregado() {
		String tipoEmpregado = null;
		while (tipoEmpregado == null) {
			System.out.print("Gerente (g) ou Vendedor (v): ");
			tipoEmpregado = new Scanner(System.in).nextLine();
			if (!"g".equals(tipoEmpregado) && !"v".equals(tipoEmpregado)) {
				tipoEmpregado = null;
				System.out.println("Opcao invalida, aceitamos apenas g ou v");
			}
		}
		return tipoEmpregado;
	}

	public static String inputConfirmacao() {
		String conf = null;
		while (conf == null) {
			System.out.println("Deseja remover o cadastro? S/N");
			conf = new Scanner(System.in).nextLine();
			if (!"s".equalsIgnoreCase(conf) && !"n".equalsIgnoreCase(conf)) {
				conf = null;
				System.out.println("Opcao invalida, aceitamos apenas S ou N");
			}
		}
		return conf;
	}

	private static Gerente cadastrarG() {
		Gerente gerente = new Gerente();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Nome:");
		gerente.nome = teclado.nextLine();

		System.out.println("CPF:");
		gerente.cpf = teclado.nextLine();

		System.out.println("Matrícula:");
		gerente.matricula = teclado.nextLine();

		System.out.println("Salário:");
		double salario = new Scanner(System.in).nextDouble();
		gerente.setSalario(salario);

		System.out.println("Bônus:");
		double bonus = new Scanner(System.in).nextDouble();
		gerente.setBonus(bonus);

		return gerente;
	}

	private static Vendedor cadastrarV() {
		Vendedor vendedor = new Vendedor();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Nome:");
		vendedor.nome = teclado.nextLine();

		System.out.println("CPF:");
		vendedor.cpf = teclado.nextLine();

		System.out.println("Matrícula:");
		vendedor.matricula = teclado.nextLine();

		System.out.println("Valor total das vendas:");
		double total = new Scanner(System.in).nextDouble();

		vendedor.setTotalDasVendas(total);

		System.out.println("Comissão:");
		double comissao = new Scanner(System.in).nextDouble();
		vendedor.setComissao(comissao);

		return vendedor;
	}

	public static Cliente cadastrarCliente() {
		Scanner teclado = new Scanner(System.in);
		Cliente cliente = new Cliente();

		System.out.println("Nome:");
		cliente.nome = teclado.nextLine();

		System.out.println("CPF:");
		cliente.cpf = teclado.nextLine();

		System.out.println("Valor da dívida:");
		cliente.setValorDaDivida(teclado.nextDouble());

		return cliente;
	}

	public static void printMenu() {
		System.out.println("--- Menu ---");
		System.out.println("1. Cadastrar Empregado");
		System.out.println("2. Cadastrar Clientes");
		System.out.println("3. Pesquisar");
		System.out.println("4. Listar Empregados");
		System.out.println("5. Listar Clientes");
		System.out.println("6. Remover");
		System.out.println("7. Finalizar");
	}

}
