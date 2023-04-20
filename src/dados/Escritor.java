package dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import conta.*;
import conta.Movimentacao;

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
	
	//Metodos para escrever os relatorios em arquivos
	
	public static void relatorioSaldo(Conta conta) throws IOException {
		String inicio = "O seu saldo é de R$ ";
		System.out.println(inicio + conta.getSaldo());
		
		//Fazer o arquivo pela hora ()
		String path = "./src/relatorios/" + Movimentacao.dataRelatorios() + ".txt";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));) {
			buffWrite.write(inicio + conta.getSaldo());
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void relatorioTributacao() {
		
	}
	
	public static void relatorioRendimento() {
		
	}
	
	public static void relatorioNumeroContas() {
		
	}
	
	public static void relatorioInformacoesAlfabeitca() {
		
	}
	
	public static void relatorioCapital() {
		
	}
}
