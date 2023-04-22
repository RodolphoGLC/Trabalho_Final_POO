package cliente;

public class Cliente implements Comparable<Cliente>{
	private String cpf;
	private String senha;
	private String nome;
	
	
	public Cliente() {
		
	}

	public Cliente(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Ordenar em ordem alfabetica.
	
	@Override
	public int compareTo(Cliente c) {
		int compare = this.nome.compareTo(c.getNome());
		
		if(compare == 0) {
			compare = this.cpf.compareTo(c.getCpf());
		}
		
		return compare;
	}
}
