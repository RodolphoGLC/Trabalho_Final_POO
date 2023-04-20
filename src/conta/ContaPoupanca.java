package conta;

import java.util.Scanner;

import enums.EnumConta;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(String cpfTitular, double saldo, int agencia, EnumConta tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}
	
	public void relatorioRendimento() {
		double dias;
		double rendimento;
		
		Scanner sc = new Scanner(System.in);
		
		//loop de leitura
		//	Ver o saldo do cliente
		
		//Recebendo a quantidade de dias
		dias = sc.nextDouble();
		dias = Math.floor(dias/30);
		
		//Rendimento mensal
		rendimento = dias * 0.1;
		
		//Escrita em tela do relatorio
		System.out.println("--------------------------------------");
		System.out.println("      Rendimento total      ");
		System.out.println("       R$: " + Math.round(rendimento));
		System.out.println("      Saldo pós rendimentos      ");
		System.out.println("       R$: " + Math.round(this.getSaldo() + rendimento));
		System.out.println("--------------------------------------");
	}
}
