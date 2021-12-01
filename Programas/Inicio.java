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
import java.util.Collection;
import java.awt.event.ActionEvent;

public class Inicio {
	
	static Lista lista = new Lista();
	Funcoes fuctions = new Funcoes();
	public JFrame Inicia;
	
	public Lista getLista() {
		return lista;
	}
	public void setLista(Lista lista) {
		Inicio.lista = lista;
	}
	
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
		
		JButton Adicionar = new JButton("Adicionar Funcion\u00E1rios");
		Adicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				Inicia.dispose();
				cadastro.Cadastrar.setVisible(true);
			}
		});
		Adicionar.setFont(new Font("Arial", Font.PLAIN, 15));
		Adicionar.setBounds(50, 164, 212, 47);
		Inicia.getContentPane().add(Adicionar);
		
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
		
		JButton btnRemoverFuncionrios = new JButton("Remover Funcion\u00E1rios");
		btnRemoverFuncionrios.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Remover remove = new Remover();
				Inicia.dispose();
				remove.Remocao.setVisible(true);
			}
		});
		btnRemoverFuncionrios.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRemoverFuncionrios.setBounds(50, 222, 212, 47);
		Inicia.getContentPane().add(btnRemoverFuncionrios);
		
		JButton btnFuncionrios = new JButton("Funcion\u00E1rios");
		btnFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar listar = new Listar();
				Inicia.dispose();
				listar.lista.setVisible(true);
			}
		});
		btnFuncionrios.setFont(new Font("Arial", Font.PLAIN, 15));
		btnFuncionrios.setBounds(50, 106, 212, 47);
		Inicia.getContentPane().add(btnFuncionrios);
	}
}
