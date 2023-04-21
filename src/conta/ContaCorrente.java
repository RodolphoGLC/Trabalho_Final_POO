package conta;

import enums.EnumConta;

public class ContaCorrente extends Conta {
	
	
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String cpfTitular, double saldo, int agencia, EnumConta tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}
	
	public void relatorioTributacao() {
		int qSaquesDepositos = this.getQtdSaqueDeposito(), qTransferencia = this.getQtdTransferencia();
		double tributacaoTotal;
		
		//loop de leitura
		//	Ver quantas de cada transacao e armazenar na variavel
		
		//Fazer as contas com base nas taxas e nas quantidades
		tributacaoTotal = (qSaquesDepositos * 0.1) + (qTransferencia * 0.2);
		
		//Escrita em tela do relatorio
		System.out.println("--------------------------------------");
		System.out.println("      1.Valor total das transações     ");
		System.out.println("       R$: " + Math.round(tributacaoTotal));
		System.out.println("2.Para cada saque será cobrado o valor de R$0.10");
		System.out.println("3.Para cada depósito será cobrado o valor de R$0.10");
		System.out.println("4.Para cada transferência será cobrado o valor de R$0.20");
		System.out.println("--------------------------------------");
	}
}
