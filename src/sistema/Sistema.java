package sistema;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;
import dados.Leitor;
import funcionario.Presidente;
import interface_usuario.InterfaceUsuario;


public class Sistema {
	public static void main(String[] args) {
		
		List<Presidente> listaPresidente = new ArrayList<>();
		String pathDados = System.getProperty("user.dir") + "\\src\\dados\\";
		
		try {
			Leitor.lerPresidente(pathDados + "presidente.txt", listaPresidente);
		} catch (Exception e) {
			System.out.println(e);
		}
		

//		teste para ver se realmente carregou os clientes
//		for(Cliente c : listaCliente) {
//			System.out.println(c.getCpf());
//		}
		
		InterfaceUsuario iu = new InterfaceUsuario();
		
		String tipoUsuario = iu.logar();
		
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
  }
}
