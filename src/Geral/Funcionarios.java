package Geral;

public class Funcionarios {
	
	private int ID;
	private String nome;
	private String endereco;
	private boolean horista;
	private boolean salariado;
	private boolean comissionado;
	private boolean ViaCorreios;
	private boolean EmMaos;
	private boolean ViaDeposito;
	private boolean sindicato;
	private String Identificacao;
	private int grupo;
	private int numero;
	private String cep;

	public Funcionarios(int id, String N, String E, boolean H, boolean S, boolean C, boolean X, boolean Y, boolean Z, boolean Sin, String ident, int gr, int num, String cep) {		
		this.ID = id;
		this.nome = N;
		this.endereco = E;
		this.horista = H;
		this.salariado = S;
		this.comissionado = C;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.grupo = gr;
		this.numero = num;
		this.cep = cep;
	}
	
	public void modificacao(String N, String E, boolean H, boolean S, boolean C, boolean X, boolean Y, boolean Z, boolean Sin, String ident, int num, String cep) {		
		this.nome = N;
		this.endereco = E;
		this.horista = H;
		this.salariado = S;
		this.comissionado = C;
		this.ViaCorreios = X;
		this.EmMaos = Y;
		this.ViaDeposito = Z;
		this.sindicato = Sin;
		this.Identificacao = ident;
		this.numero = num;
		this.cep = cep;
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
	public boolean isHorista() {
		return horista;
	}
	public void setHorista(boolean horista) {
		this.horista = horista;
	}
	public boolean isSalariado() {
		return salariado;
	}
	public void setSalariado(boolean salariado) {
		this.salariado = salariado;
	}
	public boolean isComissionado() {
		return comissionado;
	}
	public void setComissionado(boolean comissionado) {
		this.comissionado = comissionado;
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
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}
