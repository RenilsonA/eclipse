package Administrativo;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import ClassesArray.Funcionarios;
import Geral.Funcoes;
import Geral.Lista;
import UnRe.UnReFuncoes;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class Cadastro {
	Lista lista = new Lista();
	Listar inicio = new Listar();
	Funcoes fuctions = new Funcoes();
	
	public JFrame Cadastrar;
	private JTextField nome;
	private JTextField endereco;
	private JTextField textFieldNomeSindicato;
	private JTextField textFieldID;
	private JTextField numero;
	private JTextField cep;
	private JTextField banco;
	private JTextField agencia;
	private JTextField operacao;
	private JTextField conta;
	
	public Cadastro() {
		initialize();
	}
	public void initialize(){	
		Cadastrar = new JFrame();
		Cadastrar.setBounds(0, 0, 1280, 850);
		Cadastrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Cadastrar.getContentPane().setLayout(null);
		
		nome = new JTextField();
		nome.setFont(new Font("Arial", Font.PLAIN, 25));
		nome.setBounds(50, 133, 948, 45);
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
		
		final JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCadastrar.setBounds(398, 748, 232, 52);
		Cadastrar.getContentPane().add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCancelar.setBounds(640, 748, 232, 52);
		Cadastrar.getContentPane().add(btnCancelar);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setEnabled(false);
		textFieldID.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldID.setColumns(10);
		textFieldID.setBounds(1039, 133, 161, 45);
		Cadastrar.getContentPane().add(textFieldID);
		textFieldID.setText(Integer.toString(Lista.getId() + 1));
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Arial", Font.PLAIN, 35));
		lblID.setBounds(1039, 87, 53, 35);
		Cadastrar.getContentPane().add(lblID);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(50, 291, 323, 226);
		Cadastrar.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAtributo = new JLabel("Atributo Associado*");
		lblAtributo.setBounds(10, 11, 306, 35);
		panel_1.add(lblAtributo);
		lblAtributo.setFont(new Font("Arial", Font.PLAIN, 35));
		
		final JCheckBox chckbxHorista = new JCheckBox("Horista");
		chckbxHorista.setBounds(70, 71, 187, 39);
		chckbxHorista.setFont(new Font("Arial", Font.PLAIN, 25));
		panel_1.add(chckbxHorista);
		
		final JCheckBox chckbxAssalariado = new JCheckBox("Assalariado");
		chckbxAssalariado.setBounds(70, 113, 187, 39);
		chckbxAssalariado.setFont(new Font("Arial", Font.PLAIN, 25));
		panel_1.add(chckbxAssalariado);
		
		final JCheckBox chckbxComissionado = new JCheckBox("Comissionado");
		chckbxComissionado.setBounds(70, 155, 187, 39);
		chckbxComissionado.setToolTipText("Comissionado");
		chckbxComissionado.setFont(new Font("Arial", Font.PLAIN, 25));
		panel_1.add(chckbxComissionado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(48, 528, 1167, 166);
		Cadastrar.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblIdentificaoNoSindicato = new JLabel("Identifica\u00E7\u00E3o no sindicato");
		lblIdentificaoNoSindicato.setBounds(10, 66, 388, 35);
		panel_2.add(lblIdentificaoNoSindicato);
		lblIdentificaoNoSindicato.setFont(new Font("Arial", Font.PLAIN, 35));
		
		final JCheckBox chckbxVinculo = new JCheckBox("Vinculo com algum sindicato*");
		chckbxVinculo.setBounds(10, 15, 481, 35);
		panel_2.add(chckbxVinculo);
		chckbxVinculo.setFont(new Font("Arial", Font.PLAIN, 30));
		
		textFieldNomeSindicato = new JTextField();
		textFieldNomeSindicato.setBounds(10, 112, 1150, 45);
		panel_2.add(textFieldNomeSindicato);
		textFieldNomeSindicato.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldNomeSindicato.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(383, 291, 314, 226);
		Cadastrar.getContentPane().add(panel_1_1);
		
		JLabel lblFormaDeReceber = new JLabel("Forma de receber*");
		lblFormaDeReceber.setFont(new Font("Arial", Font.PLAIN, 35));
		lblFormaDeReceber.setBounds(10, 11, 301, 35);
		panel_1_1.add(lblFormaDeReceber);
		
		final JCheckBox chckbxViaCorreio = new JCheckBox("Via Correio");
		chckbxViaCorreio.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaCorreio.setBounds(76, 72, 151, 39);
		panel_1_1.add(chckbxViaCorreio);
		
		final JCheckBox chckbxEmMos = new JCheckBox("Em m\u00E3os");
		chckbxEmMos.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxEmMos.setBounds(76, 114, 151, 39);
		panel_1_1.add(chckbxEmMos);
		
		final JCheckBox chckbxViaDeposito = new JCheckBox("Via Dep\u00F3sito");
		chckbxViaDeposito.setToolTipText("Comissionado");
		chckbxViaDeposito.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaDeposito.setBounds(76, 156, 169, 39);
		panel_1_1.add(chckbxViaDeposito);
		
		numero = new JTextField();
		numero.setFont(new Font("Arial", Font.PLAIN, 25));
		numero.setColumns(10);
		numero.setBounds(640, 235, 117, 45);
		Cadastrar.getContentPane().add(numero);
		
		cep = new JTextField();
		cep.setFont(new Font("Arial", Font.PLAIN, 25));
		cep.setColumns(10);
		cep.setBounds(767, 235, 231, 45);
		Cadastrar.getContentPane().add(cep);
		
		numero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
		
		cep.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.NumerosPCEP(e);
			}
		});
		
		JLabel lblNDaCasa = new JLabel("N\u00BA da casa*");
		lblNDaCasa.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNDaCasa.setBounds(629, 189, 140, 35);
		Cadastrar.getContentPane().add(lblNDaCasa);
		
		JLabel lblCep = new JLabel("CEP*");
		lblCep.setHorizontalAlignment(SwingConstants.CENTER);
		lblCep.setFont(new Font("Arial", Font.PLAIN, 25));
		lblCep.setBounds(825, 189, 117, 35);
		Cadastrar.getContentPane().add(lblCep);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(707, 291, 508, 226);
		Cadastrar.getContentPane().add(panel_1_1_1);
		
		JLabel lblDadosBancrios = new JLabel("Dados banc\u00E1rios");
		lblDadosBancrios.setFont(new Font("Arial", Font.PLAIN, 35));
		lblDadosBancrios.setBounds(103, 11, 301, 35);
		panel_1_1_1.add(lblDadosBancrios);
		
		banco = new JTextField();
		banco.setFont(new Font("Arial", Font.PLAIN, 25));
		banco.setColumns(10);
		banco.setBounds(113, 57, 311, 45);
		panel_1_1_1.add(banco);
		
		agencia = new JTextField();
		agencia.setFont(new Font("Arial", Font.PLAIN, 25));
		agencia.setColumns(10);
		agencia.setBounds(88, 116, 101, 45);
		panel_1_1_1.add(agencia);
		
		operacao = new JTextField();
		operacao.setFont(new Font("Arial", Font.PLAIN, 25));
		operacao.setColumns(10);
		operacao.setBounds(199, 116, 60, 45);
		panel_1_1_1.add(operacao);
		
		conta = new JTextField();
		conta.setFont(new Font("Arial", Font.PLAIN, 25));
		conta.setColumns(10);
		conta.setBounds(269, 116, 174, 45);
		panel_1_1_1.add(conta);
		
		JLabel lblBanco = new JLabel("Banco");
		lblBanco.setFont(new Font("Arial", Font.PLAIN, 25));
		lblBanco.setBounds(10, 62, 101, 35);
		panel_1_1_1.add(lblBanco);
		
		JLabel lblAgncia = new JLabel("Ag\u00EAncia");
		lblAgncia.setFont(new Font("Arial", Font.PLAIN, 25));
		lblAgncia.setBounds(88, 172, 101, 35);
		panel_1_1_1.add(lblAgncia);
		
		JLabel lblOp = new JLabel("Op.");
		lblOp.setFont(new Font("Arial", Font.PLAIN, 25));
		lblOp.setBounds(209, 172, 48, 35);
		panel_1_1_1.add(lblOp);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setFont(new Font("Arial", Font.PLAIN, 25));
		lblConta.setBounds(323, 172, 101, 35);
		panel_1_1_1.add(lblConta);
		
		agencia.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
		
		operacao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
		
		conta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
		
		chckbxAssalariado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxHorista.setSelected(false);
				chckbxComissionado.setSelected(false);
			}
		});
		
		chckbxHorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxAssalariado.setSelected(false);
				chckbxComissionado.setSelected(false);
			}
		});
		
		chckbxComissionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxAssalariado.setSelected(false);
				chckbxHorista.setSelected(false);
			}
		});
		
		chckbxViaCorreio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxEmMos.setSelected(false);
				chckbxViaDeposito.setSelected(false);
			}
		});
		
		chckbxEmMos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxViaCorreio.setSelected(false);
				chckbxViaDeposito.setSelected(false);
			}
		});
		
		chckbxViaDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxViaCorreio.setSelected(false);
				chckbxEmMos.setSelected(false);
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Cadastrar, "Voc� realmente quer sair?",
						"Sistema de Gerenciamento dos Funcion�rios", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Cadastrar.dispose();
					inicio.lista.setVisible(true);
				}
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!nome.getText().isEmpty() && (chckbxHorista.isSelected() || chckbxAssalariado.isSelected() || chckbxComissionado.isSelected()) &&
						(chckbxViaCorreio.isSelected() || chckbxEmMos.isSelected() || chckbxViaDeposito.isSelected()) &&
						!numero.getText().isEmpty() && !cep.getText().isEmpty() && !endereco.getText().isEmpty()) {	
					
						int tipo = 0;
						String texto = "Os dados abaixo est�o corretos?\nNome: " + nome.getText() + "\nEndere�o: " + endereco.getText();
						if(chckbxAssalariado.isSelected()) texto = texto + "\nAssalariado: Sim";
						if(chckbxHorista.isSelected()){
							texto = texto + "\nHorista: Sim";
							tipo = 1;
						}
						if(chckbxComissionado.isSelected()) {
							texto = texto + "\nComissionado: Sim";
							tipo = 2;
						}
						if(chckbxVinculo.isSelected()) {
							texto = texto + "\nSindicato: Sim" + "\nIdentifica��o? " + textFieldNomeSindicato.getText();
						} else {
							texto = texto + "\nSindicato: N�o";
						}
						
						if (JOptionPane.showConfirmDialog(Cadastrar, texto, "Cadastro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

							String bank = "null";
							int ag = 0, ope = 0;
							String cont = " ";
							if(!banco.getText().isEmpty()) bank = banco.getText();
							if(!agencia.getText().isEmpty()) ag = Integer.parseInt(agencia.getText());
							if(!operacao.getText().isEmpty()) ope = Integer.parseInt(operacao.getText());
							if(!conta.getText().isEmpty()) cont = conta.getText();
							Lista.setId(Lista.getId() + 1);
							Funcionarios funcionarios = new Funcionarios(Lista.getId(), nome.getText(), endereco.getText(), tipo,
				   				       					chckbxViaCorreio.isSelected(), chckbxEmMos.isSelected(), chckbxViaDeposito.isSelected(),
				   				       					chckbxVinculo.isSelected(), textFieldNomeSindicato.getText(), Integer.parseInt(numero.getText()),
				   				       					cep.getText(), bank, ag, ope, cont);
							Lista.funcionarios.add(funcionarios);
							if(chckbxAssalariado.isSelected()) Lista.funcionarios.get(Lista.funcionarios.size() - 1).getDadosAssalariado().setGrupo(1);
							else if (chckbxHorista.isSelected()) Lista.funcionarios.get(Lista.funcionarios.size() - 1).getDadosHorista().setGrupo(2);
							else Lista.funcionarios.get(Lista.funcionarios.size() - 1).getDadosComissionado().setGrupo(3);
									
							UnReFuncoes fun = new UnReFuncoes();
							fun.setVoltar(funcionarios, 1);
							
							nome.setText("");
							textFieldID.setText(Integer.toString(Lista.getId() + 1));
							endereco.setText("");
							chckbxHorista.setSelected(false);
							chckbxAssalariado.setSelected(false);
							chckbxComissionado.setSelected(false);
							chckbxViaCorreio.setSelected(false);
							chckbxEmMos.setSelected(false);
							chckbxViaDeposito.setSelected(false);
							chckbxVinculo.setSelected(false);
							textFieldNomeSindicato.setText("");
							numero.setText("");
							cep.setText("");
							banco.setText("");
							agencia.setText("");
							operacao.setText("");
							conta.setText("");
							
							try {
								lista.Salvar(false);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
							if (!(JOptionPane.showConfirmDialog(Cadastrar, "Deseja cadastrar outro funcion�rio?", 
							    	"Cadastrar novamente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
								Cadastrar.dispose();
								inicio.lista.setVisible(true);
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