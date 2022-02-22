package UnRe;

import java.io.IOException;
import ClassesArray.ConfiguracaoGlobal;
import ClassesArray.Funcionarios;
import ClassesArray.Ponto;
import ClassesArray.Vendas;
import Geral.Lista;

public class UnReFuncoes {
	private static Originator voltarO = new Originator();
	private static CareTaker Voltar = new CareTaker(voltarO);
	private static Originator irO = new Originator();
	private static CareTaker Ir = new CareTaker(irO);
	
	public int TamanhoVoltar() {
		return Voltar.tamanho();
	}
	
	public int TamanhoIr() {
		return Ir.tamanho();
	}
	
	public void setVoltar(Funcionarios func, int caso) {
		for(int a = 0; a < Ir.tamanho(); a++) Ir.Remover(); 
		Voltar.SaveState(func, caso);
	}
	
	public void setVoltarConfig(Auxilio CG, int caso) {
		for(int a = 0; a < Ir.tamanho(); a++) Ir.Remover(); 
		Voltar.SaveStateC(CG, caso);
	}
	
	public void setVoltarV(Vendas v, int caso) {
		for(int a = 0; a < Ir.tamanho(); a++) Ir.Remover(); 
		Voltar.SaveStateV(v, caso);
	}
	
	public void setVoltarP(Ponto p, int caso) {
		for(int a = 0; a < Ir.tamanho(); a++) Ir.Remover(); 
		Voltar.SaveStateP(p, caso);
	}
	
	public void FuncoesVoltar() {
		if(Voltar.tamanho() > 0) {
			int caso = Voltar.Caso();
			int ir = 0;
			Lista lista = new Lista();
			Funcionarios T = null;
			Auxilio CG = null;
			Ponto p = null;
			if(Voltar.DevolverUltimo() != null) T = func(Voltar.DevolverUltimo());
			else if(Voltar.DevolverUltimoConfig() != null) CG = Voltar.DevolverUltimoConfig();
			else if(Voltar.DevolverUltimoP() != null) p = Voltar.DevolverUltimoP();
			if(caso == 1) {											//remover Func
				Lista.funcionarios.remove(Lista.funcionarios.size() - 1);							
				ir = 2;
				Voltar.Remover();
				Ir.SaveState(T, ir);
			}
			else if(caso == 2) {									//adicionar Func
				Lista.funcionarios.add(T);	
				ir = 1;
				Voltar.Remover();
				Ir.SaveState(T, ir);
			}
			else if(caso == 3) {									//Modificar Func	
				int x = lista.posicao(T.getID());
				Ir.SaveState(Lista.funcionarios.get(x), 3);
				Lista.funcionarios.get(x).modificacao(T);
				Voltar.Remover();
			}
			else if(caso == 4) {									//Modificar ConfigGlobais	
				Ir.SaveStateC(new Auxilio(ConfiguracaoGlobal.getComissao(), ConfiguracaoGlobal.getTaxadeAlicota(),
							  ConfiguracaoGlobal.getTaxadeSindicato()), 4);
				ConfiguracaoGlobal.setComissao(CG.getComissao());
				ConfiguracaoGlobal.setTaxadeAlicota(CG.getTaxadeAlicota());
				ConfiguracaoGlobal.setTaxadeSindicato(CG.getTaxadeSindicato());	
				lista.Setar(ConfiguracaoGlobal.getComissao(), ConfiguracaoGlobal.getTaxadeAlicota(), ConfiguracaoGlobal.getTaxadeSindicato());
				Voltar.Remover();
				
				lista.Setar(ConfiguracaoGlobal.getComissao(), ConfiguracaoGlobal.getTaxadeAlicota(), ConfiguracaoGlobal.getTaxadeSindicato());
			}
			else if(caso == 5) {
				int x = lista.posicao(p.getId());
				int y = Lista.funcionarios.get(x).getPontos().size() - 1;
				Ir.SaveStateP(Lista.funcionarios.get(x).getPontos().get(y), 5);
				if(Lista.funcionarios.get(x).getPontos().get(y).isEmTurno()) Lista.funcionarios.get(x).getPontos().remove(y);
				else {
					float z = Lista.funcionarios.get(x).getPontos().get(Lista.funcionarios.get(x).getPontos().size() - 1).getHoras();
					Lista.funcionarios.get(x).getPontos().get(y).setEmTurno(true);
					Lista.funcionarios.get(x).getPontos().get(y).setHoraSaida(" ");
					lista.Pontos(x);
					if(Lista.funcionarios.get(x).getTipo() == 0) 
						Lista.funcionarios.get(x).getDadosAssalariado().setDias(Lista.funcionarios.get(x).getDadosAssalariado().getDias() - 1);
					else if(Lista.funcionarios.get(x).getTipo() == 1) { 
						if(z > 8) {
							Lista.funcionarios.get(x).getDadosHorista().setHoras(Lista.funcionarios.get(x).getDadosHorista().getHoras() - 8);
							Lista.funcionarios.get(x).getDadosHorista().setHorasExtras(Lista.funcionarios.get(x).getDadosHorista().getHorasExtras() - y + 8);
						} else {
							Lista.funcionarios.get(x).getDadosHorista().setHoras(Lista.funcionarios.get(x).getDadosHorista().getHoras() - y);
						}
					} else if(Lista.funcionarios.get(x).getTipo() == 2) { 
						Lista.funcionarios.get(x).getDadosComissionado().setDias(Lista.funcionarios.get(x).getDadosComissionado().getDias() - 1);
					}
				}
				Voltar.Remover();
			}
			else if(caso == 6) {
				int x = lista.posicao(T.getID());
				int y = Lista.funcionarios.get(x).getDadosComissionado().getListaVendas().size() - 1;
				Lista.funcionarios.get(x).getDadosComissionado().getListaVendas().get(y).setId(Lista.funcionarios.get(x).getID());
				Ir.SaveStateV(Lista.funcionarios.get(x).getDadosComissionado().getListaVendas().get(y), 6);
				Lista.funcionarios.get(x).getDadosComissionado().removeVenda();
				Voltar.Remover();
			}
			try {
				lista.Salvar(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void FuncoesIr() {
		if(Ir.tamanho() > 0) {
			int caso = Ir.Caso();
			int ir = 0;
			Lista lista = new Lista();
			Funcionarios T = null;
			Auxilio CG = null;
			Ponto p = null;
			if(Ir.DevolverUltimo() != null) T = func(Ir.DevolverUltimo());
			else if(Ir.DevolverUltimoConfig() != null) CG = Ir.DevolverUltimoConfig();
			else if(Ir.DevolverUltimoP() != null) p = Voltar.DevolverUltimoP();
			if(caso == 1) {											//remover Func
				Lista.funcionarios.remove(Lista.funcionarios.size() - 1);						
				ir = 2;
				Ir.Remover();
				Voltar.SaveState(T, ir);
			}
			else if(caso == 2) {									//adicionar Func
				Lista.funcionarios.add(T);	
				ir = 1;
				Ir.Remover();
				Voltar.SaveState(T, ir);
			}
			else if(caso == 3) {									//Modificar Func
				int x = lista.posicao(T.getID());
				Voltar.SaveState(Lista.funcionarios.get(x), 3);
				Lista.funcionarios.get(x).modificacao(T);
				Ir.Remover();
			}
			else if(caso == 4) {									//Modificar ConfigGlobais
				Voltar.SaveStateC(new Auxilio(ConfiguracaoGlobal.getComissao(), ConfiguracaoGlobal.getTaxadeAlicota(), 
								  ConfiguracaoGlobal.getTaxadeSindicato()), 4);
				ConfiguracaoGlobal.setComissao(CG.getComissao());
				ConfiguracaoGlobal.setTaxadeAlicota(CG.getTaxadeAlicota());
				ConfiguracaoGlobal.setTaxadeSindicato(CG.getTaxadeSindicato());
				lista.Setar(ConfiguracaoGlobal.getComissao(), ConfiguracaoGlobal.getTaxadeAlicota(), ConfiguracaoGlobal.getTaxadeSindicato());
				Ir.Remover();
				lista.Setar(ConfiguracaoGlobal.getComissao(), ConfiguracaoGlobal.getTaxadeAlicota(), ConfiguracaoGlobal.getTaxadeSindicato());
			}
			else if(caso == 5) {
				int x = lista.posicao(p.getId());
				int y = Lista.funcionarios.get(x).getPontos().size() - 1;
				Voltar.SaveStateP(Lista.funcionarios.get(x).getPontos().get(y), 5);
				if(p.isEmTurno()) Lista.funcionarios.get(x).getPontos().add(p);
				else {
					float z = p.getHoras();
					Lista.funcionarios.get(x).getPontos().get(y).setEmTurno(false);
					Lista.funcionarios.get(x).getPontos().get(y).setHoraSaida(p.getHoraSaida());
					lista.Pontos(x);
					if(Lista.funcionarios.get(x).getTipo() == 0) 
						Lista.funcionarios.get(x).getDadosAssalariado().setDias(Lista.funcionarios.get(x).getDadosAssalariado().getDias() + 1);
					else if(Lista.funcionarios.get(x).getTipo() == 1) { 
						if(z > 8) {
							Lista.funcionarios.get(x).getDadosHorista().setHoras(Lista.funcionarios.get(x).getDadosHorista().getHoras() + 8);
							Lista.funcionarios.get(x).getDadosHorista().setHorasExtras(Lista.funcionarios.get(x).getDadosHorista().getHorasExtras() + y - 8);
						} else {
							Lista.funcionarios.get(x).getDadosHorista().setHoras(Lista.funcionarios.get(x).getDadosHorista().getHoras() + y);
						}
					} else if(Lista.funcionarios.get(x).getTipo() == 2) { 
						Lista.funcionarios.get(x).getDadosComissionado().setDias(Lista.funcionarios.get(x).getDadosComissionado().getDias() + 1);
					}
				}
				Ir.Remover();
			}
			else if(caso == 6) {
				int x = lista.posicao(Ir.DevolverUltimoV().getId());
				Voltar.SaveStateV(Ir.DevolverUltimoV(), 6);
				Lista.funcionarios.get(x).getDadosComissionado().addListaVendas(Ir.DevolverUltimoV());
				Ir.Remover();
			}
			try {
				lista.Salvar(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Funcionarios func(FuncionariosAux func) {	
		Funcionarios f = new Funcionarios(func.getID(), func.getNome(), func.getEndereco(), func.getTipo(), func.isViaCorreios(), func.isEmMaos(),
						 func.isViaDeposito(), func.isSindicato(), func.getIdentificacao(), func.getNumeroCasa(), func.getCep(),
						 func.getDadosAssalariado(), func.getDadosComissionado(), func.getDadosHorista(), func.getBancarios());
		return f;
	}
}
