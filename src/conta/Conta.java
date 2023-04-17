package conta;

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
	}
	
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Depósito efetuado com sucesso!");
		} else {
			//Caso tiver que escrever a tentativa de saque com saldo insuficiente terá que modificar
			System.out.println("Valor inválido!");
		}
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
	
	
}
