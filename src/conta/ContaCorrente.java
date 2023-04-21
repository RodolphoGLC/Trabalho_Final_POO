package conta;

import enums.EnumConta;

public class ContaCorrente extends Conta {
	
	
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String cpfTitular, double saldo, int agencia, EnumConta tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}
	
	/*Passei para o Escritor
	public String relatorioTributacao() {
		int qSaquesDepositos = this.getQtdSaqueDeposito(), qTransferencia = this.getQtdTransferencia();
		double tributacaoTotal;
		String textoTributacao= "";
		
		//loop de leitura
		//	Ver quantas de cada transacao e armazenar na variavel
		
		//Fazer as contas com base nas taxas e nas quantidades
		tributacaoTotal = (qSaquesDepositos * 0.1) + (qTransferencia * 0.2);
		
		//Retornando String para usar na classe Escritor
		textoTributacao = "--------------------------------------\n" + 
						  "      1.Valor total das transações     \n" +
				          "       R$: " + Math.round(tributacaoTotal) +"\n" +
						  "2.Para cada saque será cobrado o valor de R$0.10\n" +
						  "3.Para cada depósito será cobrado o valor de R$0.10\n"+
						  "4.Para cada transferência será cobrado o valor de R$0.20\n"+
						  "--------------------------------------";
		return textoTributacao;
	}*/
}
