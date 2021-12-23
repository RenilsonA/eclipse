package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Geral.Funcoes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CadastroBancario {
	public JFrame CBancario;
	private JTextField banco;
	private JTextField agencia;
	private JTextField operacao;
	private JTextField conta;
	private JTextField id;
	
	public CadastroBancario() {
		Initialize();
	}
	
	private void Initialize() {
		CBancario = new JFrame();
		CBancario.setBounds(0, 0, 640, 410);
		CBancario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CBancario.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro Bancario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(203, 11, 218, 32);
		CBancario.getContentPane().add(lblNewLabel);
		
		banco = new JTextField();
		banco.setFont(new Font("Arial", Font.PLAIN, 16));
		banco.setBounds(261, 140, 187, 32);
		CBancario.getContentPane().add(banco);
		banco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Banco");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(117, 140, 134, 32);
		CBancario.getContentPane().add(lblNewLabel_1);
		
		agencia = new JTextField();
		agencia.setFont(new Font("Arial", Font.PLAIN, 16));
		agencia.setColumns(10);
		agencia.setBounds(261, 183, 187, 32);
		CBancario.getContentPane().add(agencia);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ag\u00EAncia");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(117, 183, 134, 32);
		CBancario.getContentPane().add(lblNewLabel_1_1);
		
		operacao = new JTextField();
		operacao.setFont(new Font("Arial", Font.PLAIN, 16));
		operacao.setColumns(10);
		operacao.setBounds(261, 226, 187, 32);
		CBancario.getContentPane().add(operacao);
		
		JLabel lblNewLabel_1_2 = new JLabel("Opera\u00E7\u00E3o");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(117, 226, 134, 32);
		CBancario.getContentPane().add(lblNewLabel_1_2);
		
		conta = new JTextField();
		conta.setFont(new Font("Arial", Font.PLAIN, 16));
		conta.setColumns(10);
		conta.setBounds(261, 269, 187, 32);
		CBancario.getContentPane().add(conta);
		
		JLabel lblNewLabel_1_3 = new JLabel("Conta");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(117, 269, 89, 32);
		CBancario.getContentPane().add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(172, 312, 126, 48);
		CBancario.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(308, 312, 126, 48);
		CBancario.getContentPane().add(btnCancelar);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(10, 54, 515, 42);
		CBancario.getContentPane().add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Funcion\u00E1rios"}));
		
		JButton btnIr = new JButton("Ir");
		btnIr.setFont(new Font("Arial", Font.PLAIN, 16));
		btnIr.setBounds(535, 54, 77, 44);
		CBancario.getContentPane().add(btnIr);
		
		agencia.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.NumerosCEspaco(e);
			}
		});
		operacao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.NumerosCEspaco(e);
			}
		});
		conta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.NumerosCEspaco(e);
			}
		});
		
		id = new JTextField();
		id.setEditable(false);
		id.setFont(new Font("Arial", Font.PLAIN, 16));
		id.setColumns(10);
		id.setBounds(525, 13, 89, 32);
		CBancario.getContentPane().add(id);
		for(int a = 0; a < Listas.dadosBancarios.size(); a++) {
			comboBox.addItem(Integer.toString(Listas.dadosBancarios.get(a).getId()));
		}
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() > 0) {
					int index = comboBox.getSelectedIndex() - 1;
					id.setText(Integer.toString(Listas.dadosBancarios.get(index).getId()));
					banco.setText(Listas.dadosBancarios.get(index).getBanco()); 
					agencia.setText(Integer.toString(Listas.dadosBancarios.get(index).getAgencia())); 
					operacao.setText(Integer.toString(Listas.dadosBancarios.get(index).getOperacao())); 
					conta.setText(Integer.toString(Listas.dadosBancarios.get(index).getConta())); 
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CBancario, "Você realmente quer sair?",
						"Cadastro bancário dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					CBancario.dispose();
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CBancario, "Os dados estão corretos?",
						"Cadastro bancário dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					int index = comboBox.getSelectedIndex() - 1;
					if(!banco.getText().isEmpty()) Listas.dadosBancarios.get(index).setBanco(banco.getText());
					if(!agencia.getText().isEmpty()) Listas.dadosBancarios.get(index).setAgencia(Integer.parseInt(agencia.getText()));
					if(!operacao.getText().isEmpty()) Listas.dadosBancarios.get(index).setOperacao(Integer.parseInt(operacao.getText()));
					if(!conta.getText().isEmpty()) Listas.dadosBancarios.get(index).setConta(Integer.parseInt(conta.getText()));;
					CBancario.dispose();
				}
			}
		});
	}
}
