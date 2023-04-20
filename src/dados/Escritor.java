package dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import conta.Conta;

public class Escritor {

	public static void escrever(String path) throws IOException {
		
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
		String linha = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nova linha (digite 'sair' para fechar): ");
		while(!linha.equals("sair")) {
			linha = sc.nextLine();
			if(!linha.equals("sair"))
				escritor.append(linha + "\n");
		}
		escritor.close();
		sc.close();
	}
	
	public static void salvarContas(String path, Map<String,Conta> listaConta) throws IOException {
		
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
//		while(!linha.equals("sair")) {
//			linha = sc.nextLine();
//			if(!linha.equals("sair"))
//				escritor.append(linha + "\n");
//		}
		
		Collection<Conta> contas = listaConta.values(); 
		
		for(Conta c : contas ) {
			escritor.append(c.getTipo().toString() + ",");
			escritor.append(c.getCpfTitular() + ",");
			escritor.append(Double.valueOf(c.getSaldo()).toString() + ",");
			escritor.append(Integer.valueOf(c.getAgencia()).toString() + ",");
			escritor.append(Integer.valueOf(c.getQtdSaqueDeposito()).toString() + ",");
			escritor.append(Integer.valueOf(c.getQtdTransferencia()).toString() + "\n");
		}
		
		escritor.close();
	}
}
