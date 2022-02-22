package UnRe;

import java.util.Stack;
import ClassesArray.Funcionarios;
import ClassesArray.Ponto;
import ClassesArray.Vendas;

public class CareTaker {
	
	private Stack<Memento> estados = new Stack<Memento>();
	
	private Originator original;

	public CareTaker(Originator orig) {
		this.original = orig;
	}
	public void SaveState(Funcionarios Func, int caso) {
		estados.add(original.criarMemento(Func, caso));
	}
	public void SaveStateC(Auxilio CG, int caso) {
		estados.add(original.criarMementoC(CG, caso));
	}
	public void SaveStateV(Vendas v, int caso) {
		estados.add(original.criarMementoC(v, caso));
	}
	public void SaveStateP(Ponto p, int caso) {
		estados.add(original.criarMementoP(p, caso));
	}
	public void Remover() {
		original.setMemento(estados.pop());
	}
	public FuncionariosAux DevolverUltimo() {
		return estados.elementAt(estados.size() - 1).getFunc();
	}
	public int tamanho() {
		return estados.size();
	}
	public int Caso() {
		return estados.elementAt(estados.size() - 1).getCaso();
	}
	public Auxilio DevolverUltimoConfig() {
		return estados.elementAt(estados.size() - 1).getAux();
	}
	public Vendas DevolverUltimoV() {
		return estados.elementAt(estados.size() - 1).getV();
	}
	public Ponto DevolverUltimoP() {
		return estados.elementAt(estados.size() - 1).getPonto();
	}
}
