package Ponto;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import ClassesArray.Ponto;
import Geral.Funcoes;
import Geral.Inicio;
import Geral.Lista;
import Geral.Tempo;
import UnRe.UnReFuncoes;

import javax.swing.JTextField;

public class Pontos {
	public JFrame pontos;
	private JTextField ID;
	private JTextField txtHora;
	private JTextField txtDia;
	Tempo t = new Tempo();
	
	public Pontos() {
		initialize();
	}
	public void initialize(){
		pontos = new JFrame();
		pontos.setBounds(0, 0, 720, 480);
		pontos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pontos.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(363, 383, 146, 47);
		pontos.getContentPane().add(btnVoltar);
		
		final JButton btnProximo = new JButton("Registrar");
		btnProximo.setFont(new Font("Arial", Font.PLAIN, 25));
		btnProximo.setBounds(207, 383, 146, 47);
		pontos.getContentPane().add(btnProximo);
		
		JLabel lblNewLabel = new JLabel("Registros de pontos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(186, 11, 323, 47);
		pontos.getContentPane().add(lblNewLabel);
		
		ID = new JTextField();
		ID.setFont(new Font("Arial", Font.PLAIN, 25));
		ID.setBounds(331, 259, 122, 47);
		pontos.getContentPane().add(ID);
		ID.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setFont(new Font("Arial", Font.PLAIN, 25));
		txtHora.setEnabled(false);
		txtHora.setColumns(10);
		txtHora.setBounds(221, 81, 367, 47);
		pontos.getContentPane().add(txtHora);
		
		txtDia = new JTextField();
		txtDia.setEditable(false);
		txtDia.setFont(new Font("Arial", Font.PLAIN, 25));
		txtDia.setEnabled(false);
		txtDia.setColumns(10);
		txtDia.setBounds(221, 142, 367, 47);
		pontos.getContentPane().add(txtDia);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(279, 259, 39, 47);
		pontos.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hora");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(138, 81, 63, 47);
		pontos.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dia");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(138, 142, 47, 47);
		pontos.getContentPane().add(lblNewLabel_1_2);
		
		txtHora.setText(t.Horas());
		txtDia.setText(t.Dia() + ", " + Integer.toString(t.DiadoMes()) + "/" + Integer.toString(t.Mes()) + "/" + Integer.toString(t.Ano()));
		
		ID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pontos, "Voc� realmente deseja sair da �rea dos pontos?",
						"Sistema de ponto dos Funcion�rios", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					pontos.dispose();
					Inicio ini = new Inicio();
					ini.admin.setVisible(true);
				}
			}
		});
		
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lista posic = new Lista();
				int x = posic.posicao(Integer.parseInt(ID.getText()));
				if(x != -1) {
					if(Lista.funcionarios.get(x).getPontos().size() > 0 &&
					   Lista.funcionarios.get(x).getPontos().get(Lista.funcionarios.get(x).getPontos().size() - 1).isEmTurno()) {
						Lista.funcionarios.get(x).getPontos().get(Lista.funcionarios.get(x).getPontos().size() - 1).baterPonto();
						JOptionPane.showMessageDialog(btnProximo, "Seu Turno acabou as: " + t.Horas(), "ID " + ID.getText(), 0, null);
						
						posic.Pontos(x);
						
					}
					else {
						Lista.funcionarios.get(x).getPontos().add(new Ponto());
						JOptionPane.showMessageDialog(btnProximo, "Seu Turno come�ou as: " + t.Horas(), "ID " + ID.getText(), 0, null);
					}
					Lista.funcionarios.get(x).getPontos().get(Lista.funcionarios.get(x).getPontos().size() - 1).setId(Integer.parseInt(ID.getText()));
					UnReFuncoes un = new UnReFuncoes();
					un.setVoltarP(Lista.funcionarios.get(x).getPontos().get(Lista.funcionarios.get(x).getPontos().size() - 1), 5);
					try {
						posic.Salvar(true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}  else {
					JOptionPane.showMessageDialog(btnProximo, "ID incorreto ou n�o consta no sistema", "Erro", 0, null);
				}
			}
		});
	}
}
