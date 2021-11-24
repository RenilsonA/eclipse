package Programas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Funcionarios {
	
	public int ID;
	public String nome;
	public String endereco;
	public String atributo;
	public String tipo;
	
	public Funcionarios(int id, String Nome, String Endereco, int Atributo, int Tipo) {		
		
		this.ID = id;
		this.nome = Nome;
		this.endereco = Endereco;
		if (Atributo == 1) this.atributo = "Horista";
		else if (Atributo == 2) this.atributo = "Salariado";
		else this.atributo = "Comissionado";
		if (Tipo == 1) this.tipo = "Salário horário";
		else if (Tipo == 2) this.tipo = "Salário mensal";
		else this.tipo = "Comissão";
		
	}	
	
	public Funcionarios() {
		try {
			FileReader arq = new FileReader("C:\\Users\\renil\\Desktop\\Funcionarios.txt");
			BufferedReader lerArq = new BufferedReader(arq);
		} catch (IOException e) {
	        
	    }
		
	}
	
	public String getName() {
        return nome;
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
