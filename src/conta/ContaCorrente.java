package conta;

import enums.EnumConta;

public class ContaCorrente extends Conta {
	
	
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String cpfTitular, double saldo, int agencia, EnumConta tipo) {
		super(cpfTitular, saldo, agencia, tipo);
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
