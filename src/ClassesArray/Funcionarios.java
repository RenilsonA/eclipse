package ClassesArray;

import java.time.LocalDate;
import java.util.ArrayList;
import Geral.Tempo;

public class Funcionarios {

	private int ID;
	private String nome;
	private String endereco;
	private int Tipo;
	private boolean ViaCorreios;
	private boolean EmMaos;
	private boolean ViaDeposito;
	private boolean sindicato;
	private String Identificacao;
	private int numeroCasa;
	private String cep;
	private Assalariado DadosAssalariado; 
	private Comissionado DadosComissionado;
	private Horista DadosHorista;
	private DadosBancarios bancarios;
	private ArrayList<Ponto> pontos;

	public Funcionarios(int id, String N, String E, int tipo, boolean X, boolean Y, boolean Z, boolean Sin,
						String ident, int num, String cep, String banco, int ag, int ope, String conta) {		
		this.ID = id;
		this.nome = N;
		this.endereco = E;
		this.Tipo = tipo;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.numeroCasa = num;
		this.cep = cep;
		float x = 0;
		if(Sin) x = ConfiguracaoGlobal.getTaxadeSindicato();
		Tempo tempo = new Tempo();
		if(tipo == 0) {
			DadosAssalariado = new Assalariado(0, 0, x, 0, ConfiguracaoGlobal.getTaxadeAlicota(), tempo.UltimoDiaUtil(), 1, 0);
		} else if(tipo == 1) {
			DadosHorista = new Horista(0, 0, 0, x, 0, ConfiguracaoGlobal.getTaxadeAlicota(), 0,
									   LocalDate.now().plusDays(7 - tempo.DiaemNumero() + 6), 2);
		} else {
			DadosComissionado = new Comissionado(0, 0, x, 0, 0,ConfiguracaoGlobal.getTaxadeAlicota(),
								  				 ConfiguracaoGlobal.getComissao(),LocalDate.now().plusDays(14 - tempo.DiaemNumero() + 6), 3, 0);
		}
		bancarios = new DadosBancarios(banco, ag, ope, conta);
		pontos = new ArrayList<Ponto>();
	}
	
	public Funcionarios(int id, String N, String E, int tipo, boolean X, boolean Y, boolean Z, boolean Sin, 
						String ident, int num, String cep, Assalariado Assa, Comissionado Comi, Horista Hori, DadosBancarios bank) {		
		this.ID = id;
		this.nome = N;
		this.endereco = E;
		this.Tipo = tipo;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.numeroCasa = num;
		this.cep = cep;
		if(tipo == 0) {
			DadosAssalariado = Assa;
			pontos = new ArrayList<Ponto>();
		}
		else if(tipo == 1) {
			DadosHorista = Hori;
			pontos = new ArrayList<Ponto>();
		}
		else {
			DadosComissionado = Comi;
			pontos = new ArrayList<Ponto>();
		}
		bancarios = bank;
	}
	
	public void modificacao(String N, String E, int tipo, boolean X, boolean Y, boolean Z, boolean Sin, String ident, 
							int num, String cep, Assalariado Assa, Comissionado Comi, Horista Hori, DadosBancarios bank) {		
		this.nome = N;
		this.endereco = E;
		this.Tipo = tipo;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.numeroCasa = num;
		this.cep = cep;
		if(tipo == 0) {
			DadosAssalariado = Assa;
			pontos = new ArrayList<Ponto>();
		}
		else if(tipo == 1) {
			DadosHorista = Hori;
			pontos = new ArrayList<Ponto>();
		}
		else {
			DadosComissionado = Comi;
			pontos = new ArrayList<Ponto>();
		}
		bancarios = bank;
	}
	
	public void modificacao(Funcionarios F) {	
		this.nome = F.getNome();
		this.endereco = F.getEndereco();
		this.Tipo = F.getTipo();
		this.ViaCorreios = F.isViaCorreios();
		this.EmMaos = F.isEmMaos();
		this.ViaDeposito = F.isViaDeposito();
		this.sindicato = F.isSindicato();
		this.Identificacao = F.getIdentificacao();
		this.numeroCasa = F.getNumeroCasa();
		this.cep = F.getCep();
		if(F.getTipo() == 0) {
			DadosAssalariado = F.getDadosAssalariado();
			pontos = new ArrayList<Ponto>();
		}
		else if(F.getTipo() == 1) {
			DadosHorista = F.getDadosHorista();
			pontos = new ArrayList<Ponto>();
		}
		else {
			DadosComissionado = F.getDadosComissionado();
			pontos = new ArrayList<Ponto>();
		}
		bancarios = F.getBancarios();
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getTipo() {
		return Tipo;
	}
	public void setTipo(int tipo) {
		this.Tipo = tipo;
	}
	public boolean isViaCorreios() {
		return ViaCorreios;
	}
	public void setViaCorreios(boolean viaCorreios) {
		ViaCorreios = viaCorreios;
	}
	public boolean isEmMaos() {
		return EmMaos;
	}
	public void setEmMaos(boolean emMaos) {
		EmMaos = emMaos;
	}
	public boolean isViaDeposito() {
		return ViaDeposito;
	}
	public void setViaDeposito(boolean viaDeposito) {
		ViaDeposito = viaDeposito;
	}
	public boolean isSindicato() {
		return sindicato;
	}
	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}
	public String getIdentificacao() {
		return Identificacao;
	}
	public void setIdentificacao(String identificacao) {
		Identificacao = identificacao;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public ArrayList<Ponto> getPontos() {
		return pontos;
	}
	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}
	public Assalariado getDadosAssalariado() {
		return DadosAssalariado;
	}
	public void setDadosAssalariado(Assalariado dadosAssalariado) {
		DadosAssalariado = dadosAssalariado;
	}
	public Comissionado getDadosComissionado() {
		return DadosComissionado;
	}
	public void setDadosComissionado(Comissionado dadosComissionado) {
		DadosComissionado = dadosComissionado;
	}
	public Horista getDadosHorista() {
		return DadosHorista;
	}
	public void setDadosHorista(Horista dadosHorista) {
		DadosHorista = dadosHorista;
	}
	public DadosBancarios getBancarios() {
		return bancarios;
	}
	public void setBancarios(DadosBancarios bancarios) {
		this.bancarios = bancarios;
	}
}
