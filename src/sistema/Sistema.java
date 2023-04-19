package sistema;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;
import conta.*;
import dados.Leitor;
import funcionario.Gerente;
import funcionario.Presidente;
import interface_usuario.InterfaceUsuario;


public class Sistema {
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("123", "123");
		Cliente c2 = new Cliente("122", "122");
		Conta cc1 = new ContaCorrente(c1.getCpf(), 5000.0, 10, EnumConta.ContaCorrente);
		Conta cc2 = new ContaCorrente(c2.getCpf(), 5000.0, 10, EnumConta.ContaCorrente);
		
		//cc1.sacar(500.0);
		//cc1.depositar(200.0);
		cc1.transferencia(cc2, 100.0);
		
		/*
		List<Cliente> listaCliente = new ArrayList<>();
		List<Gerente> listaGerente = new ArrayList<>();
		List<Presidente> listaPresidente = new ArrayList<>();
		String pathDados = System.getProperty("user.dir") + "\\src\\dados\\";
		
		try {
			Leitor.lerClientes(pathDados + "cliente.txt", listaCliente);
			Leitor.lerGerente(pathDados + "gerente.txt", listaGerente);
			Leitor.lerPresidente(pathDados + "presidente.txt", listaPresidente);
		} catch (Exception e) {
			System.out.println(e);
		}
	
		InterfaceUsuario iu = new InterfaceUsuario();
		
		String tipoUsuario = iu.logar(listaCliente,listaGerente,listaPresidente);
		
		if(tipoUsuario == "Cliente") {
			
			int opcMenu = iu.abrirMenu();
			if(opcMenu == 1) {
				//movimentacao cliente
				opcMenu = iu.abrirMenuClienteMovimentacao();
				switch(opcMenu) {
					case 1: 
						System.out.println("Saque");
						break;
					case 2: 
						System.out.println("Depósito");
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
		} else if(tipoUsuario == "Gerente") {
			
			int opcMenu = iu.abrirMenu();
			if(opcMenu == 1) {
				//movimentacao gerente
				opcMenu = iu.abrirMenuFuncionarioMovimentacao();
				switch(opcMenu) {
					case 1: 
						System.out.println("Saque");
						break;
					case 2: 
						System.out.println("Depósito");
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
		}else if (tipoUsuario == "Diretor") {
			int opcMenu = iu.abrirMenu ();
			if(opcMenu == 1) {
				opcMenu = iu.abrirMenuFuncionarioMovimentacao (); 
				switch(opcMenu) {
				case 1:
					System.out.println("Saque");
					break;
				case 2:
					System.out.println("Depósito");
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

		} else if (tipoUsuario == "Presidente") {
			int opcMenu = iu.abrirMenu();
		    if (opcMenu == 1) {
		        opcMenu = iu.abrirMenuFuncionarioMovimentacao();
		    	
		    	switch (opcMenu) {
		    	case 1:
		    		System.out.println("Saque");
		    		break;
		    	case 2:
		    		System.out.println("Depósito");
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
		
		
	}
	*/
  }
}
