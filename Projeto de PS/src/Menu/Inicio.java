package Menu;

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
	
	public JFrame Inicio;
	
	public void Sair() {
		Inicio = new JFrame("Sair");
		if (JOptionPane.showConfirmDialog(Inicio, "Você realmente quer sair?",
			"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}
	
	public Inicio() {
		initialize();
	}
	
	public void initialize(){
		Inicio = new JFrame();
		Inicio.setBounds(0, 0, 854, 480);
		Inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Inicio.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Funcion\u00E1rios");
		lblNewLabel.setBounds(0, 36, 838, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		Inicio.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Funcion\u00E1rios");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Seleção chama = new Seleção();
				Inicio.dispose();
				chama.Funcionarios.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(50, 330, 178, 47);
		Inicio.getContentPane().add(btnNewButton);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuctions.Fechar();
				Inicio.dispose();
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFechar.setBounds(667, 330, 111, 47);
		Inicio.getContentPane().add(btnFechar);
	}
}
