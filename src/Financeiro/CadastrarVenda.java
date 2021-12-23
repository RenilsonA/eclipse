package Financeiro;

import javax.swing.JFrame;
import javax.swing.JTextField;
import Geral.Funcoes;
import Geral.Tempo;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JButton;

public class CadastrarVenda {
	public JFrame CVenda;
	private JTextField textField;
	
	public CadastrarVenda(int index) {
		Initialize(index);
	}

	public void Initialize(final int index) {		
		CVenda = new JFrame();
		CVenda.setBounds(0, 0, 640, 350);
		CVenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CVenda.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de vendas do ID " + Integer.toString(index));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 11, 381, 43);
		CVenda.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setBounds(291, 120, 141, 30);
		CVenda.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total da Venda");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(140, 120, 141, 30);
		CVenda.getContentPane().add(lblNewLabel_1);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 20));
		Cadastrar.setBounds(172, 257, 134, 43);
		CVenda.getContentPane().add(Cadastrar);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		Cancelar.setBounds(316, 257, 134, 43);
		CVenda.getContentPane().add(Cancelar);
		
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CVenda.dispose();
			}
		});
		
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()) {
					Tempo t = new Tempo();
					Listas l = new Listas();
					Listas.vendas.add(new Vendas(index, LocalDate.parse(t.Ano()+"-"+t.Mes()+"-"+t.DiadoMes()), Float.parseFloat(textField.getText())));
					Listas.comissionados.get(l.posicao(2, index)).setVendas(Float.parseFloat(textField.getText()) + Listas.comissionados.get(l.posicao(2, index)).getVendas());
					CVenda.dispose();
					try {
						l.SalvarVendas();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
	}
}
