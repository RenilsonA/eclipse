package ClassesArray;

import java.time.LocalDate;

public class Vendas {
	private LocalDate diadaVenda;
	private float Valor;
	private boolean ContabilizarnoRecibo;
	private int id;
	
	public Vendas(LocalDate dia, float venda, boolean CR) {
		this.diadaVenda = dia;
		this.Valor = venda;
		this.ContabilizarnoRecibo = CR;
	}
	
	public LocalDate getDiadaVenda() {
		return diadaVenda;
	}
	public void setDiadaVenda(LocalDate diadaVenda) {
		this.diadaVenda = diadaVenda;
	}
	public float getValor() {
		return Valor;
	}
	public void setValor(float valor) {
		Valor = valor;
	}
	public boolean isContabilizarnoRecibo() {
		return ContabilizarnoRecibo;
	}
	public void setContabilizarnoRecibo(boolean contabilizarnoRecibo) {
		ContabilizarnoRecibo = contabilizarnoRecibo;
	}
	public void setId(int x) {
		this.id = x;
	}
	public int getId() {
		return id;
	}
}
