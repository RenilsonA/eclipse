package Ponto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ListaPonto {
	
	public static ArrayList<Ponto> pontosAssalariados = new ArrayList<Ponto>();
	public static ArrayList<Ponto> pontosHorista = new ArrayList<Ponto>();
	public static ArrayList<Ponto> pontosComissionado = new ArrayList<Ponto>();
	
	public void adicionar(Ponto assala, Ponto horist, Ponto comiss, int x, boolean a) {
		if(x == 0) {
			pontosAssalariados.add(assala);
			try {
				SalvarAssalariado(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(x == 1) {
			pontosHorista.add(horist);
			try {
				SalvarHorista(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			pontosComissionado.add(comiss);
			try {
				SalvarComissionado(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void remover(int x, int posicao) {
		if(x == 0) {
			pontosAssalariados.remove(posicao);
			try {
				SalvarAssalariado(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(x == 1) {
			pontosHorista.remove(posicao);
			try {
				SalvarHorista(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			pontosComissionado.remove(posicao);
			try {
				SalvarComissionado(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int posicao(int caso, int x) {
		if(caso == 0) {
			for(int a = 0; a < pontosAssalariados.size(); a++) {
				if(pontosAssalariados.get(a).getID() == x) {
					return a;
				}
			}
		} else if(caso == 1) {
			for(int a = 0; a < pontosHorista.size(); a++) {
				if(pontosHorista.get(a).getID() == x) {
					return a;
				}
			}
		} else {
			for(int a = 0; a < pontosComissionado.size(); a++) {
				if(pontosComissionado.get(a).getID() == x) {
					return a;
				}
			}
		}
		return -1;
	}

	public void Ler() throws IOException {
		FileReader comi = new FileReader("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoComissionado.txt");
		BufferedReader Comi = new BufferedReader(comi);
		String ID = "";
		while((ID = Comi.readLine()) != null) {
			ListaPonto.pontosComissionado.add(new Ponto(Integer.parseInt(ID), Float.parseFloat(Comi.readLine()), Float.parseFloat(Comi.readLine()),
											Float.parseFloat(Comi.readLine()), Float.parseFloat(Comi.readLine()), Boolean.parseBoolean(Comi.readLine())));
		}
		Comi.close();
		comi.close();
		FileReader assa = new FileReader("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoAssalariado.txt");
		BufferedReader Assa = new BufferedReader(assa);
		while((ID = Assa.readLine()) != null) {
			ListaPonto.pontosAssalariados.add(new Ponto(Integer.parseInt(ID), Float.parseFloat(Assa.readLine()), Float.parseFloat(Assa.readLine()),
											Float.parseFloat(Assa.readLine()), Float.parseFloat(Assa.readLine()), Boolean.parseBoolean(Assa.readLine())));
		}
		Assa.close();
		assa.close();
		FileReader hori = new FileReader("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoHorista.txt");
		BufferedReader Hori = new BufferedReader(hori);
		while((ID = Hori.readLine()) != null) {
			ListaPonto.pontosHorista.add(new Ponto(Integer.parseInt(ID), Float.parseFloat(Hori.readLine()), Float.parseFloat(Hori.readLine()),
											Float.parseFloat(Hori.readLine()), Float.parseFloat(Hori.readLine()), Boolean.parseBoolean(Hori.readLine())));
		}
		Hori.close();
		hori.close();
	}
	
	public void SalvarComissionado(boolean a) throws IOException {
		if(a == true) {
			FileWriter pont = new FileWriter("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoComissionado.txt", false);
			PrintWriter Pont = new PrintWriter(pont);
			for(Ponto x : pontosComissionado) {			
				Pont.println(x.getID());
				Pont.println(x.getHorasNormais());
				Pont.println(x.getHorasExtras());
				Pont.println(x.getHorasNormaisTotal());
				Pont.println(x.getHorasExtrasTotal());
				Pont.println(x.isEstado());
			}
			Pont.flush();
			Pont.close();
			Pont.close();
		} else {
			FileWriter pont = new FileWriter("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoComissionado.txt", true);
			PrintWriter Pont = new PrintWriter(pont);
			int x = ListaPonto.pontosComissionado.size();
			Pont.println(ListaPonto.pontosComissionado.get(x - 1).getID());
			Pont.println(ListaPonto.pontosComissionado.get(x - 1).getHorasNormais());
			Pont.println(ListaPonto.pontosComissionado.get(x - 1).getHorasExtras());
			Pont.println(ListaPonto.pontosComissionado.get(x - 1).getHorasNormaisTotal());
			Pont.println(ListaPonto.pontosComissionado.get(x - 1).getHorasExtrasTotal());
			Pont.println(ListaPonto.pontosComissionado.get(x - 1).isEstado());
			Pont.flush();
			Pont.close();
			pont.close();
		}
	}	
	
	public void SalvarAssalariado(boolean a) throws IOException {
		if(a == true) {
			FileWriter pont = new FileWriter("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoAssalariado.txt", false);
			PrintWriter Pont = new PrintWriter(pont);
			for(Ponto x : pontosAssalariados) {			
				Pont.println(x.getID());
				Pont.println(x.getHorasNormais());
				Pont.println(x.getHorasExtras());
				Pont.println(x.getHorasNormaisTotal());
				Pont.println(x.getHorasExtrasTotal());
				Pont.println(x.isEstado());
			}
			Pont.flush();
			Pont.close();
			Pont.close();
		} else {
			FileWriter pont = new FileWriter("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoAssalariado.txt", true);
			PrintWriter Pont = new PrintWriter(pont);
			int x = ListaPonto.pontosAssalariados.size();
			Pont.println(ListaPonto.pontosAssalariados.get(x - 1).getID());
			Pont.println(ListaPonto.pontosAssalariados.get(x - 1).getHorasNormais());
			Pont.println(ListaPonto.pontosAssalariados.get(x - 1).getHorasExtras());
			Pont.println(ListaPonto.pontosAssalariados.get(x - 1).getHorasNormaisTotal());
			Pont.println(ListaPonto.pontosAssalariados.get(x - 1).getHorasExtrasTotal());
			Pont.println(ListaPonto.pontosAssalariados.get(x - 1).isEstado());
			Pont.flush();
			Pont.close();
			pont.close();
		}
	}
	
	public void SalvarHorista(boolean a) throws IOException {
		if(a == true) {
			FileWriter pont = new FileWriter("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoHorista.txt", false);
			PrintWriter Pont = new PrintWriter(pont);
			for(Ponto x : pontosHorista) {			
				Pont.println(x.getID());
				Pont.println(x.getHorasNormais());
				Pont.println(x.getHorasExtras());
				Pont.println(x.getHorasNormaisTotal());
				Pont.println(x.getHorasExtrasTotal());
				Pont.println(x.isEstado());
			}
			Pont.flush();
			Pont.close();
			Pont.close();
		} else {
			FileWriter pont = new FileWriter("C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\PontoHorista.txt", true);
			PrintWriter Pont = new PrintWriter(pont);
			int x = ListaPonto.pontosHorista.size();
			Pont.println(ListaPonto.pontosHorista.get(x - 1).getID());
			Pont.println(ListaPonto.pontosHorista.get(x - 1).getHorasNormais());
			Pont.println(ListaPonto.pontosHorista.get(x - 1).getHorasExtras());
			Pont.println(ListaPonto.pontosHorista.get(x - 1).getHorasNormaisTotal());
			Pont.println(ListaPonto.pontosHorista.get(x - 1).getHorasExtrasTotal());
			Pont.println(ListaPonto.pontosHorista.get(x - 1).isEstado());
			Pont.flush();
			Pont.close();
			pont.close();
		}
	}	
}
