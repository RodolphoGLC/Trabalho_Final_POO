package conta;

public class ContaCorrente extends Conta {
	private int tipo; //Enum
	
	public ContaCorrente(String cpfTitular, double saldo, int agencia, int tipo) {
		super(cpfTitular, saldo, agencia);
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void relatorioTributacao() {
		int qSaques = 0, qDepositos = 0, qTransferencia = 0;
		double tributacaoTotal;
		
		//loop de leitura
		//	Ver quantas de cada transacao e armazenar na variavel
		
		//Fazer as contas com base nas taxas e nas quantidades
		tributacaoTotal = (qSaques * 0.1) + (qDepositos * 0.1) + (qTransferencia * 0.2);
		
		//Escrita em tela do relatorio
		System.out.println("--------------------------------------");
		System.out.println("      Valor total das transações      ");
		System.out.println("       R$: " + Math.round(tributacaoTotal));
		System.out.println("--------------------------------------");
	}
}
