package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
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
		
		tributacaoTotal = (qSaquesDepositos * 0.1) + (qTransferencia * 0.2);
		
		textoTributacao = "--------------------------------------\n" + 
						  "1.Valor total das transações R$ " + df.format(tributacaoTotal) + "\n\n" +
						  "2.Para cada saque será cobrado o valor de R$0.10\n" +
						  "3.Para cada depósito será cobrado o valor de R$0.10\n"+
						  "4.Para cada transferência será cobrado o valor de R$0.20\n"+
						  "--------------------------------------";
		System.out.println(textoTributacao);
		 escreverRelatorio(textoTributacao,"RT_");
	}
	
	public static void relatorioRendimento(ContaPoupanca conta) throws IOException {
		double dias, rendimento;
		String textoRendimento = "";
		DecimalFormat df = new DecimalFormat("0.00");
		
		Scanner sc = new Scanner(System.in);

		dias = sc.nextDouble();
		dias = Math.floor(dias/30);
		
		rendimento = dias * 0.1;
		
		textoRendimento = "--------------------------------------\n" +
						  "  Rendimento total      \n" +
				          "    R$: " + df.format(rendimento)+"\n" +
				          "  Saldo pós rendimentos      \n" +
				          "    R$: " + df.format(conta.getSaldo() + rendimento)+"\n" +
				          "--------------------------------------\n";
		
		System.out.println(textoRendimento);
		escreverRelatorio(textoRendimento,"RR_");
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
	
	public static void relatorioCapital(Map<String,Conta> listaConta) throws IOException {
		Collection<Conta> contas = listaConta.values(); 
	    double totalSaldo = 0; 
	    for(Conta c : contas) {
	    	totalSaldo += c.getSaldo();
	    	
	    }
	    String textoRelatorio = "O total de capital no Banco é de R$"+ totalSaldo; 
	    System.out.println(textoRelatorio);
	    escreverRelatorio(textoRelatorio, "RC_");
	}
	
	public static void seguroVidaContratar(ContaCorrente conta) {
		Scanner sc = new Scanner(System.in);
		//Verificar se a conta possui seguro vida
		String verificar = conta.getSv();
		int continua = 1;
		
		if(verificar == "sv") {
			continua = 0;
		}
		
		if(continua == 01) {
			System.out.println("Você já possui seguro de vida");
		}
		else {
			System.out.println("Deseja contatar um seguro de vida?\n  1 - Sim\n  2 - Não");
			int seguro = sc.nextInt();
			if(seguro == 1) {
				System.out.println("Qual valor você deseja contratar para seguro");
				double valor = sc.nextDouble();
					if(valor > 0 && conta.getSaldo() > valor*0.2) {
						conta.setSv("SV");
						conta.setTributoSeguro(valor*0.2);
						conta.setSaldo(conta.getSaldo() - (valor*0.2));
						String textoSV = conta.getCpfTitular() + " você criou um seguro de vida";
						System.out.println(textoSV);
						try {
							escreverRelatorio(textoSV,"SV_");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else {
						System.out.println("Não é possivel contratar o seguro de vida");
					}
			}
			else {
				System.out.println("Tudo bem, espero que na próxima vc queira contratar");
			}
		}
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
			escritor.append(Integer.valueOf(c.getQtdTransferencia()).toString() + ",");
			escritor.append(c.getSv() + ",");
			escritor.append(Double.valueOf(c.getTributoSeguro()).toString() + "\n");
		}
		
		escritor.close();
	}
}
