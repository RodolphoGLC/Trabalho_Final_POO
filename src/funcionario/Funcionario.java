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
	public enum FuncionariosEnum {
		Funcionario,
		Gerente,
		Diretor,
		Presidente;
	}
	public double getSaldo(double saldo) {
		return saldo;
	}
}

