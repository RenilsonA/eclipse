package UnRe;

public class Auxilio {
	private float comissao;
	private float taxadeAlicota;
	private float taxadeSindicato;
	
	public Auxilio(float d, float e, float f) {
		this.comissao = d;
		this.taxadeAlicota = e;
		this.taxadeSindicato = f;
	}
	
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	public float getTaxadeAlicota() {
		return taxadeAlicota;
	}
	public void setTaxadeAlicota(float taxadeAlicota) {
		this.taxadeAlicota = taxadeAlicota;
	}
	public float getTaxadeSindicato() {
		return taxadeSindicato;
	}
	public void setTaxadeSindicato(float taxadeSindicato) {
		this.taxadeSindicato = taxadeSindicato;
	}
}
