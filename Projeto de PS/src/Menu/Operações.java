package Menu;

import java.util.ArrayList;

public class Operações {
	ArrayList<Integer> ID = new ArrayList<Integer>();
	ArrayList<String> nome = new ArrayList<String>();
	ArrayList<String> atributo = new ArrayList<String>();
	ArrayList<String> endereco = new ArrayList<String>();
	ArrayList<String> tipo = new ArrayList<String>();
		
	public void Adicionar(String Nome, String Atributo, String Endereco, String Tipo) {
		int id = nome.size() + 1;
		ID.add(id);
		nome.add(Nome);
		atributo.add(Atributo);
		endereco.add(Endereco);
		tipo.add(Tipo);
	}
	
	public void Remover(int id) {
		for(int a = 0; a < ID.size(); a++) {
			if(id == ID.get(a)) {
				ID.remove(a);
				nome.remove(a);
				atributo.remove(a);
				endereco.remove(a);
				tipo.remove(a);
			}
		}
	}
	
	public void imprimir(int id) {
		if(id != 0) {
			boolean existe = true;
			for(int a = 0; a < ID.size(); a++) {
				if(id == ID.get(a)) {
					System.out.println(ID.get(a));
					System.out.println(nome.get(a));
					System.out.println(atributo.get(a));
					System.out.println(tipo.get(a));
					existe = false;
				}
			}
			if(existe) {
				System.out.println("Funcionário não cadastrado");
			}
		} else {
			for(int a = 0; a < ID.size(); a++) {
				System.out.println(ID.get(a));
				System.out.println(nome.get(a));
				System.out.println(atributo.get(a));
				System.out.println(tipo.get(a));
			}
		}
	}
}
