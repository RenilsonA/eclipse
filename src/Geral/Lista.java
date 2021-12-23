package Geral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import Financeiro.ConfiguracaoGlobal;


public class Lista {
	
	public static ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
	public static int id;
	public static ArrayList<Agenda> grupos = new ArrayList<Agenda>();
	public static int quantGrupos;
	
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Lista.id = id;
	}
	
	public static int getQuantGrupos() {
		return quantGrupos;
	}

	public static void setQuantGrupos(int x) {
		Lista.quantGrupos = x;
	}

	public ArrayList<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionarios> funcionarios) {
		Lista.funcionarios = funcionarios;
	}

	public void adicionar(Funcionarios novo, boolean x) {
		funcionarios.add(novo);
		try {
			Salvar(x);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(int x) {
		funcionarios.remove(x);
		try {
			Salvar(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int posicao(int x) {
		for(int a = 0; a < funcionarios.size(); a++) {
			if(funcionarios.get(a).getID() == x) {
				return a;
			}
		}
		return -1;
	}

	public void Ler(String endereco) throws IOException {
		FileReader limi = new FileReader(endereco + "Dados.txt");
		FileReader func = new FileReader(endereco + "Funcionarios.txt");
		BufferedReader Limi = new BufferedReader(limi);
		BufferedReader Func = new BufferedReader(func);
		String x = Limi.readLine(); 
		if(x != null) {
			setId(Integer.parseInt(x));
			setQuantGrupos(Integer.parseInt(Limi.readLine()));
			ConfiguracaoGlobal.setSalarioMensal(Float.parseFloat(Limi.readLine()));
			ConfiguracaoGlobal.setSalarioHora(Float.parseFloat(Limi.readLine()));
			ConfiguracaoGlobal.setComissao(Float.parseFloat(Limi.readLine()));
			ConfiguracaoGlobal.setTaxadeAlicota(Float.parseFloat(Limi.readLine()));
			ConfiguracaoGlobal.setTaxadeSindicato(Float.parseFloat(Limi.readLine()));
			ConfiguracaoGlobal.setSalarioQuizenal(Float.parseFloat(Limi.readLine()));
			for(int a = 0; a < getQuantGrupos(); a++) {
				String nome = Limi.readLine();
				LocalDate dia = LocalDate.parse(Limi.readLine());
				Lista.grupos.add(new Agenda(nome, dia, Integer.parseInt(Limi.readLine()), Limi.readLine()));
			}
			String ID = "";
			while((ID = Func.readLine()) != null) {
				Lista.funcionarios.add(new Funcionarios(Integer.parseInt(ID), Func.readLine(), Func.readLine(), Boolean.parseBoolean(Func.readLine()),
								  	   Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()),
								  	   Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()),
								  	   Func.readLine(), Integer.parseInt(Func.readLine()), Integer.parseInt(Func.readLine()), Func.readLine()));
			}
		}
		Limi.close();
		Func.close();
		limi.close();
		func.close();
	}	
	
	public void Salvar(boolean tipo) throws IOException {
		FileWriter Limit = new FileWriter(Inicio.endereco + "Dados.txt", false);
		PrintWriter arquivoLimi = new PrintWriter(Limit);
		arquivoLimi.println(getId());
		arquivoLimi.println(getQuantGrupos());
		arquivoLimi.println(ConfiguracaoGlobal.getSalarioMensal());
		arquivoLimi.println(ConfiguracaoGlobal.getSalarioHora());
		arquivoLimi.println(ConfiguracaoGlobal.getComissao());
		arquivoLimi.println(ConfiguracaoGlobal.getTaxadeAlicota());
		arquivoLimi.println(ConfiguracaoGlobal.getTaxadeSindicato());
		arquivoLimi.println(ConfiguracaoGlobal.getSalarioQuizenal());
		for(Agenda x: grupos) {
			arquivoLimi.println(x.getNome());
			arquivoLimi.println(x.getDia());
			arquivoLimi.println(x.getIntervalo());
			arquivoLimi.println(x.getDias());
		}
		if(tipo == true) {
			FileWriter Funci = new FileWriter(Inicio.endereco + "Funcionarios.txt", false);
			PrintWriter arquivoFunc = new PrintWriter(Funci);
			for(Funcionarios x : funcionarios) {			
				arquivoFunc.println(x.getID());
				arquivoFunc.println(x.getNome());
				arquivoFunc.println(x.getEndereco());
				arquivoFunc.println(x.isHorista());
				arquivoFunc.println(x.isSalariado());
				arquivoFunc.println(x.isComissionado());
				arquivoFunc.println(x.isViaCorreios());
				arquivoFunc.println(x.isEmMaos());
				arquivoFunc.println(x.isViaDeposito());
				arquivoFunc.println(x.isSindicato());
				arquivoFunc.println(x.getIdentificacao());
				arquivoFunc.println(x.getGrupo());
				arquivoFunc.println(x.getNumero());
				arquivoFunc.println(x.getCep());
			}
			arquivoFunc.flush();
			arquivoFunc.close();
			Funci.close();
		} else {
			FileWriter Funci = new FileWriter(Inicio.endereco + "Funcionarios.txt", true);
			PrintWriter arquivoFunc = new PrintWriter(Funci);
			int x = Lista.funcionarios.size();
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getID());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getNome());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getEndereco());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isHorista());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isSalariado());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isComissionado());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isViaCorreios());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isEmMaos());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isViaDeposito());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isSindicato());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getIdentificacao());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getGrupo());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getNumero());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getCep());
			arquivoFunc.flush();
			arquivoFunc.close();
			Funci.close();
		}
		arquivoLimi.flush();
		arquivoLimi.close();
		Limit.close();
	}	
}
