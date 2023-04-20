package conta;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class Movimentacao {
	
	//DecimalFormat valorFormatado = new DecimalFormat("0,00");
	private String cpfCliente;
	private String descricao;
	private String data;
	private double valor;
	private List<String> linhas = new ArrayList<>();
	
	public static String data() {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
		String dataFormatada = data.format(formatada);
		return dataFormatada;
	}
	
	public Movimentacao(String cpfCliente, String descricao, Double valor) {
		this.cpfCliente = cpfCliente;
		this.descricao = descricao;
		this.data = data();
		this.valor = valor;
	}
	
	public String toString() {
		return this.cpfCliente + " - " + this.getDescricao() + valor + " - " + this.getData();
	}
	
	public String toStringTransferencia(Conta contaDestino) {
		return this.cpfCliente + " - " + this.getDescricao() + valor + " - "  + contaDestino.getCpfTitular() + " - " + this.getData();
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getData() {
		return data();
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
