package Menu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio {
	Funções fuctions = new Funções();
	
	public JFrame Inicia;
	
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Inicio window = new Inicio();
	 * window.Inicia.setVisible(true); } catch (Exception e) { e.printStackTrace();
	 * } } }); }
	 */
	
	public void Sair() {
		Inicia = new JFrame("Sair");
		if (JOptionPane.showConfirmDialog(Inicia, "Você realmente quer sair?",
			"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}
	
	public Inicio() {
		initialize();
	}
	
	public void initialize(){
		Inicia = new JFrame();
		Inicia.setBounds(0, 0, 854, 480);
		Inicia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Inicia.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Funcion\u00E1rios");
		lblNewLabel.setBounds(0, 36, 838, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		Inicia.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Funcion\u00E1rios");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Seleção chama = new Seleção();
				Inicia.dispose();
				chama.Funcionarios.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(50, 330, 178, 47);
		Inicia.getContentPane().add(btnNewButton);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuctions.Fechar();
				Inicia.dispose();
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFechar.setBounds(667, 330, 111, 47);
		Inicia.getContentPane().add(btnFechar);
	}
}
