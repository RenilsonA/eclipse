package ClassesArray;

import Geral.Tempo;

public class Recibos {
	private int ID;
	private String Nome;
	private float salario;
	private float extra;
	private float descontos;
	private float taxas;
	private float liquido;
	private String CEP;
	private String Endereco;
	private int numeroCasa;
	private String banco;
	private int agencia;
	private int operacao;
	private String conta;
	private String presenca;
	
	public Recibos(int ID, String nome, float a, float b, float c, float d, float e, String cep, String end, int nC, String bank, int ag, int op,
				   String cont, int x, int y, float pres, float presExtra) {
		Tempo t = new Tempo();
		this.ID = ID;
		this.Nome = nome;
		this.salario = a;
		this.extra = b;
		this.descontos = c;
		this.taxas = d;
		this.liquido = e;
		if(x == 0) {
			this.CEP = cep;
			this.Endereco = end;
			this.numeroCasa = nC;
		} else if (x == 1) {
			this.banco = bank;
			this.agencia = ag;
			this.operacao = op;
			this.conta = cont;
		}
		if(y == 0) 
			this.presenca = Float.toString(pres) + "/" + Integer.toString(t.DiasUteisnoMes());
		else if(y == 1)
			this.presenca = Float.toString(pres) + " Horas + " + Float.toString(presExtra) + " Horas extras";
		else 
			this.presenca = Float.toString(pres) + "/" + Integer.toString(t.DiasUteisnoMes()/2);
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	public int getID() {
		return ID;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getExtra() {
		return extra;
	}
	public void setExtra(float extra) {
		this.extra = extra;
	}
	public float getDescontos() {
		return descontos;
	}
	public void setDescontos(float descontos) {
		this.descontos = descontos;
	}
	public float getTaxas() {
		return taxas;
	}
	public void setTaxas(float taxas) {
		this.taxas = taxas;
	}
	public float getLiquido() {
		return liquido;
	}
	public void setLiquido(float liquido) {
		this.liquido = liquido;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
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
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getPresenca() {
		return presenca;
	}
	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}
}
