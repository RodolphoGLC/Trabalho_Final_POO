package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cliente.Cliente;
import conta.Conta;
import dados.Leitor;
import enums.EnumUsuario;
import funcionario.Funcionario;
import interface_usuario.InterfaceUsuario;


public class Sistema {
	public static void main(String[] args) {

		//criação das listas para armazaenamento dos dados
		List<Cliente> listaCliente = new ArrayList<>();
		List<Funcionario> listaFuncionario = new ArrayList<>();
		Map<String,Conta> listaConta = new HashMap<>();
		String pathDados = System.getProperty("user.dir") + "\\src\\dados\\";

		//incialização dos dados a partir dos txt
		try {
			Leitor.lerClientes(pathDados + "cliente.txt", listaCliente);
			Leitor.lerGerente(pathDados + "gerente.txt", listaFuncionario);
			Leitor.lerDiretor(pathDados + "diretor.txt", listaFuncionario);
			Leitor.lerPresidente(pathDados + "presidente.txt", listaFuncionario);
			Leitor.lerConta(pathDados + "conta.txt", listaConta);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//login
		String cpf, senha;
		EnumUsuario tipoUsuario = EnumUsuario.INVALIDO;
		boolean usuarioValido = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----Login-----");
		System.out.println("Cpf:");
		cpf = sc.next();
		System.out.println("Senha:");
		senha = sc.next();
		
		for(Cliente c : listaCliente) {
			if(c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
				tipoUsuario = EnumUsuario.CLIENTE;
				usuarioValido = true;
			}
		}
		
		for(Funcionario f : listaFuncionario) {
			if(f.getCpf().equals(cpf) && f.getSenha().equals(senha)) {
				tipoUsuario = f.getCargo();
				usuarioValido = true;
			}
		}
		
		if(usuarioValido) {
			//conta para ser usada nas operações
			
		}
		Conta conta = listaConta.get(cpf);
		//menus
		InterfaceUsuario iu = new InterfaceUsuario();
		int opcMenu;

		switch(tipoUsuario) { 
			case CLIENTE:
				
				do {
					opcMenu = iu.abrirMenu();
					if(opcMenu == 1) {
						//movimentacaocliente
						opcMenu = iu.abrirMenuClienteMovimentacao();
						switch(opcMenu) {
						case 1: 
							System.out.println("Saque");
							break;
						case 2: 
							System.out.println("Digite o valor a ser depositado:");
							double valor = sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3: 
							System.out.println("Transferência");
							break;
						case 4: 
							System.out.println("Extrato");
						}
					} else if(opcMenu == 2) {
						//relatorios cliente
						opcMenu = iu.abrirMenuClienteRelatorios();
						switch(opcMenu) {
						case 1: 
							System.out.println("Saldo");
							break;
						case 2: 
							System.out.println("Relatório tributação");
							break;
						case 3: 
							System.out.println("Relatório rendimento");
							break;
						}
					}
				}while(opcMenu != 0);

				break;
				
			case GERENTE: 
				do {
					opcMenu = iu.abrirMenu();
					if(opcMenu == 1) {
						//movimentacao gerente
						opcMenu = iu.abrirMenuFuncionarioMovimentacao();
						switch(opcMenu) {
						case 1: 
							System.out.println("Saque");
							break;
						case 2: 
							System.out.println("Digite o valor a ser depositado:");
							double valor =sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3: 
							System.out.println("Transferência");
							break;
						case 4: 
							System.out.println("Extrato");
						}
					} else if(opcMenu == 2) {
						//relatorios gerente
						opcMenu = iu.abrirMenuGerenteRelatorios();
						switch(opcMenu) {
						case 1: 
							System.out.println("Saldo");
							break;
						case 2: 
							System.out.println("Relatório tributação");
							break;
						case 3: 
							System.out.println("Relatório rendimento");
							break;
						case 4:
							System.out.println("Relatório no número de contas");
						}
					}
				}while(opcMenu != 0);
				
				break;
				
			case DIRETOR:
				do {
					opcMenu = iu.abrirMenu();
					if(opcMenu == 1) {
						opcMenu = iu.abrirMenuFuncionarioMovimentacao (); 
						switch(opcMenu) {
						case 1:
							System.out.println("Saque");
							break;
						case 2:
							System.out.println("Digite o valor a ser depositado:");
							double valor = sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3:
							System.out.println("Transferência para outra conta");
							break;
						case 4:
							System.out.println("Extrato da conta do cliente");
						}

					} else if (opcMenu == 2) {
						opcMenu = iu.abrirMenuDiretorRelatorio();

						switch (opcMenu) {
						case 1:
							System.out.println("Saldo");
							break;
						case 2:
							System.out.println("Relatório de Tributação");
							break;
						case 3:
							System.out.println("Relatório de Rendimento");
							break;
						case 4:
							System.out.println("Relatório no números de contas");
							break;
						case 5:
							System.out.println("Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
						}
					}
				}while(opcMenu != 0);
				
				break;
				
			case PRESIDENTE:
				do {
					opcMenu = iu.abrirMenu();
					if (opcMenu == 1) {
						opcMenu = iu.abrirMenuFuncionarioMovimentacao();

						switch (opcMenu) {
						case 1:
							System.out.println("Saque");
							break;
						case 2:
							System.out.println("Digite o valor a ser depositado:");
							double valor = sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3:
							System.out.println("Transferência para outra conta");
							break;
						case 4: System.out.println("Extrato da conta do cliente");
						}


					} else if (opcMenu == 2) {
						opcMenu = iu.abrirMenuRelatorioPresidente();
						switch (opcMenu) {
						case 1:
							System.out.println("Saldo");
							break;
						case 2:
							System.out.println("Relatório de Tributação");
							break;
						case 3:
							System.out.println("Relatório de Rendimento");
							break;
						case 4:
							System.out.println("Relatório no números de contas");
							break;
						case 5:
							System.out.println("Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
							break; 
						case 6:
							System.out.println("Relatório com o valor total capital armazenado no banco");
						}
					}
				}while(opcMenu != 0);
					
				break;
			case INVALIDO:
				System.out.println("Senha ou usuário inválido.");
		}
	}
}
