package conta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import conta.Movimentacao;

public abstract class Conta {
	private String cpfTitular;
	private double saldo;
	private int agencia;
	
	public Conta(String cpfTitular, double saldo, int agencia) {
		super();
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
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
		
		FileWriter arq;
		try {
			arq = new FileWriter("user.dir\\src\\dados\\movimentacoes.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
		    gravarArq.printf(movimentacao.toString());
		    gravarArq.close();
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
		
		FileWriter arq;
		try {
			arq = new FileWriter("user.dir\\src\\dados\\movimentacoes.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
		    gravarArq.printf(movimentacao.toString());
		    gravarArq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void transferencia(Conta contaDestino, double valor){
		if(this.saldo > valor && valor > 0){
			System.out.println("Transferência concluída!");
				this.saldo =- valor;
				contaDestino.saldo =+ valor;
			System.out.println("Seu saldo atual é de: " + this.saldo);
		}
		else {
			System.out.println("Saldo insuficiente");
		}
	
		Movimentacao movimentacao = new Movimentacao(cpfTitular, "Transferiu: R$ ", valor);
		
		FileWriter arq;
		try {
			arq = new FileWriter("user.dir\\src\\dados\\movimentacoes.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
		    gravarArq.printf(movimentacao.toStringTransferencia(contaDestino));
		    gravarArq.close();
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
	
<<<<<<< HEAD
=======
	public void transferencia(Conta contaDestino, double valor){
		if(this.saldo > valor && valor > 0) {
			System.out.println("Transferência concluída!");
			this.saldo =- valor;
			contaDestino.saldo =+ valor;
			System.out.println("Seu saldo atual é de: " + this.saldo);
		}
		else {
			System.out.println("Saldo insuficiente");
		}
	
	
	}
	public void extratoConta() {
		//Instanciar!!
	}
>>>>>>> 641e4c9735cdee75c4ce35e6f081ddb9cdc38183
}
