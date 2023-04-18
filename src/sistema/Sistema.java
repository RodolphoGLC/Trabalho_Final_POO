package sistema;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;
import dados.Leitor;
import funcionario.Presidente;
import interface_usuario.InterfaceUsuario;


public class Sistema {
	public static void main(String[] args) {
		
		List<Presidente> listaPresidente = new ArrayList<>();
		String pathDados = System.getProperty("user.dir") + "\\src\\dados\\";
		
		try {
			Leitor.lerPresidente(pathDados + "presidente.txt", listaPresidente);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//teste para ver se realmente carregou o Presidente
		for(Presidente p : listaPresidente) {
			System.out.println(p.getCpf());
		}
		
		
	}

}
