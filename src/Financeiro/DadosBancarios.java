package Financeiro;

public class DadosBancarios {
	private int id;
	private String nome;
	private String banco;
	private int agencia;
	private int operacao;
	private int conta;
	
	public DadosBancarios(int id, String nome, String banco, int agencia, int operacao, int conta) {
		this.id = id;
		this.nome = nome;
		this.banco = banco;
		this.agencia = agencia;
		this.operacao = operacao;
		this.conta = conta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getOperacao() {
		return operacao;
	}
	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
}
