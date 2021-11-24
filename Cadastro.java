package Programas;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Cadastro {
	Funcoes fuctions = new Funcoes();
	public JFrame Cadastrar;
	private JTextField nome;
	private JTextField endereco;
	public Cadastro() {
		initialize();
	}
	
	public void initialize(){	
		Cadastrar = new JFrame();
		Cadastrar.setBounds(0, 0, 1280, 720);
		Cadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Cadastrar.getContentPane().setLayout(null);
		
		nome = new JTextField();
		nome.setFont(new Font("Arial", Font.PLAIN, 25));
		nome.setBounds(50, 133, 1150, 45);
		Cadastrar.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel.setBounds(50, 87, 193, 35);
		Cadastrar.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Funcion\u00E1rio");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(398, 11, 359, 65);
		Cadastrar.getContentPane().add(lblNewLabel_1);
		
		endereco = new JTextField();
		endereco.setFont(new Font("Arial", Font.PLAIN, 25));
		endereco.setColumns(10);
		endereco.setBounds(50, 235, 575, 45);
		Cadastrar.getContentPane().add(endereco);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 35));
		lblEndereo.setBounds(50, 189, 193, 35);
		Cadastrar.getContentPane().add(lblEndereo);
		
		JLabel lblTipoDe = new JLabel("Remunera\u00E7\u00E3o");
		lblTipoDe.setFont(new Font("Arial", Font.PLAIN, 35));
		lblTipoDe.setBounds(50, 291, 261, 35);
		Cadastrar.getContentPane().add(lblTipoDe);
		
		final JComboBox remuneracao = new JComboBox();
		remuneracao.setFont(new Font("Arial", Font.PLAIN, 25));
		remuneracao.setModel(new DefaultComboBoxModel(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		remuneracao.setBounds(50, 336, 575, 45);
		Cadastrar.getContentPane().add(remuneracao);
		remuneracao.addItem("1. Salário horário");
		remuneracao.addItem("2. Salário mensal");
		remuneracao.addItem("3. Comissão");
		
		final JComboBox atributo = new JComboBox();
		atributo.setFont(new Font("Arial", Font.PLAIN, 25));
		atributo.setModel(new DefaultComboBoxModel(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		atributo.setBounds(635, 336, 575, 45);
		Cadastrar.getContentPane().add(atributo);
		atributo.addItem("1. Horista");
		atributo.addItem("2. Salariado");
		atributo.addItem("3. Comissionado");
		
		JLabel lblAtributo = new JLabel("Atributo Associado");
		lblAtributo.setFont(new Font("Arial", Font.PLAIN, 35));
		lblAtributo.setBounds(635, 291, 388, 35);
		Cadastrar.getContentPane().add(lblAtributo);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nome.getText() != null && endereco.getText() != null && 
					atributo.getSelectedIndex() > 0 && remuneracao.getSelectedIndex() > 0) {
					
						if (JOptionPane.showConfirmDialog(Cadastrar, "Os dados abaixo estão corretos?\nNome: " +
								nome.getText() + "\nEndereço: " + endereco.getText() + "\nAtributo tipo: " +
								atributo.getSelectedIndex() + "\nRemuneração tipo: " + remuneracao.getSelectedIndex(), 
								"Cadastro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
								
							
							Inicio ini = new Inicio();
							Funcionarios novo = new Funcionarios(ini.id, nome.getText(), endereco.getText(), 
												 				 atributo.getSelectedIndex(), remuneracao.getSelectedIndex());
							ini.lista.add(novo);			
								
							nome.setText("");
							endereco.setText("");
							atributo.setSelectedIndex(0);
							remuneracao.setSelectedIndex(0);
									
							if (!(JOptionPane.showConfirmDialog(Cadastrar, "Deseja cadastrar outro funcionário?", 
							    	"Cadastrar novamente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
								Cadastrar.dispose();
								Selecao selecao = new Selecao();
								selecao.Funcionarios.setVisible(true);
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(btnCadastrar, "Preencha todos os campos", "Erro", 0, null);
					}
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCadastrar.setBounds(393, 618, 232, 52);
		Cadastrar.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Cadastrar, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Cadastrar.dispose();
					Selecao selecao = new Selecao();
					selecao.Funcionarios.setVisible(true);
				}
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCancelar.setBounds(635, 618, 232, 52);
		Cadastrar.getContentPane().add(btnCancelar);
	}
}
