package funcionario;

public abstract class Funcionario {
	private String cpf;
	private String senha;
	private int cargo; //Enum
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
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	
}
