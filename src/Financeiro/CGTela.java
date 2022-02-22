package Financeiro;

import javax.swing.JFrame;
import javax.swing.JTextField;
import ClassesArray.ConfiguracaoGlobal;
import Geral.Funcoes;
import Geral.Lista;
import UnRe.Auxilio;
import UnRe.UnReFuncoes;
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
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public CGTela() {
		Initialize();
	}

	public void Initialize() {		
		CGtela = new JFrame();
		CGtela.setBounds(0, 0, 640, 310);
		CGtela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CGtela.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configura\u00E7\u00E3o Global das taxas e sal\u00E1rios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setBounds(111, 11, 401, 43);
		CGtela.getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(263, 77, 131, 27);
		CGtela.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(263, 115, 131, 27);
		CGtela.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(263, 153, 131, 27);
		CGtela.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Comiss\u00E3o");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(105, 77, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Al\u00EDcota");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(104, 115, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Taxa de Sindicato");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(105, 153, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("(%)");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(404, 77, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("(%)");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(404, 115, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("(%)");
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2.setBounds(404, 153, 149, 27);
		CGtela.getContentPane().add(lblNewLabel_1_2_1_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setBounds(173, 191, 131, 43);
		CGtela.getContentPane().add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.setBounds(311, 191, 131, 43);
		CGtela.getContentPane().add(btnVoltar);
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
		textField_2.setText(Float.toString(ConfiguracaoGlobal.getComissao()));
		textField_3.setText(Float.toString(ConfiguracaoGlobal.getTaxadeAlicota()));
		textField_4.setText(Float.toString(ConfiguracaoGlobal.getTaxadeSindicato()));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CGtela, "Salvar os valores?\nOs valores irão para todos com valores não cadastrados\nComissão (%): " +
						textField_2.getText() + "\nTaxa de alícota (%): " + textField_3.getText() + "\nTaxa de sindicato (%): " + textField_4.getText(),
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					
					Lista listas = new Lista();
					listas.Setar(Float.parseFloat(textField_2.getText()), Float.parseFloat(textField_3.getText()), Float.parseFloat(textField_4.getText()));
					UnReFuncoes ff = new UnReFuncoes();
					ff.setVoltarConfig(new Auxilio(ConfiguracaoGlobal.getComissao(), ConfiguracaoGlobal.getTaxadeAlicota(),
									   ConfiguracaoGlobal.getTaxadeSindicato()), 4);
					ConfiguracaoGlobal.setComissao(Float.parseFloat(textField_2.getText()));
					ConfiguracaoGlobal.setTaxadeAlicota(Float.parseFloat(textField_3.getText()));
					ConfiguracaoGlobal.setTaxadeSindicato(Float.parseFloat(textField_4.getText()));
					
					try {
						listas.Salvar(true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					CGtela.dispose();
				}
			}
		});
		
	}
}
