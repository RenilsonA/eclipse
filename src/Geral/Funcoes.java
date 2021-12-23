package Geral;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Funcoes{
	private JFrame f;
	
	public void ApenasNumeros (java.awt.event.KeyEvent evento){
		char Numero = evento.getKeyChar();
		if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == '.')) {
			evento.consume();
		}
	}
	
	public void NumerosPCEP (java.awt.event.KeyEvent evento){
		char Numero = evento.getKeyChar();
		if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == '-')) {
			evento.consume();
		}
	}
	
	public void NumerosCEspaco (java.awt.event.KeyEvent evento){
		char Numero = evento.getKeyChar();
		if (!(Character.isDigit(Numero) || Numero == KeyEvent.VK_BACK_SPACE || Numero == KeyEvent.VK_DELETE || Numero == KeyEvent.VK_SPACE)) {
			evento.consume();
		}
	}
		
	public void Confirmar() {
		f = new JFrame("Confirmar?");
		if (JOptionPane.showConfirmDialog(f, "Os dados estão certos?",
				"Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			//TelaPrincipal unidades = new TelaPrincipal();
		}
	}
	
	public void Cancelar() {
		f = new JFrame("Cancelar?");
		if (JOptionPane.showConfirmDialog(f, "Você realmente deseja cancelar?",
				"Cancelar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
		}
	}
	
	public void Concluir() {
		f = new JFrame("Confirmar?");
		if (JOptionPane.showConfirmDialog(f, "Os dados estão certos?",
				"Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			//TelaPrincipal unidades = new TelaPrincipal();
		}
	}
}
