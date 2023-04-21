package menus;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
	
	private Scanner sc;

	public Menu() {
		sc = new Scanner(System.in);
	}
	
	public int abrirMenu() {
		
		String opcEntrada;
		int opc;
		
		do {
			System.out.println("-----Menu------");
			System.out.println("1.Movimentação na Conta");
			System.out.println("2.Relatórios");
			System.out.println("0.Sair");
			System.out.println("-----------------------");
			System.out.println("Digite o numero da sua escolha: ");
			
			opcEntrada = sc.next();
			try {
				//para evitar erro se o usuario entrar com algo que não seja int
				opc = Integer.parseInt(opcEntrada);
			} catch(Exception e) {
				opc = 99;
			}
			
			if(opc < 0 && opc > 2) {
				System.out.println("Entrada inválida. \nTente de novo.");
				try {
					//para esperar 5s para usuário ler mensagem
					//exige try catch
					TimeUnit.SECONDS.sleep(3);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} while(opc < 0 && opc > 2);
		
		return opc;
	}
	
	public int abrirMenuClienteMovimentacao() {
		
		String opcEntrada;
		int opc;
		
		do {
			System.out.println("-----Movimentação na Conta------");
			System.out.println("1.Saque");
			System.out.println("2.Depósito");
			System.out.println("3.Transferência para outra conta");
			System.out.println("4.Extrato da Conta");
			System.out.println("5.Voltar");
			System.out.println("--------------------------------");
			System.out.println("Digite o numero da sua escolha: ");
			
			opcEntrada = sc.next();
			try {
				//para evitar erro se o usuario entrar com algo que não seja int
				opc = Integer.parseInt(opcEntrada);
			} catch(Exception e) {
				opc = 99;
			}
			
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
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(3);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 5);
		
		return 5;
	}
	
	public int abrirMenuClienteRelatorios() {
		
		String opcEntrada;
		int opc;
		
		do {
			System.out.println("-----Relatórios------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente");
			System.out.println("3.Relatório de Rendimento da Poupança");
			System.out.println("4.Voltar");
			System.out.println("---------------------");
			System.out.println("Digite o numero da sua escolha: ");
			
			opcEntrada = sc.next();
			try {
				//para evitar erro se o usuario entrar com algo que não seja int
				opc = Integer.parseInt(opcEntrada);
			} catch(Exception e) {
				opc = 99;
			}
			
			switch(opc) {
				case 1:
					return 1;
				case 2: 
					return 2;
				case 3:
					return 3;
				case 4:
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(3);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 4);
		
		return 4;
	}
	
	public int abrirMenuFuncionarioMovimentacao() {

		String opcEntrada;
		int opc;
		
		do {
			System.out.println("-----Movimentações na Conta------");
			System.out.println("1.Saque");
			System.out.println("2.Depósito");
			System.out.println("3.Transferência para outra conta");
			System.out.println("4.Extrato da Conta");
			System.out.println("5.Voltar");
			System.out.println("--------------------------------");
			System.out.println("Digite o numero da sua escolha: ");

			opcEntrada = sc.next();
			try {
				//para evitar erro se o usuario entrar com algo que não seja int
				opc = Integer.parseInt(opcEntrada);
			} catch(Exception e) {
				opc = 99;
			}
			
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
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(3);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 5);
		
		return 5;
	}
	
	public int abrirMenuGerenteRelatorios() {

		String opcEntrada;
		int opc;
		
		do {
			System.out.println("-----Relatórios------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente");
			System.out.println("3.Relatório de Rendimento da Poupança");
			System.out.println("4.Relatório de Número de Contas na Agência");
			System.out.println("5.Voltar");
			System.out.println("---------------------");
			System.out.println("Digite o numero da sua escolha: ");

			opcEntrada = sc.next();
			try {
				//para evitar erro se o usuario entrar com algo que não seja int
				opc = Integer.parseInt(opcEntrada);
			} catch(Exception e) {
				opc = 99;
			}
			
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
					break;
				default: 
					System.out.println("Entrada inválida. \nTente de novo.");
					try {
						//para esperar 5s para usuário ler mensagem
						//exige try catch
						TimeUnit.SECONDS.sleep(3);
					} catch (Exception e) {
						System.out.println(e);
					}
			}
			
		} while(opc != 5);
		
		return 5;
	}
		

	public int abrirMenuDiretorRelatorio() {

		String opcEntrada;
		int opc;

		do {
			System.out.println("-----Relatórios------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente:");
			System.out.println("3.Relatório de Rendimento da Poupança:");
			System.out.println("4.Relatório de Número de Contas da Agência");
			System.out.println("5.Relatórios com as informações de Nome e CPF");
			System.out.println("6.Voltar");
			System.out.println("---------------------");

			opcEntrada = sc.next();
			try {
				//para evitar erro se o usuario entrar com algo que não seja int
				opc = Integer.parseInt(opcEntrada);
			} catch(Exception e) {
				opc = 99;
			}

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
				break;
			default:
				System.out.println("Entrada inválida. \nTente de novo");
				try { 
					TimeUnit.SECONDS.sleep(3);
				}catch (Exception e) {
					System.out.println(e);
				}
			}

		} while (opc != 6);

		return 6;

	}
      
	public int abrirMenuRelatorioPresidente() {

		String opcEntrada;
		int opc;

		do {
			System.out.println("-----------Relatórios-------------");
			System.out.println("1.Saldo");
			System.out.println("2.Relatório de Tributação da Conta Corrente:");
			System.out.println("3.Relatório de Rendimento da Poupança:");
			System.out.println("4.Relatório de Número de Contas da Agência");
			System.out.println("5.Relatórios com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
			System.out.println("6.Relatório com valor total do Capital armazenado no banco");
			System.out.println("7.Voltar");
			System.out.println("---------------------");

			opcEntrada = sc.next();
			try {
				//para evitar erro se o usuario entrar com algo que não seja int
				opc = Integer.parseInt(opcEntrada);
			} catch(Exception e) {
				opc = 99;
			}

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
			case 7:
				break;

			default:
				System.out.println("Entrada inválida. \nTente de novo");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		while  (opc != 7);

		return 7;
	}
  }
