package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cliente.Cliente;

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
}
