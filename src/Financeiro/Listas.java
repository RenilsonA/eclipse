package Financeiro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import Geral.Inicio;

public class Listas {
	
	public static ArrayList<Comissionado> comissionados = new ArrayList<Comissionado>();
	public static ArrayList<Horista> horistas = new ArrayList<Horista>();
	public static ArrayList<Assalariado> assalariados = new ArrayList<Assalariado>();
	public ArrayList<Recibos> recibosMaos = new ArrayList<Recibos>();
	public ArrayList<Recibos> recibosCorreios = new ArrayList<Recibos>();
	public ArrayList<Recibos> recibosDeposito = new ArrayList<Recibos>();
	public static ArrayList<DadosBancarios> dadosBancarios = new ArrayList<DadosBancarios>();
	public static ArrayList<DadosCorreios> dadosCorreios = new ArrayList<DadosCorreios>();
	public static ArrayList<Vendas> vendas = new ArrayList<Vendas>();
	
	public void modificacao() {
		for(Comissionado x: comissionados) {
			if(x.getSalario() == 0F)x.setSalario(ConfiguracaoGlobal.getSalarioQuizenal());
			if(x.getAlicota() == 0F) x.setAlicota(ConfiguracaoGlobal.getTaxadeAlicota());
			if(x.isSindicato() && x.getDescontos() == 0F) x.setDescontos(ConfiguracaoGlobal.getTaxadeSindicato());
			if(x.getComissao() == 0F) x.setComissao(ConfiguracaoGlobal.getComissao());
		}
		for(Horista x: horistas) {
			if(x.getSalarioHora() == 0)x.setSalarioHora(ConfiguracaoGlobal.getSalarioHora());
			if(x.getAlicota() == 0) x.setAlicota(ConfiguracaoGlobal.getTaxadeAlicota());
			if(x.isSindicato() && x.getDescontos() == 0) x.setDescontos(ConfiguracaoGlobal.getTaxadeSindicato());
		}
		for(Assalariado x: assalariados) {
			if(x.getSalario() == 0)x.setSalario(ConfiguracaoGlobal.getSalarioMensal());
			if(x.getAlicota() == 0) x.setAlicota(ConfiguracaoGlobal.getTaxadeAlicota());
			if(x.isSindicato() && x.getDescontos() == 0) x.setDescontos(ConfiguracaoGlobal.getTaxadeSindicato());
		}
	}
	
	public void AdicionarDados(DadosBancarios banco, DadosCorreios correios, int x, boolean a) {
		if(x == 0) {
			dadosBancarios.add(banco);
			try {
				SalvarBancarios(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			dadosCorreios.add(correios);
			try {
				SalvarCorreios(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removerDados(int caso, int posicao) {
		if(caso == 0) {
			dadosBancarios.remove(posicao);
			try {
				SalvarBancarios(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			dadosCorreios.remove(posicao);
			try {
				SalvarCorreios(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int posicaoDados(int caso, int x) {
		if(caso == 0) {
			for(int a = 0; a < dadosBancarios.size(); a++) {
				if(dadosBancarios.get(a).getId() == x) {
					return a;
				}
			}
		} else {
			for(int a = 0; a < dadosCorreios.size(); a++) {
				if(dadosCorreios.get(a).getId() == x) {
					return a;
				}
			}
		}
		return -1;
	}
	
	public void adicionar(Assalariado assala, Horista horist, Comissionado comiss, int x, boolean a) {
		if(x == 0) {
			assalariados.add(assala);
			try {
				SalvarAssalariado(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(x == 1) {
			horistas.add(horist);
			try {
				SalvarHorista(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			comissionados.add(comiss);
			try {
				SalvarComissionado(a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void remover(int caso, int posicao) {
		if(caso == 0) {
			assalariados.remove(posicao);
			try {
				SalvarAssalariado(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(caso == 1) {
			horistas.remove(posicao);
			try {
				SalvarHorista(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			comissionados.remove(posicao);
			try {
				SalvarComissionado(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int posicao(int caso, int x) {
		if(caso == 0) {
			for(int a = 0; a < assalariados.size(); a++) {
				if(assalariados.get(a).getID() == x) {
					return a;
				}
			}
		} else if(caso == 1) {
			for(int a = 0; a < horistas.size(); a++) {
				if(horistas.get(a).getID() == x) {
					return a;
				}
			}
		} else {
			for(int a = 0; a < comissionados.size(); a++) {
				if(comissionados.get(a).getID() == x) {
					return a;
				}
			}
		}
		return -1;
	}

	public void Ler() throws IOException {
		String ID = "";
		FileReader comiss = new FileReader(Inicio.endereco + "Comissionados.txt");
		BufferedReader Comiss = new BufferedReader(comiss);
		while((ID = Comiss.readLine()) != null) {
			Listas.comissionados.add(new Comissionado(Integer.parseInt(ID), Comiss.readLine(), Float.parseFloat(Comiss.readLine()),
								     Float.parseFloat(Comiss.readLine()), Float.parseFloat(Comiss.readLine()), Boolean.parseBoolean(Comiss.readLine()),
								     Float.parseFloat(Comiss.readLine()), Float.parseFloat(Comiss.readLine()), Float.parseFloat(Comiss.readLine()),
								     Float.parseFloat(Comiss.readLine()), LocalDate.parse(Comiss.readLine()), Integer.parseInt(Comiss.readLine())));
		}
		Comiss.close();
		comiss.close();
		
		FileReader horist = new FileReader(Inicio.endereco + "Horistas.txt");
		BufferedReader Horist = new BufferedReader(horist);
		while((ID = Horist.readLine()) != null) {
			Listas.horistas.add(new Horista(Integer.parseInt(ID), Horist.readLine(), Float.parseFloat(Horist.readLine()),
									 		Float.parseFloat(Horist.readLine()), Float.parseFloat(Horist.readLine()), 
									 		Float.parseFloat(Horist.readLine()), Boolean.parseBoolean(Horist.readLine()),
									 		Float.parseFloat(Horist.readLine()), Float.parseFloat(Horist.readLine()),
									 		Float.parseFloat(Horist.readLine()), LocalDate.parse(Horist.readLine()), Integer.parseInt(Horist.readLine())));
		}
		Horist.close();
		horist.close();
		
		FileReader assala = new FileReader(Inicio.endereco + "Assalariados.txt");
		BufferedReader Assala = new BufferedReader(assala);
		while((ID = Assala.readLine()) != null) {
			Listas.assalariados.add(new Assalariado(Integer.parseInt(ID), Assala.readLine(), Float.parseFloat(Assala.readLine()), 
									Boolean.parseBoolean(Assala.readLine()), Float.parseFloat(Assala.readLine()), Float.parseFloat(Assala.readLine()),
									Float.parseFloat(Assala.readLine()), Float.parseFloat(Assala.readLine()), LocalDate.parse(Assala.readLine()),
									Integer.parseInt(Assala.readLine())));
		}
		Assala.close();
		assala.close();
		
		FileReader bancarios = new FileReader(Inicio.endereco + "DadosBancarios.txt");
		BufferedReader Bancarios = new BufferedReader(bancarios);
		while((ID = Bancarios.readLine()) != null) {
			Listas.dadosBancarios.add(new DadosBancarios(Integer.parseInt(ID), Bancarios.readLine(), Bancarios.readLine(), 
									Integer.parseInt(Bancarios.readLine()), Integer.parseInt(Bancarios.readLine()), Integer.parseInt(Bancarios.readLine())));
		}
		Bancarios.close();
		bancarios.close();
		
		FileReader correios = new FileReader(Inicio.endereco + "DadosCorreios.txt");
		BufferedReader Correios = new BufferedReader(correios);
		while((ID = Correios.readLine()) != null) {
			Listas.dadosCorreios.add(new DadosCorreios(Integer.parseInt(ID), Correios.readLine(), Correios.readLine(), 
									 Integer.parseInt(Correios.readLine()), Correios.readLine()));
		}
		Correios.close();
		correios.close();
		
		FileReader venda = new FileReader(Inicio.endereco + "Vendas.txt");
		BufferedReader Venda = new BufferedReader(venda);
		while((ID = Venda.readLine()) != null)
			Listas.vendas.add(new Vendas(Integer.parseInt(ID), LocalDate.parse(Venda.readLine()) , Float.parseFloat(Venda.readLine())));
		
		Venda.close();
		venda.close();
	}	
	
	public void SalvarVendas() throws IOException {
		FileWriter comissio = new FileWriter(Inicio.endereco + "Vendas.txt", false);
		PrintWriter Comissio = new PrintWriter(comissio);
		for(Vendas x : vendas) {			
			Comissio.println(x.getID());
			Comissio.println(x.getDiadaVenda());
			Comissio.println(x.getVenda());
		}
		Comissio.flush();
		Comissio.close();
		comissio.close();
	}
	
	public void SalvarComissionado(boolean a) throws IOException {
		if(a == true) {
			FileWriter comissio = new FileWriter(Inicio.endereco + "Comissionados.txt", false);
			PrintWriter Comissio = new PrintWriter(comissio);
			for(Comissionado x : comissionados) {			
				Comissio.println(x.getID());
				Comissio.println(x.getNome());
				Comissio.println(x.getBonus());
				Comissio.println(x.getVendas());
				Comissio.println(x.getDescontos());
				Comissio.println(x.isSindicato());
				Comissio.println(x.getSalario());
				Comissio.println(x.getDiscExtra());
				Comissio.println(x.getAlicota());
				Comissio.println(x.getComissao());
				Comissio.println(x.getPagamento());
				Comissio.println(x.getGrupo());
			}
			Comissio.flush();
			Comissio.close();
			comissio.close();
		} else {
			FileWriter comissio = new FileWriter(Inicio.endereco + "Comissionados.txt", true);
			PrintWriter Comissio = new PrintWriter(comissio);
			int x = Listas.comissionados.size();
			Comissio.println(Listas.comissionados.get(x - 1).getID());
			Comissio.println(Listas.comissionados.get(x - 1).getNome());
			Comissio.println(Listas.comissionados.get(x - 1).getBonus());
			Comissio.println(Listas.comissionados.get(x - 1).getVendas());
			Comissio.println(Listas.comissionados.get(x - 1).getDescontos());
			Comissio.println(Listas.comissionados.get(x - 1).isSindicato());
			Comissio.println(Listas.comissionados.get(x - 1).getSalario());
			Comissio.println(Listas.comissionados.get(x - 1).getDiscExtra());
			Comissio.println(Listas.comissionados.get(x - 1).getAlicota());
			Comissio.println(Listas.comissionados.get(x - 1).getComissao());
			Comissio.println(Listas.comissionados.get(x - 1).getPagamento());
			Comissio.println(Listas.comissionados.get(x - 1).getGrupo());
			Comissio.flush();
			Comissio.close();
			comissio.close();
		}
	}
	
	public void SalvarHorista(boolean a) throws IOException {
		if(a == true) {
			FileWriter horista = new FileWriter(Inicio.endereco + "Horistas.txt", false);
			PrintWriter Horista = new PrintWriter(horista);
			for(Horista x : horistas) {			
				Horista.println(x.getID());
				Horista.println(x.getNome());
				Horista.println(x.getHoras());
				Horista.println(x.getHorasExtras());
				Horista.println(x.getBonus());
				Horista.println(x.getDescontos());
				Horista.println(x.isSindicato());
				Horista.println(x.getDiscExtra());
				Horista.println(x.getAlicota());
				Horista.println(x.getSalarioHora());
				Horista.println(x.getPagamento());
				Horista.println(x.getGrupo());
			}
			Horista.flush();
			Horista.close();
			horista.close();
		} else {	
			FileWriter horista = new FileWriter(Inicio.endereco + "Horistas.txt", true);
			PrintWriter Horista = new PrintWriter(horista);
			int x = Listas.horistas.size();
			Horista.println(Listas.horistas.get(x - 1).getID());
			Horista.println(Listas.horistas.get(x - 1).getNome());
			Horista.println(Listas.horistas.get(x - 1).getHoras());
			Horista.println(Listas.horistas.get(x - 1).getHorasExtras());
			Horista.println(Listas.horistas.get(x - 1).getBonus());
			Horista.println(Listas.horistas.get(x - 1).getDescontos());
			Horista.println(Listas.horistas.get(x - 1).isSindicato());
			Horista.println(Listas.horistas.get(x - 1).getDiscExtra());
			Horista.println(Listas.horistas.get(x - 1).getAlicota());
			Horista.println(Listas.horistas.get(x - 1).getSalarioHora());
			Horista.println(Listas.horistas.get(x - 1).getPagamento());
			Horista.println(Listas.horistas.get(x - 1).getGrupo());
			Horista.flush();
			Horista.close();
			horista.close();
		}
	}
	
	public void SalvarAssalariado(boolean a) throws IOException {
		if(a == true) {
			FileWriter assalariado = new FileWriter(Inicio.endereco + "Assalariados.txt", false);
			PrintWriter Assalariado = new PrintWriter(assalariado);
			for(Assalariado x : assalariados) {			
				Assalariado.println(x.getID());
				Assalariado.println(x.getNome());
				Assalariado.println(x.getSalario());
				Assalariado.println(x.isSindicato());
				Assalariado.println(x.getBonus());
				Assalariado.println(x.getDescontos());
				Assalariado.println(x.getDiscExtra());
				Assalariado.println(x.getAlicota());
				Assalariado.println(x.getPagamento());
				Assalariado.println(x.getGrupo());
			}
			Assalariado.flush();
			Assalariado.close();
			assalariado.close();
		} else {		
			FileWriter assalariado = new FileWriter(Inicio.endereco + "Assalariados.txt", true);
			PrintWriter Assalariado = new PrintWriter(assalariado);
			int x = Listas.assalariados.size();
			Assalariado.println(Listas.assalariados.get(x - 1).getID());
			Assalariado.println(Listas.assalariados.get(x - 1).getNome());
			Assalariado.println(Listas.assalariados.get(x - 1).getSalario());
			Assalariado.println(Listas.assalariados.get(x - 1).isSindicato());
			Assalariado.println(Listas.assalariados.get(x - 1).getBonus());
			Assalariado.println(Listas.assalariados.get(x - 1).getDescontos());
			Assalariado.println(Listas.assalariados.get(x - 1).getDiscExtra());
			Assalariado.println(Listas.assalariados.get(x - 1).getAlicota());
			Assalariado.println(Listas.assalariados.get(x - 1).getPagamento());
			Assalariado.println(Listas.assalariados.get(x - 1).getGrupo());
			Assalariado.flush();
			Assalariado.close();
			assalariado.close();
		}
	}
	
	public void SalvarBancarios(boolean a) throws IOException {
		if(a == true) {
			FileWriter bancarios = new FileWriter(Inicio.endereco + "DadosBancarios.txt", false);
			PrintWriter Bancarios = new PrintWriter(bancarios);
			for(DadosBancarios x : dadosBancarios) {			
				Bancarios.println(x.getId());
				Bancarios.println(x.getNome());
				Bancarios.println(x.getBanco());
				Bancarios.println(x.getAgencia());
				Bancarios.println(x.getOperacao());
				Bancarios.println(x.getConta());
			}
			Bancarios.flush();
			Bancarios.close();
			bancarios.close();
		} else {		
			FileWriter bancarios = new FileWriter(Inicio.endereco + "DadosBancarios.txt", true);
			PrintWriter Bancarios = new PrintWriter(bancarios);
			int x = Listas.dadosBancarios.size();
			Bancarios.println(Listas.dadosBancarios.get(x - 1).getId());
			Bancarios.println(Listas.dadosBancarios.get(x - 1).getNome());
			Bancarios.println(Listas.dadosBancarios.get(x - 1).getBanco());
			Bancarios.println(Listas.dadosBancarios.get(x - 1).getAgencia());
			Bancarios.println(Listas.dadosBancarios.get(x - 1).getOperacao());
			Bancarios.println(Listas.dadosBancarios.get(x - 1).getConta());
			Bancarios.flush();
			Bancarios.close();
			bancarios.close();
		}
	}
	
	public void SalvarCorreios(boolean a) throws IOException {
		if(a == true) {
			FileWriter correios = new FileWriter(Inicio.endereco + "DadosCorreios.txt", false);
			PrintWriter Correios = new PrintWriter(correios);
			for(DadosCorreios x : dadosCorreios) {			
				Correios.println(x.getId());
				Correios.println(x.getNome());
				Correios.println(x.getEndereco());
				Correios.println(x.getNumero());
				Correios.println(x.getCep());
			}
			Correios.flush();
			Correios.close();
			Correios.close();
		} else {		
			FileWriter correios = new FileWriter(Inicio.endereco + "DadosCorreios.txt", true);
			PrintWriter Correios = new PrintWriter(correios);
			int x = Listas.dadosCorreios.size();
			Correios.println(Listas.dadosCorreios.get(x - 1).getId());
			Correios.println(Listas.dadosCorreios.get(x - 1).getNome());
			Correios.println(Listas.dadosCorreios.get(x - 1).getEndereco());
			Correios.println(Listas.dadosCorreios.get(x - 1).getNumero());
			Correios.println(Listas.dadosCorreios.get(x - 1).getCep());
			Correios.flush();
			Correios.close();
			Correios.close();
		}
	}
}