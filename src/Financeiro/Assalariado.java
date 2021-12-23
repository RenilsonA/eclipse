package Financeiro;

import java.time.LocalDate;

public class Assalariado {
	private int ID;
	private String nome;
	private float salario;
	private boolean sindicato;
	private float bonus;
	private float descontos;
	private float discExtra;
	private float Alicota;
	private LocalDate pagamento;
	private int grupo;
	
	public Assalariado(int id, String Nome, float V, boolean Sin, float b, float desc, float discEx, float Al, LocalDate pag, int grup) {
		this.ID = id;
		this.nome = Nome;
		this.salario = V;
		this.sindicato = Sin;
		this.bonus = b;
		this.descontos = desc;
		this.discExtra = discEx;
		this.Alicota = Al;
		this.pagamento = pag;
		this.grupo = grup;
	}	
	
	public Assalariado(String Nome, boolean Sin) {
		this.nome = Nome;
		this.sindicato = Sin;
	}	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public boolean isSindicato() {
		return sindicato;
	}
	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getDescontos() {
		return descontos;
	}
	public void setDescontos(float descontos) {
		this.descontos = descontos;
	}
	public float getDiscExtra() {
		return discExtra;
	}
	public void setDiscExtra(float discExtra) {
		this.discExtra = discExtra;
	}
	public float getAlicota() {
		return Alicota;
	}
	public void setAlicota(float alicota) {
		Alicota = alicota;
	}
	public LocalDate getPagamento() {
		return pagamento;
	}
	public void setPagamento(LocalDate pagamento) {
		this.pagamento = pagamento;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
}
