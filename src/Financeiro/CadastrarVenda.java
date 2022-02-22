package Financeiro;

import javax.swing.JFrame;
import javax.swing.JTextField;
import Geral.Funcoes;
import Geral.Lista;
import Geral.Tempo;
import UnRe.UnReFuncoes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import ClassesArray.Vendas;
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
	private JTextField Data;
	
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
		
		Data = new JTextField();
		Data.setFont(new Font("Arial", Font.PLAIN, 20));
		Data.setColumns(10);
		Data.setBounds(291, 161, 141, 30);
		CVenda.getContentPane().add(Data);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data da Venda");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(140, 161, 141, 30);
		CVenda.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("dd/mm/aaaa");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(442, 161, 141, 30);
		CVenda.getContentPane().add(lblNewLabel_1_1_1);
		
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CVenda.dispose();
			}
		}); 
		
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Data.getText().charAt(0) == '3' && Data.getText().charAt(1) > '1') || Data.getText().charAt(0) >= 52) {
					Data.setText("");
					JOptionPane.showMessageDialog(Data, "Preencha com uma data válida", "Erro", 0, null);
				} else if(Data.getText().charAt(3) >= '1' || Data.getText().charAt(4) >= '3'){
					Data.setText("");
					JOptionPane.showMessageDialog(Data, "Preencha com uma data válida", "Erro", 0, null);
				} else if(!textField.getText().isEmpty()) {
					Lista lista = new Lista();
					Tempo tempo = new Tempo();
					LocalDate x = tempo.StringparaData(Data.getText());
					UnReFuncoes un = new UnReFuncoes();
					un.setVoltar(Lista.funcionarios.get(lista.posicao(index)), 6);
					Lista.funcionarios.get(lista.posicao(index)).getDadosComissionado().addListaVendas(new Vendas(x, Float.parseFloat(textField.getText()), true));
					CVenda.dispose();
					try {
						lista.Salvar(true);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		Data.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.NumerosPData(e);
				if(Data.getText().length() == 2 && Data.getText().length() == 5) Data.setText(Data.getText() + '/');
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
