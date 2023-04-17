package conta;

import java.util.Scanner;

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
