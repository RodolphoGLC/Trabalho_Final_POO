package funcionario;

import enums.EnumUsuario;

public abstract class Funcionario {
	private String cpf;
	private String senha;
	private EnumUsuario cargo; //Enum
	
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
	public double getSaldo(double saldo) {
		return saldo;
	}
	public EnumUsuario getCargo() {
		return cargo;
	}
	public void setCargo(EnumUsuario cargo) {
		this.cargo = cargo;
	}
	
}

