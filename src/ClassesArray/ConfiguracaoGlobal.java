package ClassesArray;

public class ConfiguracaoGlobal {
	public static float comissao = 10;
	public static float taxadeAlicota = 10;
	public static float taxadeSindicato = 5;
	
	public ConfiguracaoGlobal(float d, float e, float f) {
		ConfiguracaoGlobal.comissao = d;
		ConfiguracaoGlobal.taxadeAlicota = e;
		ConfiguracaoGlobal.taxadeSindicato = f;
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
}
