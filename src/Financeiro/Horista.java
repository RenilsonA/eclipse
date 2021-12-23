package Financeiro;

import java.time.LocalDate;

public class Horista {
	private int ID;
	private String nome;
	private float horas = 0;
	private float horasExtras = 0;
	private float bonus;
	private float descontos;
	private boolean sindicato;
	private float discExtra;
	private float Alicota;
	private float SalarioHora;
	private LocalDate pagamento;
	private int grupo;

	public Horista(int id, String Nome, float V, float VE, float B, float Desc, boolean Sin, float discEx, float Al, float SH, LocalDate pag, int grup) {
		this.ID = id;
		this.nome = Nome;
		this.horas = V;
		this.horasExtras = VE;
		this.bonus = B;
		this.descontos = Desc;
		this.sindicato = Sin;
		this.discExtra = discEx;
		this.Alicota = Al;
		this.SalarioHora = SH;
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
	public float getHoras() {
		return horas;
	}
	public void setHoras(float horas) {
		this.horas = horas + getHoras();
	}
	public float getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(float horasExtras) {
		this.horasExtras = horasExtras*1.5F + getHorasExtras();
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
	public float getSalarioHora() {
		return SalarioHora;
	}
	public void setSalarioHora(float salarioHora) {
		SalarioHora = salarioHora;
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
