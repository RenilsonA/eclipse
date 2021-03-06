package Geral;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Administrativo.Listar;
import Financeiro.Financeiro;
import Ponto.Pontos;
import UnRe.Confirma??o;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Inicio {
	Funcoes fuctions = new Funcoes();
	public JFrame admin;
	static boolean ler = true;
	public static String endereco = "C:\\Users\\renil\\Desktop\\ProjetoFuncionario\\";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.admin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Inicio() {
		if(ler == true) {
			try {
				Lista lista = new Lista();
				lista.Ler(endereco);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ler = false;
		}
		initialize();
	}
	public void initialize(){
		admin = new JFrame();
		admin.setBounds(0, 0, 854, 480);
		admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		admin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Funcion\u00E1rios");
		lblNewLabel.setBounds(0, 11, 838, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		admin.getContentPane().add(lblNewLabel);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(admin, "Voc? realmente quer sair?",
						"Sistema de Gerenciamento dos Funcion?rios", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					admin.dispose();
				}
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnFechar.setBounds(347, 358, 143, 57);
		admin.getContentPane().add(btnFechar);
		
		JButton btnFuncionrios = new JButton("Administrativo");
		btnFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar listar = new Listar();
				admin.dispose();
				listar.lista.setVisible(true);
			}
		});
		btnFuncionrios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnFuncionrios.setBounds(317, 86, 204, 57);
		admin.getContentPane().add(btnFuncionrios);
		
		JButton btnFinanceiro = new JButton("Financeiro");
		btnFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Financeiro l = new Financeiro();
				admin.dispose();
				l.listaFin.setVisible(true);
			}
		});
		btnFinanceiro.setFont(new Font("Arial", Font.PLAIN, 25));
		btnFinanceiro.setBounds(317, 154, 204, 57);
		admin.getContentPane().add(btnFinanceiro);
		
		JButton btnPontos = new JButton("Pontos");
		btnPontos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pontos p = new Pontos();
				admin.dispose();
				p.pontos.setVisible(true);
			}
		});
		btnPontos.setFont(new Font("Arial", Font.PLAIN, 25));
		btnPontos.setBounds(317, 222, 204, 57);
		admin.getContentPane().add(btnPontos);
		
		JButton btnRedesfazer = new JButton("Re/Desfazer");
		btnRedesfazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirma??o confi = new Confirma??o();
				confi.frame.setVisible(true);
			}
		});
		btnRedesfazer.setFont(new Font("Arial", Font.PLAIN, 25));
		btnRedesfazer.setBounds(317, 290, 204, 57);
		admin.getContentPane().add(btnRedesfazer);
	}
}
