package sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import dados.Escritor;
import dados.Leitor;
import enums.EnumConta;
import enums.EnumUsuario;
import funcionario.Funcionario;
import menus.Menu;


public class Sistema {
	public static void main(String[] args) {

		//criação das listas para armazaenamento dos dados
		List<Cliente> listaCliente = new ArrayList<>();
		List<Funcionario> listaFuncionario = new ArrayList<>();
		Map<String,Conta> listaConta = new HashMap<>();
		String pathDados = "src/dados/";

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

		//conta para ser usada nas operações
		Conta conta = listaConta.get(cpf);

		//menus
		Menu menu = new Menu();
		int opcMenu;
        double valor;
        
		switch(tipoUsuario) { 
			case CLIENTE:	
				do {
					opcMenu = menu.abrirMenu();
					if(opcMenu == 1) {
						//movimentacaocliente
						opcMenu = menu.abrirMenuClienteMovimentacao();
						switch(opcMenu) {
						case 1: 
							System.out.println("Digite o valor a ser sacado: ");
							valor = sc.nextDouble();
							conta.sacar(valor);
							break;
						case 2: 
							System.out.println("Digite o valor a ser depositado:");
							valor = sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3: 
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFtransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFtransferencia);
							if(contaTransferencia != null) {
								System.out.println("Qual valor desejado para realizar a transferência?");
							    valor = sc.nextDouble();
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							
							break;
						case 4: 
							System.out.println("Extrato");
						}
					} else if(opcMenu == 2) {
						//relatorios cliente
						opcMenu = menu.abrirMenuClienteRelatorios();
						switch(opcMenu) {
						case 1: 
							System.out.println("Saldo");
							try {
								Escritor.relatorioSaldo(conta);
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case 2: 
							System.out.println("Relatório tributação");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								
								try {
									Escritor.relatorioTributacao((ContaCorrente)conta);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
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
					opcMenu = menu.abrirMenu();
					if(opcMenu == 1) {
						//movimentacao gerente
						opcMenu = menu.abrirMenuFuncionarioMovimentacao();
						switch(opcMenu) {
						case 1: 
							System.out.println("Digite o valor a ser sacado:");
							valor = sc.nextDouble();
							conta.sacar(valor);
							break;
						case 2: 
							System.out.println("Digite o valor a ser depositado:");
							valor =sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3: 
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
								System.out.println("Qual valor desejado para realizar a transferência?");
							    valor = sc.nextDouble();
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							break;
						case 4: 
							System.out.println("Extrato");
						}
					} else if(opcMenu == 2) {
						//relatorios gerente
						opcMenu = menu.abrirMenuGerenteRelatorios();
						switch(opcMenu) {
						case 1: 
							System.out.println("Saldo");
							try {
								Escritor.relatorioSaldo(conta);
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case 2: 
							System.out.println("Relatório tributação");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								
								try {
									Escritor.relatorioTributacao((ContaCorrente)conta);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							break;
						
						case 3: 
							System.out.println("Relatório rendimento");
							break;
						case 4:
							System.out.println("Relatório no número de contas");
							try {
								Escritor.relatorioNumeroContas(conta.getAgencia());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}while(opcMenu != 0);
				
				break;
				
			case DIRETOR:
				do {
					opcMenu = menu.abrirMenu();
					if(opcMenu == 1) {
						opcMenu = menu.abrirMenuFuncionarioMovimentacao (); 
						switch(opcMenu) {
						case 1:
							System.out.println("Digite o valor a ser sacado:");
							valor = sc.nextDouble();
							conta.sacar(valor);
							break;
						case 2:
							System.out.println("Digite o valor a ser depositado:");
							valor = sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3:
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
								System.out.println("Qual valor desejado para realizar a transferência?");
							    valor = sc.nextDouble();
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							break;
						case 4:
							System.out.println("Extrato da conta do cliente");
						}

					} else if (opcMenu == 2) {
						opcMenu = menu.abrirMenuDiretorRelatorio();

						switch (opcMenu) {
						case 1:
							System.out.println("Saldo");
							try {
								Escritor.relatorioSaldo(conta);
							} catch (IOException e) {
								e.printStackTrace();
							}
							break;
						case 2:
							System.out.println("Relatório tributação");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								
								try {
									Escritor.relatorioTributacao((ContaCorrente)conta);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							break;
						case 3:
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
								System.out.println("Qual valor desejado para realizar a transferência?");
							    valor = sc.nextDouble();
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							break;
						case 4:
							System.out.println("Relatório no números de contas");
							try {
								Escritor.relatorioNumeroContas(conta.getAgencia());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case 5:
							System.out.println("Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
						}
					}
				}while(opcMenu != 0);
				
				break;
				
			case PRESIDENTE:
				do {
					opcMenu = menu.abrirMenu();
					if (opcMenu == 1) {
						opcMenu = menu.abrirMenuFuncionarioMovimentacao();

						switch (opcMenu) {
						case 1:
							System.out.println("Digite o valor a ser sacado:");
							valor = sc.nextDouble();
							conta.sacar(valor);
							break;
						case 2:
							System.out.println("Digite o valor a ser depositado:");
						    valor = sc.nextDouble();
							conta.depositar(valor);
							break;
						case 3:
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
								System.out.println("Qual valor desejado para realizar a transferência?");
							    valor = sc.nextDouble();
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							break;
						case 4: System.out.println("Extrato da conta do cliente");
						}


					} else if (opcMenu == 2) {
						opcMenu = menu.abrirMenuRelatorioPresidente();
						switch (opcMenu) {
						case 1:
							System.out.println("Saldo");
							try {
								Escritor.relatorioSaldo(conta);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case 2:
							System.out.println("Relatório de Tributação");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								try {
									Escritor.relatorioTributacao((ContaCorrente)conta);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							break;
						case 3:
							System.out.println("Relatório de Rendimento");
							break;
						case 4:
							System.out.println("Relatório no números de contas");
							try {
								Escritor.relatorioNumeroContas(conta.getAgencia());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
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
				//break;
		}
		
		try {
			Escritor.salvarContas(pathDados + "conta.txt", listaConta);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
