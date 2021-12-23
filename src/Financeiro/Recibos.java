package Financeiro;

public class Recibos {
	private int ID;
	private String Nome;
	private float salario;
	private float extra;
	private float descontos;
	private float taxas;
	private float liquido;
	
	public Recibos(int ID, String nome, float a, float b, float c, float d, float e) {
		this.ID = ID;
		this.Nome = nome;
		this.salario = a;
		this.extra = b;
		this.descontos = c;
		this.taxas = d;
		this.liquido = e;
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
}
