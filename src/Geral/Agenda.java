package Geral;

import java.time.LocalDate;

public class Agenda {
	private String nome;
	private String Dias;
	private LocalDate dia;
	private int intervalo;
	
	public Agenda(String s, LocalDate dia, int Int, String d) {
		this.nome = s;
		this.Dias = d;
		this.dia = dia;
		this.intervalo = Int;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDia() {
		return dia;
	}
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	public int getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	public void setDia(String dia) {
		this.Dias = dia;
	}
	public String getDias() {
		return Dias;
	}
}
