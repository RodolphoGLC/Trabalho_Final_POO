package conta;

import java.util.Scanner;

import enums.EnumConta;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(String cpfTitular, double saldo, int agencia, EnumConta tipo) {
		super(cpfTitular, saldo, agencia, tipo);
	}
	
	/*Passei o metodo para 
	public String relatorioRendimento() {
		double dias;
		double rendimento;
		String textoRendimento = "";
		
		Scanner sc = new Scanner(System.in);
		
		//loop de leitura
		//	Ver o saldo do cliente
		
		//Recebendo a quantidade de dias
		dias = sc.nextDouble();
		dias = Math.floor(dias/30);
		
		//Rendimento mensal
		rendimento = dias * 0.1;
		
		//Escrita em tela do relatorio
		textoRendimento = "--------------------------------------\n" +
						  "      Rendimento total      \n" +
				          "       R$: " + Math.round(rendimento)+"\n" +
				          "      Saldo pós rendimentos      \n" +
				          "       R$: " + Math.round(this.getSaldo() + rendimento)+"\n" +
				          "--------------------------------------\n";
		return textoRendimento;
		}*/
}
