package UnRe;

import ClassesArray.Ponto;
import ClassesArray.Vendas;

public class Memento {
	private FuncionariosAux func;
	private Auxilio aux;
	private Ponto ponto;
	private Vendas v;
	private int caso;
	
	public Memento(FuncionariosAux f, int caso) {
		this(f, null, null, null, caso);
	}
	
	public Memento(Auxilio a, int caso) {
		this(null, a, null, null, caso);
	}
	
	public Memento(Vendas v, int caso) {
		this(null, null, v, null, caso);
	}
	
	public Memento(Ponto p, int caso) {
		this(null, null, null, p, caso);
	}
	
	public Memento(FuncionariosAux f, Auxilio a, Vendas v, Ponto p, int caso) {
		this.func = f;
		this.aux = a;
		this.v = v;
		this.ponto = p;
		this.caso = caso;
	}

	public FuncionariosAux getFunc() {
		return func;
	}
	public void setFunc(FuncionariosAux func) {
		this.func = func;
	}
	public Auxilio getAux() {
		return aux;
	}
	public void setAux(Auxilio aux) {
		this.aux = aux;
	}
	public Ponto getPonto() {
		return ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	public int getCaso() {
		return caso;
	}
	public void setCaso(int caso) {
		this.caso = caso;
	}
	public Vendas getV() {
		return v;
	}
	public void setV(Vendas v) {
		this.v = v;
	}	
}