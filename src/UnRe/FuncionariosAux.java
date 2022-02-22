package UnRe;

import java.util.ArrayList;
import ClassesArray.Assalariado;
import ClassesArray.Comissionado;
import ClassesArray.DadosBancarios;
import ClassesArray.Funcionarios;
import ClassesArray.Horista;
import ClassesArray.Ponto;

public class FuncionariosAux {
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
	
	public FuncionariosAux(Funcionarios func) {		
		this.ID = func.getID();
		this.nome = func.getNome();
		this.endereco = func.getEndereco();
		this.Tipo = func.getTipo();
		this.ViaCorreios = func.isViaCorreios();
		this.EmMaos = func.isEmMaos();
		this.ViaDeposito = func.isViaDeposito();
		this.sindicato = func.isSindicato();
		this.Identificacao = func.getIdentificacao();
		this.numeroCasa = func.getNumeroCasa();
		this.cep = func.getCep();
		if(func.getTipo() == 0) {
			DadosAssalariado = func.getDadosAssalariado();
			pontos = func.getPontos();
		}
		else if(func.getTipo() == 1) {
			DadosHorista = func.getDadosHorista();
			pontos = func.getPontos();
		}
		else {
			DadosComissionado = func.getDadosComissionado();
			pontos = func.getPontos();
		}
		bancarios = func.getBancarios();
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
