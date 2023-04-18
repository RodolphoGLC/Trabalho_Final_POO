package interface_usuario;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InterfaceUsuario {
	
	private Scanner sc;

	public InterfaceUsuario() {
		sc = new Scanner(System.in);
	}

	public String logar() {

		String cpf, senha;
		
		System.out.println("-----Login-----");
		System.out.println("Cpf:");
		cpf = sc.next();
		System.out.println("Senha:");
		senha = sc.next();
		
		//TODO
		//fazer lógica para verificar que tipo de usuario é
		//retornando 'cliente' só para teste
		return "Diretor";
	}
	
	public int abrirMenu() {
		
		int opc;
		
		do {
			System.out.println("-----Menu------");
			System.out.println("1.Movimentação na Conta");
			System.out.println("2.Relatórios");
			System.out.println("0.Sair");
			System.out.println("-----------------------");
			System.out.println("Digite o numero da sua escolha: ");
			opc = sc.nextInt();
			
			if(opc < 0 && opc > 2) {
				System.out.println("Entrada inválida. \nTente de novo.");
				try {
					//para esperar 5s para usuário ler mensagem
					//exige try catch
					TimeUnit.SECONDS.sleep(5);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} while(opc < 0 && opc > 2);
		
		return opc;
	}
	
	public int abrirMenuClienteMovimentacao() {
		
		int opc;
		
		do {
			System.out.println("-----Movimentação na Conta------");
			System.out.println("1.Saque");
			System.out.println("2.Depósito");
			System.out.println("3.Transferência para outra conta");
			System.out.println("4.Extrato da Conta");
			System.out.println("0.Sair");
			System.out.println("--------------------------------");
			System.out.println("Digite o numero da sua escolha: ");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1:
					return 1;
				case 2: 
					return 2;
				case 3:
					return 3;
				case 4: 
					return 4;
				case 0:
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(5);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 0);
		
		return 0;
	}
	
	public int abrirMenuClienteRelatorios() {
		
		int opc;
		
		do {
			System.out.println("-----Relatórios------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente");
			System.out.println("3.Relatório de Rendimento da Poupança");
			System.out.println("0.Sair");
			System.out.println("---------------------");
			System.out.println("Digite o numero da sua escolha: ");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1:
					return 1;
				case 2: 
					return 2;
				case 3:
					return 3;
				case 0:
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(5);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 0);
		
		return 0;
	}
	
	public int abrirMenuFuncionarioMovimentacao() {
		int opc;
		
		do {
			System.out.println("-----Movimentações na Conta------");
			System.out.println("1.Saque");
			System.out.println("2.Depósito");
			System.out.println("3.Transferência para outra conta");
			System.out.println("4.Extrato da Conta");
			System.out.println("0.Sair");
			System.out.println("--------------------------------");
			System.out.println("Digite o numero da sua escolha: ");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1:
					return 1;
				case 2: 
					return 2;
				case 3:
					return 3;
				case 4: 
					return 4;
				case 0:
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(5);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 0);
		
		return 0;
	}
	
	public int abrirMenuGerenteRelatorios() {
		
		int opc;
		
		do {
			System.out.println("-----Relatórios------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente");
			System.out.println("3.Relatório de Rendimento da Poupança");
			System.out.println("4.Relatório de Número de Contas na Agência");
			System.out.println("0.Sair");
			System.out.println("---------------------");
			System.out.println("Digite o numero da sua escolha: ");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1:
					return 1;
				case 2: 
					return 2;
				case 3:
					return 3;
				case 4:
					return 4;
				case 0:
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(5);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 0);
		
		return 0;
	}
		

	public int abrirMenuDiretorRelatorio() {
		int opc;

		do {
			System.out.println("-----Relatórios------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente:");
			System.out.println("3.Relatório de Rendimento da Poupança:");
			System.out.println("4.Relatório de Número de Contas da Agência");
			System.out.println("5.Relatórios com as informações de Nome e CPF");
			System.out.println("0.Sair");
			System.out.println("---------------------");
			opc = sc.nextInt();

			switch(opc) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4: 
				return 4;
			case 5:
				return 5;	
			case 0: 
				break;
			default:
				System.out.println("Entrada inválida. \nTente de novo");
				try { 
					TimeUnit.SECONDS.sleep(5);
				}catch (Exception e) {
					System.out.println(e);
				}
			}

		} while (opc != 0);

		return 0;

	}
      
	public int abrirMenuRelatorioPresidente() {

		int opc;

		do {
			System.out.println("-----------Relatórios-------------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente:");
			System.out.println("3.Relatório de Rendimento da Poupança:");
			System.out.println("4.Relatório de Número de Contas da Agência");
			System.out.println("5.Relatórios com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
			System.out.println("6.Relatório com valor total do Capital armazenado no banco");
			System.out.println("0.Sair");
			System.out.println("---------------------");
			opc = sc.nextInt();

			switch(opc) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 5;
			case 6:
				return 6;
			case 0:
				break;

			default:
				System.out.println("Entrada inválida. \nTente de novo");
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		while  (opc != 0);

		return 0;
	}
  }
