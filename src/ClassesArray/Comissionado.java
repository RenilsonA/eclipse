package ClassesArray;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comissionado {
	private float bonus;
	private float vendas;
	private float descSind;
	private float salario;
	private float discExtra;
	private float Alicota;
	private float comissao;
	private LocalDate pagamento;
	private int grupo;
	private int dias;
	private ArrayList<Vendas> ListaVendas;
	
	public Comissionado(float B, float V, float Desc, float Sal, float discEx, float Al, float C, LocalDate pag, int grup, int dia) {
		this.bonus = B;
		this.vendas = V;
		this.descSind = Desc;
		this.salario = Sal;
		this.discExtra = discEx;
		this.Alicota = Al;
		this.comissao = C;
		this.pagamento = pag;
		this.grupo = grup;
		this.ListaVendas = new ArrayList<Vendas>();
		this.dias = dia;
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
	public ArrayList<Vendas> getListaVendas() {
		return ListaVendas;
	}
	public void removeVenda() {
		setVendas(getVendas() - ListaVendas.get(ListaVendas.size() - 1).getValor());
		ListaVendas.remove(ListaVendas.size() - 1);
	}
	public void addListaVendas(Vendas listaVendas) {
		ListaVendas.add(listaVendas);
		setVendas(listaVendas.getValor() + getVendas());
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
}
