package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cliente.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.EnumConta;
import enums.EnumUsuario;
import funcionario.Diretor;
import funcionario.Funcionario;
import funcionario.Gerente;
import funcionario.Presidente;

public class Leitor {

	public static void lerClientes(String path, List<Cliente> listaCliente) throws IOException {

		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				List<String> lista = Arrays.asList(linha.split(","));
				
				Cliente c = new Cliente();
				c.setCpf(lista.get(0));
				c.setSenha(lista.get(1));
				listaCliente.add(c);
			}
			else
				break;
		}

		leitor.close();
	}
	
	public static void lerPresidente(String path, List<Funcionario> listaPresidente) throws IOException {

		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				List<String> lista = Arrays.asList(linha.split(","));
				
				Presidente p = new Presidente();
				p.setCpf(lista.get(0));
				p.setSenha(lista.get(1));
				p.setCargo(EnumUsuario.valueOf(lista.get(2)));
				listaPresidente.add(p);
			}
			else
				break;
		}

		leitor.close();
	}
	public static void lerGerente(String path, List<Funcionario> listaGerente) throws IOException {

		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				List<String> lista = Arrays.asList(linha.split(","));
				
				Gerente g = new Gerente();
				g.setCpf(lista.get(0));
				g.setSenha(lista.get(1));
				g.setAgenciaResponsavel(Integer.parseInt(lista.get(2)));
				g.setCargo(EnumUsuario.valueOf(lista.get(3)));
				listaGerente.add(g);
			}
			else
				break;
		}

		leitor.close();
	}
	
	public static void lerDiretor(String path, List<Funcionario> listaDiretor) throws IOException {

		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				List<String> lista = Arrays.asList(linha.split(","));
				
				Diretor d = new Diretor();
				d.setCpf(lista.get(0));
				d.setSenha(lista.get(1));
				d.setAgenciaResponsavel(Integer.parseInt(lista.get(2)));
				d.setCargo(EnumUsuario.valueOf(lista.get(3)));
				listaDiretor.add(d);
			}
			else
				break;
		}

		leitor.close();
	}
	
	public static void lerConta(String path, Map<String,Conta> listaConta) throws IOException {

		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				List<String> lista = Arrays.asList(linha.split(","));
				
				if(lista.get(0).equals("CONTACORRENTE")) {
					ContaCorrente conta = new ContaCorrente();
					conta.setTipo(EnumConta.valueOf(lista.get(0)));
					conta.setCpfTitular(lista.get(1));
					conta.setSaldo(Double.parseDouble(lista.get(2)));
					conta.setAgencia(Integer.parseInt(lista.get(3)));
					conta.setQtdSaqueDeposito(Integer.parseInt(lista.get(4)));
					conta.setQtdTransferencia(Integer.parseInt(lista.get(5)));
					
					
					listaConta.put(conta.getCpfTitular(), conta);
				} else if(lista.get(0).equals("CONTAPOUPANCA")) {
					ContaPoupanca conta = new ContaPoupanca();
					conta.setTipo(EnumConta.valueOf(lista.get(0)));
					conta.setCpfTitular(lista.get(1));
					conta.setSaldo(Double.parseDouble(lista.get(2)));
					conta.setAgencia(Integer.parseInt(lista.get(3)));
					
					listaConta.put(conta.getCpfTitular(), conta);
				}
			}
			else
				break;
		}

		leitor.close();
	}
	
	public static List<String> lerMovimentacao(String path) throws IOException {
		List<String> linhas = new ArrayList<>();
		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				linhas.add(linha);
			}
			else
				break;
		}
		leitor.close();
		return linhas;

	}
}
