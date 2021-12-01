package Programas;

public class Funcionarios {
	
	private int ID;
	private String nome;
	private String endereco;
	private String atributo;
	private String tipo;
	private int sindicato;
	private String TaxaDoSindicato;
	private String Identificacao;

	public Funcionarios(int id, String Nome, String Endereco, int Atributo, int Tipo, int Condicao, String taxa, String identificacao) {		
		this.ID = id;
		this.nome = Nome;
		this.endereco = Endereco;
		if (Atributo == 1) this.atributo = "Horista";
		else if (Atributo == 2) this.atributo = "Salariado";
		else this.atributo = "Comissionado";
		if (Tipo == 1) this.tipo = "Salário horário";
		else if (Tipo == 2) this.tipo = "Salário mensal";
		else this.tipo = "Comissão";
		this.sindicato = Condicao;
		this.TaxaDoSindicato = taxa;
		this.Identificacao = identificacao;
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

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getSindicato() {
		return sindicato;
	}

	public void setSindicato(int sindicato) {
		this.sindicato = sindicato;
	}

	public String getTaxaDoSindicato() {
		return TaxaDoSindicato;
	}

	public void setTaxaDoSindicato(String taxaDoSindicato) {
		TaxaDoSindicato = taxaDoSindicato;
	}

	public String getIdentificacao() {
		return Identificacao;
	}

	public void setIdentificacao(String identificacao) {
		Identificacao = identificacao;
	}
}
