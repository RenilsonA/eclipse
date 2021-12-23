package Financeiro;

import java.time.LocalDate;

public class Comissionado {
	private int ID;
	private String nome;
	private float vendas;
	private float bonus;
	private float descontos;
	private boolean sindicato;
	private float salario;
	private float discExtra;
	private float Alicota;
	private float comissao;
	private LocalDate pagamento;
	private int grupo;
	
	public Comissionado(int id, String Nome, float B, float V, float Desc, boolean Sin, float Sal, float discEx, float Al, float C, LocalDate pag, int grup) {
		this.ID = id;
		this.nome = Nome;
		this.comissao = C;
		this.vendas = V;
		this.bonus = B;
		this.descontos = Desc;
		this.sindicato = Sin;
		this.salario = Sal;
		this.discExtra = discEx;
		this.Alicota = Al;
		this.pagamento = pag;
		this.grupo = grup;
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
	public boolean isSindicato() {
		return sindicato;
	}
	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
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
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
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
	public float getVendas() {
		return vendas;
	}
	public void setVendas(float venda) {
		this.vendas = venda;
	}
}
