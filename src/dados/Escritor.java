package dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escritor {

	public static void escrever(String path) throws IOException {
		
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
		String linha = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nova linha (digite 'sair' para fechar): ");
		while(!linha.equals("sair")) {
			linha = sc.nextLine();
			if(!linha.equals("sair"))
				escritor.append(linha + "\n");
		}
		escritor.close();
		sc.close();
	}
}
