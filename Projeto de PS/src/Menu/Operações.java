package Menu;


public class Funcionarios {
	
	int ID;
	String nome;
	String atributo;
	String endereco;
	String tipo;
		
	public Funcionarios(int id, String Nome, String Atributo, String Endereco, String Tipo) {
		this.ID = id;
		this.nome = Nome;
		this.atributo = Atributo;
		this.endereco = Endereco;
		this.tipo = Tipo;
	}
	
	public Funcionarios(int id) {
		this.ID = 0;
		this.nome = "";
		this.atributo = "";
		this.endereco = "";
		this.tipo = "";
	}
}
