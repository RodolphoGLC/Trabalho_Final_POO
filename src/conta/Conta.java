package conta;

import java.io.IOException;
import java.util.List;

import dados.Escritor;
import dados.Leitor;
import enums.EnumConta;

public abstract class Conta {
	private String cpfTitular;
	private double saldo;
	private int agencia;
	private EnumConta tipo;
	private int qtdSaqueDeposito;
	private int qtdTransferencia;
	private String sv;
	private double tributoSeguro;
	
	
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
	
	public int getQtdSaqueDeposito() {
		return qtdSaqueDeposito;
	}

	public void setQtdSaqueDeposito(int qtdSaqueDeposito) {
		this.qtdSaqueDeposito = qtdSaqueDeposito;
	}

	public int getQtdTransferencia() {
		return qtdTransferencia;
	}

	public void setQtdTransferencia(int qtdTransferencia) {
		this.qtdTransferencia = qtdTransferencia;
	}
	
	public String getSv() {
		return sv;
	}
	public void setSv(String sv) {
		this.sv = sv;
	}
	public double getTributoSeguro() {
		return tributoSeguro;
	}
	public void setTributoSeguro(double tributoSeguro) {
		this.tributoSeguro = tributoSeguro;
	}
	
	public void sacar(double valor) {
		if (valor > this.saldo) {
			//Caso tiver que escrever a tentativa de saque com saldo insuficiente terá que modificar
			System.out.println("Saque indisponível, valor insuficiente!");
		} else {
			this.saldo -= valor;
			System.out.println("Saque efetuado com sucesso!");
			
			//gravando no arquivo de movimentacao
			Movimentacao movimentacao = new Movimentacao(cpfTitular, "Saque: R$ ", valor);
			String path = "src/dados/movimentacoes.txt";
			try {
				List<String> linhas = Leitor.lerMovimentacao(path);
				linhas.add(movimentacao.toString());
				Escritor.escreverMovimentacao(path, linhas);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//registrando na variavel de qtd saque deposito
			this.qtdSaqueDeposito ++;
		}
	}
	
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Depósito efetuado com sucesso!");
			
			//gravando no arquivo de movimentacao
			Movimentacao movimentacao = new Movimentacao(cpfTitular, "Deposito: R$ ", valor);
			String path = "src/dados/movimentacoes.txt";
			try {
				List<String> linhas = Leitor.lerMovimentacao(path);
				linhas.add(movimentacao.toString());
				Escritor.escreverMovimentacao(path, linhas);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//registrando na variavel de qtd saque deposito
			this.qtdSaqueDeposito ++;
		} else {
			//Caso tiver que escrever a tentativa de saque com saldo insuficiente terá que modificar
			System.out.println("Valor inválido!");
		}
	}
	
	public void transferir (Conta contaDestino, double valor){
		if(this.saldo > valor && valor > 0){
			System.out.println("Transferência concluída!");
			this.saldo -= valor;
			contaDestino.saldo += valor;
			
			//gravando no arquivo de movimentacao
			Movimentacao movimentacao = new Movimentacao(cpfTitular, "Transferiu: R$ ", valor);
			String path = "src/dados/movimentacoes.txt";
			try {
				List<String> linhas = Leitor.lerMovimentacao(path);
				linhas.add(movimentacao.toStringTransferencia(contaDestino));
				Escritor.escreverMovimentacao(path, linhas);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//registrando na variavel qtd transferencia
			this.qtdTransferencia ++;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	public void extratoConta() {
		//Instanciar!!
	}

}
