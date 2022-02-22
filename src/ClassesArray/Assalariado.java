package ClassesArray;

import java.time.LocalDate;

public class Assalariado{
	private float salario;
	private float bonus;
	private float descSind;
	private float discExtraReais;
	private float Alicota;
	private LocalDate pagamento;
	private int grupo;
	private int dias;
	
	public Assalariado(float V, float b, float desc, float discEx, float Al, LocalDate pag, int grup, int dia) {
		this.salario = V;
		this.bonus = b;
		this.descSind = desc;
		this.discExtraReais = discEx;
		this.Alicota = Al;
		this.pagamento = pag;
		this.grupo = grup;
		this.dias = dia;
	}	
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getdescSind() {
		return descSind;
	}
	public void setdescSind(float descS) {
		this.descSind = descS;
	}
	public float getDiscExtra() {
		return discExtraReais;
	}
	public void setDiscExtra(float discExtra) {
		this.discExtraReais = discExtra;
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
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
}
