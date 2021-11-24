package Programas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Inicio {
	
	Funcoes fuctions = new Funcoes();
	public JFrame Inicia;
	ArrayList<Funcionarios> lista = new ArrayList<Funcionarios>();
	Funcionarios Func = new Funcionarios();
	int id;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.Inicia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				Selecao chama = new Selecao();
				Inicia.dispose();
				chama.Funcionarios.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(357, 193, 178, 47);
		Inicia.getContentPane().add(btnNewButton);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Inicia, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Inicia.dispose();
				}
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFechar.setBounds(392, 383, 111, 47);
		Inicia.getContentPane().add(btnFechar);
	}
}
