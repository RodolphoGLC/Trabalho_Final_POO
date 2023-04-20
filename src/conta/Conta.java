package conta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import conta.Movimentacao;
import dados.Leitor;
import enums.EnumConta;

public abstract class Conta {
	private String cpfTitular;
	private double saldo;
	private int agencia;
	private EnumConta tipo;
	
	public Conta() {
		
	}
	
	public Conta(String cpfTitular, double saldo, int agencia, EnumConta tipo2) {
		super();
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
	}
	
	public EnumConta getTipo() {
		return tipo;
	}

	public void setTipo(EnumConta tipo) {
		this.tipo = tipo;
	}
	
	public void sacar(double valor) {
		if (valor > this.saldo) {
			//Caso tiver que escrever a tentativa de saque com saldo insuficiente terá que modificar
			System.out.println("Saque indisponível, valor insuficiente!");
		} else {
			this.saldo -= valor;
			System.out.println("Saque efetuado com sucesso!");
		}
		
		Movimentacao movimentacao = new Movimentacao(cpfTitular, "Saque: R$ ", valor);
		String path = "src/dados/movimentacoes.txt";
		try {
			List<String> linhas = lerMovimentacao(path);
			linhas.add(movimentacao.toString());
			escreverMovimentacao(path, linhas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Depósito efetuado com sucesso!");
		} else {
			//Caso tiver que escrever a tentativa de saque com saldo insuficiente terá que modificar
			System.out.println("Valor inválido!");
		}
		
		Movimentacao movimentacao = new Movimentacao(cpfTitular, "Deposito: R$ ", valor);
		String path = "src/dados/movimentacoes.txt";
		try {
			List<String> linhas = lerMovimentacao(path);
			linhas.add(movimentacao.toString());
			escreverMovimentacao(path, linhas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void transferencia(Conta contaDestino, double valor){
		if(this.saldo > valor && valor > 0){
			System.out.println("Transferência concluída!");
				this.saldo =- valor;
				contaDestino.saldo =+ valor;
		}
		else {
			System.out.println("Saldo insuficiente");
		}
	
		Movimentacao movimentacao = new Movimentacao(cpfTitular, "Transferiu: R$ ", valor);
		String path = "src/dados/movimentacoes.txt";
		try {
			List<String> linhas = lerMovimentacao(path);
			linhas.add(movimentacao.toStringTransferencia(contaDestino));
			escreverMovimentacao(path, linhas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void extratoConta() {
		//Instanciar!!
	}
	
	public String getCpfTitular() {
		return cpfTitular;
	}
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public static List<String> lerMovimentacao(String path) throws IOException {
		List<String> linhas = new ArrayList<>();
		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				linhas.add(linha);
			}
			else
				break;
		}

		leitor.close();
		return linhas;
	}
	
	public static void escreverMovimentacao(String path, List<String> linhas) throws IOException {
		try (FileWriter escritor = new FileWriter(path)) {
			for (String linha : linhas) {
			    escritor.write(linha + "\n");
			}
		}
	}
}
