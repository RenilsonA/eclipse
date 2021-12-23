package Ponto;

public class Ponto {
	private int ID;
	private float HorasNormais;
	private float HorasExtras;
	private float HorasNormaisTotal;
	private float HorasExtrasTotal;
	private boolean estado = false; 			//true entrou, false saiu
		
	public Ponto(int id, float horas, float extra, float HNT, float HET, boolean x) {		//inicia
		this.ID = id;
		this.HorasNormais = horas;
		this.HorasExtras = extra;
		this.HorasNormaisTotal = HNT;
		this.HorasExtrasTotal = HET;
		this.estado = x;
	}
	
	public Ponto(int caso) {				//reseta
		if(caso == 0) {						//caso seja Horista
			this.HorasNormaisTotal = 0;
			this.HorasExtrasTotal = 0;
		} else if(caso == 1) {				//caso seja comissionado ou assalariado
			this.HorasNormaisTotal = getHorasNormais();
			this.HorasExtrasTotal = getHorasExtras();
		}
		this.HorasNormais = 0;
		this.HorasExtras = 0;
	}
	
	public void BaterPonto(float horas, int index, boolean Est) {     //em minutos
		if(Est == true) {
			if(index == 0 || index == 2) this.HorasNormais = getHorasNormais() + 1;
			else this.HorasNormais = horas;
		} else {
			if(index == 1) {
				this.HorasNormaisTotal = horas - getHorasNormais() + getHorasNormaisTotal();
				if(horas - getHorasNormais() > 480) this.HorasExtrasTotal = getHorasExtras() + getHorasNormais() - 480;
				this.HorasNormais = 0;
			} 
		}
		this.estado = Est;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public float getHorasNormais() {
		return HorasNormais;
	}
	
	public void setHorasNormais(float horasNormais) {
		HorasNormais = horasNormais;
	}
	
	public float getHorasExtras() {
		return HorasExtras;
	}
	
	public void setHorasExtras(float horasExtras) {
		HorasExtras = horasExtras;
	}

	public float getHorasNormaisTotal() {
		return HorasNormaisTotal;
	}

	public void setHorasNormaisTotal(float horasNormaisTotal) {
		HorasNormaisTotal = horasNormaisTotal;
	}

	public float getHorasExtrasTotal() {
		return HorasExtrasTotal;
	}

	public void setHorasExtrasTotal(float horasExtrasTotal) {
		HorasExtrasTotal = horasExtrasTotal;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}	
	
	
}
