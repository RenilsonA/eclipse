package UnRe;

import ClassesArray.Funcionarios;
import ClassesArray.Ponto;
import ClassesArray.Vendas;

public class Originator {
	
	private FuncionariosAux func;
	private Auxilio aux;
	private Vendas v;
	private Ponto ponto;
	
	public Memento criarMemento(Funcionarios Func, int caso) {
		FuncionariosAux fun = new FuncionariosAux(Func);
		return new Memento(fun, caso);
	}
	public Memento criarMementoC(Auxilio CG, int caso) {
		this.aux = CG;
		return new Memento(CG, caso);
	}
	public Memento criarConfig(Auxilio CG, int caso) {
		this.aux = CG;
		return new Memento(CG, caso);
	}	
	public Memento criarMementoC(Vendas v, int caso) {
		this.v = v;
		return new Memento(v, caso);
	}
	public Memento criarMementoP(Ponto p, int caso) {
		this.ponto = p;
		return new Memento(p, caso);
	}
	public void setMemento(Memento funcionario) {
		this.func = funcionario.getFunc();
	}	
	public void setMementoC(Memento CG) {
		this.aux = CG.getAux();
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
	public Vendas getV() {
		return v;
	}
	public void setV(Vendas v) {
		this.v = v;
	}
	public Ponto getPonto() {
		return ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
}
