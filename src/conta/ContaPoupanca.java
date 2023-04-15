package conta;

public class ContaPoupanca extends Conta {
	private int tipo; //Enum
	
	public ContaPoupanca(String cpfTitular, double saldo, int agencia, int tipo) {
		super(cpfTitular, saldo, agencia);
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
