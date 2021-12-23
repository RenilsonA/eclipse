package Financeiro;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Geral.Funcoes;
import Geral.Lista;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;

public class CGTela {
	public JFrame CGtela;
	Funcoes f = new Funcoes();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public CGTela() {
		Initialize();
	}

	public void Initialize() {		
		CGtela = new JFrame();
		CGtela.setBounds(0, 0, 640, 410);
		CGtela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CGtela.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configura\u00E7\u00E3o Global das taxas e sal\u00E1rios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setBounds(111, 11, 401, 43);
		CGtela.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(305, 77, 131, 27);
		CGtela.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(305, 115, 131, 27);
		CGtela.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(306, 191, 131, 27);
		CGtela.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(306, 229, 131, 27);
		CGtela.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(306, 267, 131, 27);
		CGtela.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("Sal\u00E1rio Mensal");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(147, 77, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sal\u00E1rio Hora");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(146, 115, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Comiss\u00E3o");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(148, 191, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Al\u00EDcota");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(147, 229, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Taxa de Sindicato");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(148, 267, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("(%)");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(447, 191, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("(%)");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(447, 229, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("(%)");
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2.setBounds(447, 267, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2_1_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setBounds(176, 317, 131, 43);
		CGtela.getContentPane().add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.setBounds(314, 317, 131, 43);
		CGtela.getContentPane().add(btnVoltar);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(306, 153, 131, 27);
		CGtela.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sal\u00E1rio Quizenal");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(147, 153, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_1_1);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CGtela, "Você realmente deseja cancelar?",
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					CGtela.dispose();
				}
			}
		});
		
		textField.setText(Float.toString(ConfiguracaoGlobal.getSalarioMensal()));
		textField_1.setText(Float.toString(ConfiguracaoGlobal.getSalarioHora()));
		textField_2.setText(Float.toString(ConfiguracaoGlobal.getComissao()));
		textField_3.setText(Float.toString(ConfiguracaoGlobal.getTaxadeAlicota()));
		textField_4.setText(Float.toString(ConfiguracaoGlobal.getTaxadeSindicato()));
		textField_5.setText(Float.toString(ConfiguracaoGlobal.getSalarioQuizenal()));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CGtela, "Salvar os valores?\nOs valores irão para todos com valores não cadastrados\nSalário Mensal:" + 
						textField.getText() + "\nSalário Hora:" + textField_1.getText() + "\nSalario quinzenal: " + textField_5.getText() + "\nComissão (%): " +
						textField_2.getText() + "\nTaxa de alícota (%): " + textField_3.getText() + "\nTaxa de sindicato (%): " + textField_4.getText(),
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					ConfiguracaoGlobal.setSalarioMensal(Float.parseFloat(textField.getText()));
					ConfiguracaoGlobal.setSalarioHora(Float.parseFloat(textField_1.getText()));
					ConfiguracaoGlobal.setSalarioQuizenal(Float.parseFloat(textField_5.getText()));
					ConfiguracaoGlobal.setComissao(Float.parseFloat(textField_2.getText()));
					ConfiguracaoGlobal.setTaxadeAlicota(Float.parseFloat(textField_3.getText()));
					ConfiguracaoGlobal.setTaxadeSindicato(Float.parseFloat(textField_4.getText()));
					Listas l = new Listas();
					Lista lis = new Lista();
					l.modificacao();
					try {
						l.SalvarAssalariado(true);
						l.SalvarComissionado(true);
						l.SalvarHorista(true);
						lis.Salvar(true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					CGtela.dispose();
				}
			}
		});
		
	}
}
