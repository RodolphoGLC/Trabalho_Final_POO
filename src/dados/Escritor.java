package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import conta.*;

public class Escritor {
	
	public static void escreverMovimentacao(String path, List<String> linhas) throws IOException {
		try (FileWriter escritor = new FileWriter(path)) {
			for (String linha : linhas) {
			    escritor.write(linha + "\n");
			}
		}
	}
	
	//Metodos para escrever os relatorios em arquivos
	public static void escreverRelatorio(String texto, String pasta) throws IOException {
		
		//Fazer o arquivo pela hora ()
		String path = "./src/relatorios/" + pasta + Movimentacao.dataRelatorios() + ".txt";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));) {
			buffWrite.write(texto);
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void relatorioSaldo(Conta conta) throws IOException {
		String textoRelatorio = "O seu saldo é de R$ " + conta.getSaldo();
		System.out.println(textoRelatorio);
		
		escreverRelatorio(textoRelatorio, "RS_");
	}
	
	public static void relatorioTributacao(ContaCorrente conta) throws IOException {
		int qSaquesDepositos = conta.getQtdSaqueDeposito(), qTransferencia = conta.getQtdTransferencia();
		double tributacaoTotal;
		String textoTributacao= "";
		DecimalFormat df = new DecimalFormat("0.00");
		//loop de leitura
		//	Ver quantas de cada transacao e armazenar na variavel
		
		//Fazer as contas com base nas taxas e nas quantidades
		tributacaoTotal = (qSaquesDepositos * 0.1) + (qTransferencia * 0.2);
		
		//Retornando String para usar na classe Escritor
		textoTributacao = "--------------------------------------\n" + 
						  "1.Valor total das transações R$ " + df.format(tributacaoTotal) + "\n\n" +
						  "2.Para cada saque será cobrado o valor de R$0.10\n" +
						  "3.Para cada depósito será cobrado o valor de R$0.10\n"+
						  "4.Para cada transferência será cobrado o valor de R$0.20\n"+
						  "--------------------------------------";
		System.out.println(textoTributacao);
		escreverRelatorio(textoTributacao, "T_");
	}
	
	public static void relatorioRendimento() {
		
	}
	
	public static void relatorioNumeroContas(Integer idAgencia) throws IOException {
		String path = "./src/dados/conta.txt";
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		int contas = 0;
		
		while(true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(",");
				if(Integer.parseInt(dados[3]) == idAgencia) {
					contas++;
				}
			}
			else {
				break;
			}
		}	
		
		String texto = "O numero de contas desta agencia é de " + contas;
		System.out.println(texto);	
		escreverRelatorio(texto, "NC_");
	}
	
	public static void relatorioInformacoesAlfabeitca() {
		
	}
	
	public static void relatorioCapital() {
	
	}
	
	public static void salvarContas(String path, Map<String,Conta> listaConta) throws IOException {
		
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
		
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
