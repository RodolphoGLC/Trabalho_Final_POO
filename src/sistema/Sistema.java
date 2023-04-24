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
import conta.ContaPoupanca;
import dados.Escritor;
import dados.Leitor;
import enums.EnumConta;
import enums.EnumUsuario;
import funcionario.Funcionario;
import menus.Menu;


public class Sistema {
	public static void main(String[] args) throws IOException, InterruptedException {

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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----Login-----");
		System.out.println("Cpf:");
		cpf = sc.next();
		System.out.println("Senha:");
		senha = sc.next();
		
		for(Cliente c : listaCliente) {
			if(c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
				tipoUsuario = EnumUsuario.CLIENTE;
			}
		}
		
		for(Funcionario f : listaFuncionario) {
			if(f.getCpf().equals(cpf) && f.getSenha().equals(senha)) {
				tipoUsuario = f.getCargo();
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
						//movimentacao cliente
						opcMenu = menu.abrirMenuClienteMovimentacao();
						switch(opcMenu) {
						case 1: 
							Escritor.espacamentoAntes();
							valor = menu.lerValor("sacado");
							conta.sacar(valor);
							Escritor.espacamentoDepois();
							break;
						case 2: 
							Escritor.espacamentoAntes();
							valor = menu.lerValor("depositado");
							conta.depositar(valor);
							Escritor.espacamentoDepois();
							break;
						case 3: 
							Escritor.espacamentoAntes();
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
							    valor = menu.lerValor("transferido");
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							Escritor.espacamentoDepois();
							break;
						case 4: 
							System.out.println("Extrato");
							conta.extratoConta();
							break;
						case 5:
							System.out.println("Seguro de Vida");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.seguroVidaContratar(conta);
							} else {
								System.out.println("Esta conta não é uma conta corrente");
							}
							break;
						}
						Escritor.salvarContas(pathDados + "conta.txt", listaConta);
						
					} else if(opcMenu == 2) {
						//relatorios cliente
						opcMenu = menu.abrirMenuClienteRelatorios();
						switch(opcMenu) {
						case 1: 
							System.out.println("Saldo");
							Escritor.relatorioSaldo(conta);
							break;
						case 2: 
							System.out.println("Relatório tributação");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.relatorioTributacao((ContaCorrente)conta);
							} else {
								System.out.println("Esta conta não é uma conta corrente");
							}
							break;
						case 3: 
							System.out.println("Relatório rendimento");
							if(conta.getTipo() == EnumConta.CONTAPOUPANCA){
								Escritor.relatorioRendimento((ContaPoupanca)conta);
							} else {
								System.out.println("Esta conta não é uma conta poupança");
							}
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
							Escritor.espacamentoAntes();
							valor = menu.lerValor("sacado");
							conta.sacar(valor);
							Escritor.espacamentoDepois();
							break;
						case 2: 
							Escritor.espacamentoAntes();
							valor = menu.lerValor("depositado");
							conta.depositar(valor);
							Escritor.espacamentoDepois();
							break;
						case 3: 
							Escritor.espacamentoAntes();
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
							    valor = menu.lerValor("transferido");
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							Escritor.espacamentoDepois();
						case 4: 
							System.out.println("Extrato");
							conta.extratoConta();
							break;
						case 5:
							System.out.println("Seguro de Vida");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.seguroVidaContratar(conta);
							} else {
								System.out.println("Esta conta não é uma conta corrente");
							}
							break;
						}
						Escritor.salvarContas(pathDados + "conta.txt", listaConta);
						
					} else if(opcMenu == 2) {
						//relatorios gerente
						opcMenu = menu.abrirMenuGerenteRelatorios();
						switch(opcMenu) {
						case 1:
							Escritor.relatorioSaldo(conta);
							break;
						case 2: 
							System.out.println("Relatório tributação");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.relatorioTributacao((ContaCorrente)conta);
							}
							else {
								System.out.println("Esta conta não é uma conta corrente");
							}
							break;
						
						case 3: 
							System.out.println("Relatório rendimento");
							if(conta.getTipo() == EnumConta.CONTAPOUPANCA){
								Escritor.relatorioRendimento((ContaPoupanca)conta);
							}
							else {
								System.out.println("Esta conta não é uma conta poupança");
							}
							break;
						case 4:
							System.out.println("Relatório no número de contas");
							Escritor.relatorioNumeroContas(conta.getAgencia());
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
							Escritor.espacamentoAntes();
							valor = menu.lerValor("sacado");
							conta.sacar(valor);
							Escritor.espacamentoDepois();
							break;
						case 2:
							Escritor.espacamentoAntes();
							valor = menu.lerValor("depositado");
							conta.depositar(valor);
							Escritor.espacamentoDepois();
							break;
						case 3:
							Escritor.espacamentoAntes();
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
							    valor = menu.lerValor("transferido");
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							Escritor.espacamentoDepois();
							break;
						case 4:
							conta.extratoConta();
							break;
						case 5:
							System.out.println("Seguro de Vida");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.seguroVidaContratar(conta);
							} else {
								System.out.println("Esta conta não é uma conta corrente");
							}
							break;
						}
						Escritor.salvarContas(pathDados + "conta.txt", listaConta);

					} else if (opcMenu == 2) {
						opcMenu = menu.abrirMenuDiretorRelatorio();

						switch (opcMenu) {
						case 1:
							System.out.println("Saldo");
							Escritor.relatorioSaldo(conta);
							break;
						case 2:
							System.out.println("Relatório tributação");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.relatorioTributacao((ContaCorrente)conta);
							}
							else {
								System.out.println("Esta conta não é uma conta corrente");
							}
							break;
						case 3:
							System.out.println("Relatório rendimento");
							if(conta.getTipo() == EnumConta.CONTAPOUPANCA){
								Escritor.relatorioRendimento((ContaPoupanca)conta);
							}
							else {
								System.out.println("Esta conta não é uma conta poupança");
							}
							break;
						case 4:
							System.out.println("Relatório no números de contas");
							Escritor.relatorioNumeroContas(conta.getAgencia());
							break;
						case 5:
							Escritor.relatorioInformacoesAlfabetica(listaCliente, listaConta);
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
							Escritor.espacamentoAntes();
							valor = menu.lerValor("sacado");
							conta.sacar(valor);
							Escritor.espacamentoDepois();
							break;
						case 2:
							Escritor.espacamentoAntes();
							valor = menu.lerValor("depositado");
							conta.depositar(valor);
							Escritor.espacamentoDepois();
							break;
						case 3:
							Escritor.espacamentoAntes();
							System.out.println("Informe o CPF da conta da qual a transferência será realizada: ");
							String CPFTransferencia = sc.next();
							Conta contaTransferencia = listaConta.get(CPFTransferencia);
							if(contaTransferencia != null) {
							    valor = menu.lerValor("transferido");
								conta.transferir(contaTransferencia, valor);
							}else {
								System.out.println("Conta não encontrada.");
							}
							Escritor.espacamentoDepois();
							break;
						case 4: 
							conta.extratoConta();
							break;
						case 5:
							Escritor.espacamentoAntes();
							System.out.println("Seguro de Vida \n");
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.seguroVidaContratar(conta);
							} else {
								System.out.println("Esta conta não é uma conta corrente");
							}
							Escritor.espacamentoDepois();
							break;
						}
						Escritor.salvarContas(pathDados + "conta.txt", listaConta);	

					} else if (opcMenu == 2) {
						opcMenu = menu.abrirMenuRelatorioPresidente();
						switch (opcMenu) {
						case 1:
							System.out.println("Saldo");
							Escritor.relatorioSaldo(conta);
							break;
						case 2:
							System.out.println("Relatório de Tributação");
							
							if(conta.getTipo() == EnumConta.CONTACORRENTE){
								Escritor.relatorioTributacao((ContaCorrente)conta);
							}
							else {
								System.out.println("Esta conta não é uma conta corrente");
							break;
							}
						case 3:
							System.out.println("Relatório de Rendimento");
							if(conta.getTipo() == EnumConta.CONTAPOUPANCA){
								Escritor.relatorioRendimento((ContaPoupanca)conta);
							}
							else {
								System.out.println("Esta conta não é uma conta poupança");
							}
							break;
						case 4:
							System.out.println("Relatório no números de contas");
							Escritor.relatorioNumeroContas(conta.getAgencia());
							break;
						case 5:
							Escritor.relatorioInformacoesAlfabetica(listaCliente, listaConta);
							break; 
						case 6:
							Escritor.relatorioCapital(listaConta);
							
						}
					}
				}while(opcMenu != 0);
					
				break;
			case INVALIDO:
				System.out.println("Senha ou usuário inválido.");
		}
		
		//para salvar a lista de conta atualizada no arquivo conta.txt
		try {
			Escritor.salvarContas(pathDados + "conta.txt", listaConta);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
