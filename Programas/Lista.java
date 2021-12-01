package Programas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Lista {
	
	public ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
	static public int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		Lista.id = id;
	}

	public ArrayList<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void adicionar(Funcionarios novo) {
		funcionarios.add(novo);
	}
	
	public void printa() { 
		for(Funcionarios x : funcionarios) {
			System.out.println(x.getNome() + "   " + x.getID()); 
		} 
	}

	public void lista(int salvar) {
		try {
			FileReader arq = new FileReader("C:\\Users\\renil\\Desktop\\Funcionarios.txt");
			BufferedReader lerArq = new BufferedReader(arq);
		} catch (IOException e) {
	        
	    }
		
	}	
	
	private void close() throws IOException {
		FileWriter Funci = new FileWriter("C:\\Users\\renil\\Desktop\\Funcionarios.txt");
		PrintWriter arquivo = new PrintWriter(Funci);
		//arquivo.print(ide);
		//arquivo.print(" - " + Nome);
		//arquivo.print(" - " + Endereco);
		//arquivo.print(" - " + this.atributo);
		//arquivo.println(" - " + this.tipo);		
				
		arquivo.flush();
		arquivo.close();
		Funci.close();
	}	
	
}
