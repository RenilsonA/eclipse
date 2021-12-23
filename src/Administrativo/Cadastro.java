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
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import Financeiro.Assalariado;
import Financeiro.Comissionado;
import Financeiro.ConfiguracaoGlobal;
import Financeiro.DadosBancarios;
import Financeiro.DadosCorreios;
import Financeiro.Horista;
import Financeiro.Listas;
import Geral.Funcionarios;
import Geral.Funcoes;
import Geral.Lista;
import Geral.Tempo;
import Ponto.ListaPonto;
import Ponto.Ponto;

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
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Cadastrar, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Cadastrar.dispose();
					inicio.lista.setVisible(true);
				}
			}
		});
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
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(50, 291, 575, 226);
		Cadastrar.getContentPane().add(panel_1);
		
		JLabel lblAtributo = new JLabel("Atributo Associado*");
		lblAtributo.setBounds(134, 11, 306, 35);
		panel_1.add(lblAtributo);
		lblAtributo.setFont(new Font("Arial", Font.PLAIN, 35));
		
		final JCheckBox chckbxHorista = new JCheckBox("Horista");
		chckbxHorista.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxHorista.setBounds(194, 71, 187, 39);
		panel_1.add(chckbxHorista);
		
		final JCheckBox chckbxAssalariado = new JCheckBox("Assalariado");
		chckbxAssalariado.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxAssalariado.setBounds(194, 113, 187, 39);
		panel_1.add(chckbxAssalariado);
		
		final JCheckBox chckbxComissionado = new JCheckBox("Comissionado");
		chckbxComissionado.setToolTipText("Comissionado");
		chckbxComissionado.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxComissionado.setBounds(194, 155, 187, 39);
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
		panel_1_1.setBounds(640, 291, 575, 226);
		Cadastrar.getContentPane().add(panel_1_1);
		
		JLabel lblFormaDeReceber = new JLabel("Forma de receber*");
		lblFormaDeReceber.setFont(new Font("Arial", Font.PLAIN, 35));
		lblFormaDeReceber.setBounds(137, 11, 301, 35);
		panel_1_1.add(lblFormaDeReceber);
		
		final JCheckBox chckbxViaCorreio = new JCheckBox("Via Correio");
		chckbxViaCorreio.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaCorreio.setBounds(203, 72, 151, 39);
		panel_1_1.add(chckbxViaCorreio);
		
		final JCheckBox chckbxEmMos = new JCheckBox("Em m\u00E3os");
		chckbxEmMos.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxEmMos.setBounds(203, 114, 151, 39);
		panel_1_1.add(chckbxEmMos);
		
		final JCheckBox chckbxViaDeposito = new JCheckBox("Via Dep\u00F3sito");
		chckbxViaDeposito.setToolTipText("Comissionado");
		chckbxViaDeposito.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaDeposito.setBounds(203, 156, 169, 39);
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
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!nome.getText().isEmpty() && (chckbxHorista.isSelected() == true || 
						chckbxAssalariado.isSelected() == true|| chckbxComissionado.isSelected() == true) &&
						(chckbxViaCorreio.isSelected() == true || chckbxEmMos.isSelected() == true|| chckbxViaDeposito.isSelected() == true) &&
						!numero.getText().isEmpty() && !cep.getText().isEmpty() && !endereco.getText().isEmpty()) {	
					
						String texto = "Os dados abaixo estão corretos?\nNome: " + nome.getText() + "\nEndereço: " + endereco.getText();
						if(chckbxAssalariado.isSelected() == true) texto = texto + "\nAssalariado: Sim";
						if(chckbxHorista.isSelected() == true) texto = texto + "\nHorista: Sim";
						if(chckbxComissionado.isSelected() == true) texto = texto + "\nComissionado: Sim";
						if(chckbxVinculo.isSelected() == true) {
							texto = texto + "\nSindicato: Sim" + "\nIdentificação? " + textFieldNomeSindicato.getText();
						} else {
							texto = texto + "\nSindicato: Não";
						}
						
						if (JOptionPane.showConfirmDialog(Cadastrar, texto, "Cadastro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
							
							Listas lis = new Listas();
							ListaPonto list = new ListaPonto();
							Lista.setId(Lista.getId() + 1);
							int grupo = 0;
							if(chckbxAssalariado.isSelected() == true) grupo = 1;
							else if (chckbxHorista.isSelected() == true) grupo = 2;
							else grupo = 3;
							Tempo tempo = new Tempo();
							lista.adicionar(new Funcionarios(Lista.getId(), nome.getText(), endereco.getText(), 
							   				chckbxHorista.isSelected(), chckbxAssalariado.isSelected(), chckbxComissionado.isSelected(),
							   				chckbxViaCorreio.isSelected(), chckbxEmMos.isSelected(), chckbxViaDeposito.isSelected(),
							   				chckbxVinculo.isSelected(), textFieldNomeSindicato.getText(), grupo, Integer.parseInt(numero.getText()),
							   				cep.getText()), false);
							if(chckbxAssalariado.isSelected() == true) {
								float p = 0;
								if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
								lis.adicionar(new Assalariado(Lista.getId(), nome.getText(), ConfiguracaoGlobal.salarioMensal, chckbxVinculo.isSelected(),
															  0, p, 0, ConfiguracaoGlobal.taxadeAlicota, tempo.UltimoDiaUtil(), 1), null, null, 0, false);
								list.adicionar(new Ponto(Lista.getId(), 0, 0, 0, 0, false), null, null, 0, false);
							} else if(chckbxHorista.isSelected() == true) {
								float p = 0;
								if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
								lis.adicionar(null, new Horista(Lista.getId(), nome.getText(), 0, 0, 0, p, 
																chckbxVinculo.isSelected(), 0, ConfiguracaoGlobal.taxadeAlicota, ConfiguracaoGlobal.salarioHora,
																LocalDate.now().plusDays(7 - tempo.DiaemNumero() + 6), 2),
																null, 1, false);
								list.adicionar(null, new Ponto(Lista.getId(), 0, 0, 0, 0, false), null, 1, false);
							} else {
								float p = 0;
								if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
								lis.adicionar(null, null, new Comissionado(Lista.getId(), nome.getText(), 0, 0, p, chckbxVinculo.isSelected(),
																		   ConfiguracaoGlobal.salarioQuizenal, 0, ConfiguracaoGlobal.taxadeAlicota,
																		   ConfiguracaoGlobal.comissao, 
																		   LocalDate.now().plusDays(14 - tempo.DiaemNumero() + 6), 3), 2, false);
								list.adicionar(null, null, new Ponto(Lista.getId(), 0, 0, 0, 0, false), 2, false);
							}
							
							if(chckbxViaCorreio.isSelected()) {
									lis.AdicionarDados(null, new DadosCorreios(Lista.getId(), nome.getText(), endereco.getText(),
																			   Integer.parseInt(numero.getText()), cep.getText()), 1, false);
							} else if(chckbxViaDeposito.isSelected()) {
									lis.AdicionarDados(new DadosBancarios(Lista.getId(), nome.getText(), "", 0, 0, 0), null, 0, false);
							} 
							
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
							
							if (!(JOptionPane.showConfirmDialog(Cadastrar, "Deseja cadastrar outro funcionário?", 
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
