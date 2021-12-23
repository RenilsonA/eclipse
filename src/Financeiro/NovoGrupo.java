package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Geral.Agenda;
import Geral.Funcoes;
import Geral.Lista;
import Geral.Tempo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class NovoGrupo {
	public JFrame grupo;
	private JTextField textField;
	private JTextField textField_1;
	
	public NovoGrupo() {
		Initialize();
	}
	
	public void Initialize() {
		grupo = new JFrame();
		grupo.setBounds(0, 0, 680, 380);
		grupo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grupo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Criar novo grupo");
		lblNewLabel.setBounds(225, 11, 214, 49);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		grupo.getContentPane().add(lblNewLabel);
		
		JButton btnGerar = new JButton("Criar");
		btnGerar.setBounds(136, 281, 189, 49);
		btnGerar.setFont(new Font("Arial", Font.PLAIN, 22));
		grupo.getContentPane().add(btnGerar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(338, 281, 189, 49);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.dispose();
				Pagamentos p = new Pagamentos();
				p.pagamentos.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 22));
		grupo.getContentPane().add(btnVoltar);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 22));
		textField.setBounds(153, 87, 343, 41);
		grupo.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(57, 84, 86, 41);
		grupo.getContentPane().add(lblNewLabel_1);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 22));
		comboBox.setBounds(153, 139, 343, 38);
		grupo.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dia");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(57, 136, 86, 41);
		grupo.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Per\u00EDodo");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(57, 188, 86, 41);
		grupo.getContentPane().add(lblNewLabel_1_1_1);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"0 - Selecione uma das opções:"}));
		comboBox.addItem("Segunda-Feira");
		comboBox.addItem("Terça-Feira");
		comboBox.addItem("Quarta-Feira");
		comboBox.addItem("Quinta-Feira");
		comboBox.addItem("Sexta-Feira");
		comboBox.addItem("Periódico");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 188, 343, 41);
		grupo.getContentPane().add(textField_1);
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.ApenasNumeros(e);
			}
		});
		
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tempo tempo = new Tempo();
				LocalDate dia;
				if(tempo.Dia() != comboBox.getSelectedItem() && comboBox.getSelectedIndex() < 6)
					dia = LocalDate.now().plusDays(Integer.parseInt(textField_1.getText()) + tempo.DiaemNumero() + comboBox.getSelectedIndex());
				else dia = LocalDate.now().plusDays(Integer.parseInt(textField_1.getText()));
				if(comboBox.getSelectedIndex() > 0 && textField.getText() != null && textField_1.getText() != null) {
					if (JOptionPane.showConfirmDialog(grupo, "Os dados estão corretos?\nNome: " + textField.getText() + "\nDia: "+ comboBox.getSelectedItem()
							+ "\nPeríodo: " + textField_1.getText() + "\nPróximo pagamento no dia: " + dia, "Sistema Financeiro dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
						if(comboBox.getSelectedIndex() < 6) Lista.grupos.add(new Agenda(textField.getText(), dia, Integer.parseInt(textField_1.getText()), tempo.Dia()));
						else Lista.grupos.add(new Agenda(textField.getText(), dia, Integer.parseInt(textField_1.getText()), "Periódico"));
						Lista l = new Lista();
						Lista.setQuantGrupos(Lista.grupos.size());
						try {
							l.Salvar(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						grupo.dispose();
						Pagamentos p = new Pagamentos();
						p.pagamentos.setVisible(true);
					}
				}
			}
		});
	}
}
