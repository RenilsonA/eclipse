package Geral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import ClassesArray.Agenda;
import ClassesArray.Assalariado;
import ClassesArray.Comissionado;
import ClassesArray.ConfiguracaoGlobal;
import ClassesArray.Funcionarios;
import ClassesArray.Horista;
import ClassesArray.Ponto;
import ClassesArray.Recibos;
import ClassesArray.Vendas;

public class Lista {
	public static ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
	public static int id;
	public static ArrayList<Agenda> grupos = new ArrayList<Agenda>();
	public static int quantGrupos;
	public ArrayList<Recibos> recibosMaos = new ArrayList<Recibos>();
	public ArrayList<Recibos> recibosCorreios = new ArrayList<Recibos>();
	public ArrayList<Recibos> recibosDeposito = new ArrayList<Recibos>();
	
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
	
	public void Setar(float d, float e, float f) {
		for(Funcionarios x: Lista.funcionarios) {
			if(x.getTipo() == 0) {
				x.getDadosAssalariado().setAlicota(e);
				x.getDadosAssalariado().setdescSind(f);
			} else if(x.getTipo() == 1) {
				x.getDadosHorista().setAlicota(e);
				x.getDadosHorista().setdescSind(f);
			} else {
				x.getDadosComissionado().setAlicota(e);
				x.getDadosComissionado().setdescSind(f);
				x.getDadosComissionado().setComissao(d);
			}
		}
	}
	
	public void Pontos(int x) {
		if(Lista.funcionarios.get(x).getTipo() == 0) 
			Lista.funcionarios.get(x).getDadosAssalariado().setDias(Lista.funcionarios.get(x).getDadosAssalariado().getDias() + 1);
		else if(Lista.funcionarios.get(x).getTipo() == 1) { 
			float y = Lista.funcionarios.get(x).getPontos().get(Lista.funcionarios.get(x).getPontos().size() - 1).getHoras();
			if(y > 8) {
				Lista.funcionarios.get(x).getDadosHorista().setHoras(Lista.funcionarios.get(x).getDadosHorista().getHoras() + 8);
				Lista.funcionarios.get(x).getDadosHorista().setHorasExtras(Lista.funcionarios.get(x).getDadosHorista().getHorasExtras() + y - 8);
			} else {
				Lista.funcionarios.get(x).getDadosHorista().setHoras(Lista.funcionarios.get(x).getDadosHorista().getHoras() + y);
			}
		} else if(Lista.funcionarios.get(x).getTipo() == 2) { 
			Lista.funcionarios.get(x).getDadosComissionado().setDias(Lista.funcionarios.get(x).getDadosComissionado().getDias() + 1);
		}
	}

	public void Ler(String endereco) throws IOException {
		FileReader limi = new FileReader(endereco + "Dados.txt");
		FileReader grup = new FileReader(endereco + "Grupos.txt");
		FileReader func = new FileReader(endereco + "Funcionarios.txt");
		BufferedReader Limi = new BufferedReader(limi);
		BufferedReader Grup = new BufferedReader(grup);
		BufferedReader Func = new BufferedReader(func);
		String x = Limi.readLine(); 
		
		if(x != null) {
			setId(Integer.parseInt(x));
			setQuantGrupos(Integer.parseInt(Limi.readLine()));
			ConfiguracaoGlobal.setComissao(Float.parseFloat(Limi.readLine()));
			ConfiguracaoGlobal.setTaxadeAlicota(Float.parseFloat(Limi.readLine()));
			ConfiguracaoGlobal.setTaxadeSindicato(Float.parseFloat(Limi.readLine()));
		}
		String ID = "";
		while((ID = Func.readLine()) != null) {
			Lista.funcionarios.add(new Funcionarios(Integer.parseInt(ID), Func.readLine(), Func.readLine(), Integer.parseInt(Func.readLine()),
								   Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()), Boolean.parseBoolean(Func.readLine()),
								   Boolean.parseBoolean(Func.readLine()), Func.readLine(), Integer.parseInt(Func.readLine()), Func.readLine(), "null", 0, 0, " "));
			int f = Lista.funcionarios.size() - 1;
			if(Lista.funcionarios.get(f).getTipo() == 0) {
				Lista.funcionarios.get(f).setDadosAssalariado(new Assalariado(Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()),
						   Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()),
						   LocalDate.parse(Func.readLine()), Integer.parseInt(Func.readLine()), Integer.parseInt(Func.readLine())));
			} else if(Lista.funcionarios.get(f).getTipo() == 2) {
				Lista.funcionarios.get(f).setDadosComissionado(new Comissionado(Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine())*0,
						   Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()),
						   Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), LocalDate.parse(Func.readLine()), 
						   Integer.parseInt(Func.readLine()), Integer.parseInt(Func.readLine())));
				int tamanho = Integer.parseInt(Func.readLine());
				for(int g = 0; g < tamanho; g++) {
					Lista.funcionarios.get(f).getDadosComissionado().addListaVendas(new Vendas(LocalDate.parse(Func.readLine()), 
																					Float.parseFloat(Func.readLine()), 
																					Boolean.parseBoolean(Func.readLine())));
				}
			} else {
				Lista.funcionarios.get(f).setDadosHorista(new Horista(Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), 
						   Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()),
						   Float.parseFloat(Func.readLine()), Float.parseFloat(Func.readLine()), LocalDate.parse(Func.readLine()),
						   Integer.parseInt(Func.readLine())));
			}
			Lista.funcionarios.get(f).getBancarios().setBanco(Func.readLine());
			Lista.funcionarios.get(f).getBancarios().setAgencia(Integer.parseInt(Func.readLine()));
			Lista.funcionarios.get(f).getBancarios().setOperacao(Integer.parseInt(Func.readLine()));
			Lista.funcionarios.get(f).getBancarios().setConta(Func.readLine());
			int tamanho = Integer.parseInt(Func.readLine());
			for(int g = 0; g < tamanho; g++) {
				Lista.funcionarios.get(f).getPontos().add(new Ponto(Func.readLine(), Func.readLine(), Func.readLine(), Boolean.parseBoolean(Func.readLine()), 
														  			Float.parseFloat(Func.readLine())));
			}
		}
		String y = "";
		while((y = Grup.readLine()) != null) {
			Lista.grupos.add(new Agenda(y, LocalDate.parse(Grup.readLine()), Integer.parseInt(Grup.readLine()), Grup.readLine()));
			if(Lista.grupos.get(Lista.grupos.size() - 1).getDia().isBefore(LocalDate.now())) {
				Lista.grupos.get(Lista.grupos.size() - 1).setDia(Lista.grupos.get(Lista.grupos.size() - 1).getDia().plusDays(Lista.grupos.get(Lista.grupos.size() - 1).getIntervalo() + 1));
				for(Funcionarios check: funcionarios) {
					if(check.getTipo() == 0 && check.getDadosAssalariado().getGrupo() > 3) {
						check.getDadosAssalariado().setPagamento(grupos.get(check.getDadosAssalariado().getGrupo() - 4).getDia());
					} else if(check.getTipo() == 1 && check.getDadosHorista().getGrupo() > 3) {
						check.getDadosHorista().setPagamento(grupos.get(check.getDadosHorista().getGrupo() - 4).getDia());
					} else if(check.getTipo() == 2 && check.getDadosComissionado().getGrupo() > 3) {
						check.getDadosComissionado().setPagamento(grupos.get(check.getDadosComissionado().getGrupo() - 4).getDia());
					}
				}
			}
		}
		Limi.close();
		Grup.close();
		Func.close();
		limi.close();
		grup.close();
		func.close();
	}	
	
	public void SalvarGrupo() throws IOException {
		FileWriter grupo = new FileWriter(Inicio.endereco + "Grupos.txt", false);
		PrintWriter Grupo = new PrintWriter(grupo);
		for(Agenda x: Lista.grupos) {
			Grupo.println(x.getNome());
			Grupo.println(x.getDia());
			Grupo.println(x.getIntervalo());
			Grupo.println(x.getDias());
		}
		Grupo.flush();
		Grupo.close();
		grupo.close();
	}
	
	public void Salvar(boolean tipo) throws IOException {
		FileWriter Limit = new FileWriter(Inicio.endereco + "Dados.txt", false);
		PrintWriter arquivoLimi = new PrintWriter(Limit);
		arquivoLimi.println(getId());
		arquivoLimi.println(getQuantGrupos());
		arquivoLimi.println(ConfiguracaoGlobal.getComissao());
		arquivoLimi.println(ConfiguracaoGlobal.getTaxadeAlicota());
		arquivoLimi.println(ConfiguracaoGlobal.getTaxadeSindicato());
		arquivoLimi.flush();
		arquivoLimi.close();
		Limit.close();
		if(tipo == true) {
			FileWriter Funci = new FileWriter(Inicio.endereco + "Funcionarios.txt", false);
			PrintWriter arquivoFunc = new PrintWriter(Funci);
			for(Funcionarios x : funcionarios) {			
				arquivoFunc.println(x.getID());
				arquivoFunc.println(x.getNome());
				arquivoFunc.println(x.getEndereco());
				arquivoFunc.println(x.getTipo());
				arquivoFunc.println(x.isViaCorreios());
				arquivoFunc.println(x.isEmMaos());
				arquivoFunc.println(x.isViaDeposito());
				arquivoFunc.println(x.isSindicato());
				arquivoFunc.println(x.getIdentificacao());
				arquivoFunc.println(x.getNumeroCasa());
				arquivoFunc.println(x.getCep());
				if(x.getTipo() == 0) {
					arquivoFunc.println(x.getDadosAssalariado().getSalario());
					arquivoFunc.println(x.getDadosAssalariado().getBonus());
					arquivoFunc.println(x.getDadosAssalariado().getdescSind());
					arquivoFunc.println(x.getDadosAssalariado().getDiscExtra());
					arquivoFunc.println(x.getDadosAssalariado().getAlicota());
					arquivoFunc.println(x.getDadosAssalariado().getPagamento());
					arquivoFunc.println(x.getDadosAssalariado().getGrupo());
					arquivoFunc.println(x.getDadosAssalariado().getDias());
				} else if(x.getTipo() == 1) {
					arquivoFunc.println(x.getDadosHorista().getHoras());
					arquivoFunc.println(x.getDadosHorista().getHorasExtras());
					arquivoFunc.println(x.getDadosHorista().getBonus());
					arquivoFunc.println(x.getDadosHorista().getdescSind());
					arquivoFunc.println(x.getDadosHorista().getDiscExtra());
					arquivoFunc.println(x.getDadosHorista().getAlicota());
					arquivoFunc.println(x.getDadosHorista().getSalarioHora());
					arquivoFunc.println(x.getDadosHorista().getPagamento());
					arquivoFunc.println(x.getDadosHorista().getGrupo());
				} else {
					arquivoFunc.println(x.getDadosComissionado().getBonus());
					arquivoFunc.println(x.getDadosComissionado().getVendas());
					arquivoFunc.println(x.getDadosComissionado().getdescSind());
					arquivoFunc.println(x.getDadosComissionado().getSalario());
					arquivoFunc.println(x.getDadosComissionado().getDiscExtra());
					arquivoFunc.println(x.getDadosComissionado().getAlicota());
					arquivoFunc.println(x.getDadosComissionado().getComissao());
					arquivoFunc.println(x.getDadosComissionado().getPagamento());
					arquivoFunc.println(x.getDadosComissionado().getGrupo());
					arquivoFunc.println(x.getDadosComissionado().getDias());
					arquivoFunc.println(x.getDadosComissionado().getListaVendas().size());
					for(int a = 0; a < x.getDadosComissionado().getListaVendas().size(); a++) {
						arquivoFunc.println(x.getDadosComissionado().getListaVendas().get(a).getDiadaVenda());
						arquivoFunc.println(x.getDadosComissionado().getListaVendas().get(a).getValor());
						arquivoFunc.println(x.getDadosComissionado().getListaVendas().get(a).isContabilizarnoRecibo());
					}
				}
				arquivoFunc.println(x.getBancarios().getBanco());
				arquivoFunc.println(x.getBancarios().getAgencia());
				arquivoFunc.println(x.getBancarios().getOperacao());
				arquivoFunc.println(x.getBancarios().getConta());
				arquivoFunc.println(x.getPontos().size());
				for(int a = 0; a < x.getPontos().size(); a++) {
					arquivoFunc.println(x.getPontos().get(a).getData());
					arquivoFunc.println(x.getPontos().get(a).getHoraEntrada());
					arquivoFunc.println(x.getPontos().get(a).getHoraSaida());
					arquivoFunc.println(x.getPontos().get(a).isEmTurno());
					arquivoFunc.println(x.getPontos().get(a).getHoras());
				}
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
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getTipo());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isViaCorreios());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isEmMaos());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isViaDeposito());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).isSindicato());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getIdentificacao());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getNumeroCasa());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getCep());
			if(Lista.funcionarios.get(x - 1).getTipo() == 0) {
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getSalario());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getBonus());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getdescSind());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getDiscExtra());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getAlicota());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getPagamento());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getGrupo());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosAssalariado().getDias());
			} else if(Lista.funcionarios.get(x - 1).getTipo() == 1) {
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getHoras());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getHorasExtras());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getBonus());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getdescSind());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getDiscExtra());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getAlicota());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getSalarioHora());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getPagamento());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosHorista().getGrupo());
			} else {
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getBonus());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getVendas());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getdescSind());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getSalario());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getDiscExtra());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getAlicota());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getComissao());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getPagamento());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getGrupo());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getDias());
				arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getListaVendas().size());
				for(int a = 0; a < Lista.funcionarios.get(x - 1).getDadosComissionado().getListaVendas().size(); a++) {
					arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getListaVendas().get(a).getDiadaVenda());
					arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getListaVendas().get(a).getValor());
					arquivoFunc.println(Lista.funcionarios.get(x - 1).getDadosComissionado().getListaVendas().get(a).isContabilizarnoRecibo());
				}
			}
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getBanco());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getAgencia());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getOperacao());
			arquivoFunc.println(Lista.funcionarios.get(x - 1).getBancarios().getConta());
			arquivoFunc.println("0");
			arquivoFunc.flush();
			arquivoFunc.close();
			Funci.close();
		}
	}	
}
