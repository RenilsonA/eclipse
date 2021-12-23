package Financeiro;

import java.time.LocalDate;

public class Vendas {
	private int ID;
	private LocalDate diadaVenda;
	private float Valor;
	
	public Vendas(int id, LocalDate dia, float venda) {
		this.ID = id;
		this.diadaVenda = dia;
		this.Valor = venda;
	}
	
	public LocalDate getDiadaVenda() {
		return diadaVenda;
	}
	public void setDiadaVenda(LocalDate diadaVenda) {
		this.diadaVenda = diadaVenda;
	}
	public float getVenda() {
		return Valor;
	}
	public void setVenda(float venda) {
		Valor = venda;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}	
}
