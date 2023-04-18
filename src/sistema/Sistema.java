package sistema;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;
import dados.Leitor;
import interface_usuario.InterfaceUsuario;


public class Sistema {
	public static void main(String[] args) {
		
		//incialização dos funcionarios
		List<Cliente> listaCliente = new ArrayList<>();
		String pathDados = System.getProperty("user.dir") + "\\src\\dados\\";
		
		try {
			Leitor.lerClientes(pathDados + "cliente.txt", listaCliente);
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
				opcMenu = iu.abrirMenuGerenteMovimentacao();
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
						System.out.println("Relatório no numero de contas");
				}
			}
		}
	}

}
