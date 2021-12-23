package Financeiro;

public class ConfiguracaoGlobal {
	public static float salarioMensal = 0;
	public static float salarioQuizenal = 0;
	public static float salarioHora = 0;
	public static float comissao = 0;
	public static float taxadeAlicota = 0;
	public static float taxadeSindicato = 0;
	
	public static float getSalarioMensal() {
		return salarioMensal;
	}
	public static void setSalarioMensal(float salarioMensal) {
		ConfiguracaoGlobal.salarioMensal = salarioMensal;
	}
	public static float getSalarioHora() {
		return salarioHora;
	}
	public static void setSalarioHora(float salarioHora) {
		ConfiguracaoGlobal.salarioHora = salarioHora;
	}
	public static float getComissao() {
		return comissao;
	}
	public static void setComissao(float comissao) {
		ConfiguracaoGlobal.comissao = comissao;
	}
	public static float getTaxadeAlicota() {
		return taxadeAlicota;
	}
	public static void setTaxadeAlicota(float taxadeAlicota) {
		ConfiguracaoGlobal.taxadeAlicota = taxadeAlicota;
	}
	public static float getTaxadeSindicato() {
		return taxadeSindicato;
	}
	public static void setTaxadeSindicato(float taxadeSindicato) {
		ConfiguracaoGlobal.taxadeSindicato = taxadeSindicato;
	}
	public static float getSalarioQuizenal() {
		return salarioQuizenal;
	}
	public static void setSalarioQuizenal(float salarioQuizenal) {
		ConfiguracaoGlobal.salarioQuizenal = salarioQuizenal;
	}
}
