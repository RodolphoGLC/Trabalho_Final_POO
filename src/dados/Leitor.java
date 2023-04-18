package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import cliente.Cliente;
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
	
	public static void lerPresidente(String path, List<Presidente> listaPresidente) throws IOException {

		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while(true) {
			linha = leitor.readLine();
			
			if(linha != null) {
				List<String> lista = Arrays.asList(linha.split(","));
				
				Presidente p = new Presidente();
				p.setCpf(lista.get(0));
				p.setSenha(lista.get(1));
				listaPresidente.add(p);
			}
			else
				break;
		}

		leitor.close();
	}
	public static void lerGerente(String path, List<Gerente> listaGerente) throws IOException {

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
				listaGerente.add(g);
			}
			else
				break;
		}

		leitor.close();
	}
}
