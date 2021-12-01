package Programas;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Cadastro {
	
	Inicio inicio = new Inicio();
	Funcoes fuctions = new Funcoes();
	public JFrame Cadastrar;
	private JTextField nome;
	private JTextField endereco;
	private JTextField textFieldNomeSindicato;
	private JTextField textFieldTaxas;
	
	public Cadastro() {
		initialize();
	}
	public void initialize(){	
		Cadastrar = new JFrame();
		Cadastrar.setBounds(0, 0, 1280, 800);
		Cadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Cadastrar.getContentPane().setLayout(null);
		
		nome = new JTextField();
		nome.setFont(new Font("Arial", Font.PLAIN, 25));
		nome.setBounds(50, 133, 1150, 45);
		Cadastrar.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome*");
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
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o*");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 35));
		lblEndereo.setBounds(50, 189, 193, 35);
		Cadastrar.getContentPane().add(lblEndereo);
		
		JLabel lblTipoDe = new JLabel("Remunera\u00E7\u00E3o*");
		lblTipoDe.setFont(new Font("Arial", Font.PLAIN, 35));
		lblTipoDe.setBounds(50, 291, 261, 35);
		Cadastrar.getContentPane().add(lblTipoDe);
		
		final JComboBox<String> remuneracao = new JComboBox<String>();
		remuneracao.setFont(new Font("Arial", Font.PLAIN, 25));
		remuneracao.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		remuneracao.setBounds(50, 336, 575, 45);
		Cadastrar.getContentPane().add(remuneracao);
		remuneracao.addItem("1. Salário horário");
		remuneracao.addItem("2. Salário mensal");
		remuneracao.addItem("3. Comissão");
		
		final JComboBox<String> atributo = new JComboBox<String>();
		atributo.setFont(new Font("Arial", Font.PLAIN, 25));
		atributo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		atributo.setBounds(635, 336, 575, 45);
		Cadastrar.getContentPane().add(atributo);
		atributo.addItem("1. Horista");
		atributo.addItem("2. Salariado");
		atributo.addItem("3. Comissionado");
		
		JLabel lblAtributo = new JLabel("Atributo Associado*");
		lblAtributo.setFont(new Font("Arial", Font.PLAIN, 35));
		lblAtributo.setBounds(635, 291, 388, 35);
		Cadastrar.getContentPane().add(lblAtributo);
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCadastrar.setBounds(398, 698, 232, 52);
		Cadastrar.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Cadastrar, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Cadastrar.dispose();
					inicio.Inicia.setVisible(true);
				}
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCancelar.setBounds(640, 698, 232, 52);
		Cadastrar.getContentPane().add(btnCancelar);
		
		JLabel lblSindical = new JLabel("Vinculo com algum sindicato*");
		lblSindical.setFont(new Font("Arial", Font.PLAIN, 35));
		lblSindical.setBounds(50, 392, 473, 35);
		Cadastrar.getContentPane().add(lblSindical);
		
		final JComboBox<String> sindicato = new JComboBox<String>();
		sindicato.setFont(new Font("Arial", Font.PLAIN, 25));
		sindicato.setBounds(211, 437, 121, 45);
		Cadastrar.getContentPane().add(sindicato);
		sindicato.setModel(new DefaultComboBoxModel<String>(new String[] {"Não"}));
		sindicato.addItem("Sim");
		
		JLabel lblIdentificaoNoSindicato = new JLabel("Identifica\u00E7\u00E3o no sindicato");
		lblIdentificaoNoSindicato.setFont(new Font("Arial", Font.PLAIN, 35));
		lblIdentificaoNoSindicato.setBounds(50, 493, 388, 35);
		Cadastrar.getContentPane().add(lblIdentificaoNoSindicato);
		
		textFieldNomeSindicato = new JTextField();
		textFieldNomeSindicato.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldNomeSindicato.setColumns(10);
		textFieldNomeSindicato.setBounds(50, 539, 1150, 45);
		Cadastrar.getContentPane().add(textFieldNomeSindicato);
		
		JLabel lblTaxaDoSindicato_1 = new JLabel("Taxa do sindicato (em %)");
		lblTaxaDoSindicato_1.setFont(new Font("Arial", Font.PLAIN, 35));
		lblTaxaDoSindicato_1.setBounds(635, 392, 388, 35);
		Cadastrar.getContentPane().add(lblTaxaDoSindicato_1);
		
		textFieldTaxas = new JTextField();
		textFieldTaxas.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldTaxas.setColumns(10);
		textFieldTaxas.setBounds(635, 437, 161, 45);
		Cadastrar.getContentPane().add(textFieldTaxas);
		textFieldTaxas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.ApenasNumeros(e);
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				
				if (nome.getText() != null && endereco.getText() != null && 
					atributo.getSelectedIndex() > 0 && remuneracao.getSelectedIndex() > 0) {				
					
						if (JOptionPane.showConfirmDialog(Cadastrar, "Os dados abaixo estão corretos?\nNome: " +
								nome.getText() + "\nEndereço: " + endereco.getText() + "\nAtributo tipo: " +
								atributo.getSelectedIndex() + "\nRemuneração tipo: " + remuneracao.getSelectedIndex()
								 + "\nSindicato? " + sindicato.getSelectedIndex() + "\nTaxa do Sindicato: " + textFieldTaxas.getText()
								 + "\nIdentificação? " + textFieldNomeSindicato.getText(), 
								"Cadastro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

							inicio.lista.setId(inicio.lista.getId() + 1);
							inicio.lista.adicionar(new Funcionarios(inicio.lista.getId(), nome.getText(), endereco.getText(), 
 	  	     		 		        			   atributo.getSelectedIndex(), remuneracao.getSelectedIndex(),
 	  	     		 		        			   sindicato.getSelectedIndex(), textFieldTaxas.getText(),
 	  	     		 		        			   textFieldNomeSindicato.getText()));
							
							nome.setText("");
							endereco.setText("");
							atributo.setSelectedIndex(0);
							remuneracao.setSelectedIndex(0);
									
							if (!(JOptionPane.showConfirmDialog(Cadastrar, "Deseja cadastrar outro funcionário?", 
							    	"Cadastrar novamente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
								Cadastrar.dispose();
								inicio.Inicia.setVisible(true);
							}
						}
					}
				else {
					JOptionPane.showMessageDialog(btnCadastrar, "Preencha todos os campos com *", "Erro", 0, null);
				}	
			}
		});
	}
}
