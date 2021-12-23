package Administrativo;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import Financeiro.Assalariado;
import Financeiro.Comissionado;
import Financeiro.ConfiguracaoGlobal;
import Financeiro.DadosBancarios;
import Financeiro.DadosCorreios;
import Financeiro.Horista;
import Financeiro.Listas;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import Geral.Funcoes;
import Geral.Lista;
import Geral.Tempo;
import Ponto.ListaPonto;
import Ponto.Ponto;

public class Modificar {
	Lista lista = new Lista();
	Listar inicio = new Listar();
	Funcoes fuctions = new Funcoes();
	
	public JFrame Modificacao;
	private JTextField nome;
	private JTextField endereco;
	private JTextField textFieldNomeSindicato;
	private JTextField textFieldID;
	private JTextField numero;
	private JTextField cep;
	
	public Modificar() {
		initialize();
	}
	public void initialize(){	
		Modificacao = new JFrame();
		Modificacao.setBounds(0, 0, 1280, 850);
		Modificacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Modificacao.getContentPane().setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Modificacao, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Modificacao.dispose();
					inicio.lista.setVisible(true);
				}
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnCancelar.setBounds(640, 748, 232, 52);
		Modificacao.getContentPane().add(btnCancelar);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 35));
		btnModificar.setBounds(398, 748, 232, 52);
		Modificacao.getContentPane().add(btnModificar);
		
		JLabel lblNewLabel_1 = new JLabel("Modificação de Funcion\u00E1rio");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(387, 12, 401, 65);
		Modificacao.getContentPane().add(lblNewLabel_1);
		
		final JComboBox<String> Nome = new JComboBox<String>();
		Nome.setFont(new Font("Arial", Font.PLAIN, 25));
		Nome.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		Nome.setBounds(258, 88, 631, 45);
		Modificacao.getContentPane().add(Nome);
		for(int a = 0; a < Lista.funcionarios.size(); a++) {
			Nome.addItem(Lista.funcionarios.get(a).getID() + " - " + Lista.funcionarios.get(a).getNome());
		}
		
		nome = new JTextField();
		nome.setEditable(false);
		nome.setEnabled(false);
		nome.setFont(new Font("Arial", Font.PLAIN, 25));
		nome.setBounds(51, 190, 948, 45);
		Modificacao.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome*");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel.setBounds(51, 144, 193, 35);
		Modificacao.getContentPane().add(lblNewLabel);
		
		endereco = new JTextField();
		endereco.setEditable(false);
		endereco.setEnabled(false);
		endereco.setFont(new Font("Arial", Font.PLAIN, 25));
		endereco.setColumns(10);
		endereco.setBounds(51, 292, 575, 45);
		Modificacao.getContentPane().add(endereco);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o*");
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 35));
		lblEndereo.setBounds(51, 246, 193, 35);
		Modificacao.getContentPane().add(lblEndereo);
				
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setEnabled(false);
		textFieldID.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldID.setColumns(10);
		textFieldID.setBounds(1040, 190, 173, 45);
		Modificacao.getContentPane().add(textFieldID);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Arial", Font.PLAIN, 35));
		lblID.setBounds(1040, 144, 53, 35);
		Modificacao.getContentPane().add(lblID);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setFont(new Font("Arial", Font.PLAIN, 35));
		lblFuncionrio.setBounds(51, 89, 193, 35);
		Modificacao.getContentPane().add(lblFuncionrio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(51, 348, 575, 226);
		Modificacao.getContentPane().add(panel_1);
		
		JLabel lblAtributo = new JLabel("Atributo Associado*");
		lblAtributo.setBounds(137, 11, 301, 35);
		panel_1.add(lblAtributo);
		lblAtributo.setFont(new Font("Arial", Font.PLAIN, 35));
		
		final JCheckBox chckbxHorista = new JCheckBox("Horista");
		chckbxHorista.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxHorista.setBounds(194, 72, 244, 39);
		panel_1.add(chckbxHorista);
		
		final JCheckBox chckbxAssalariado = new JCheckBox("Assalariado");
		chckbxAssalariado.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxAssalariado.setBounds(194, 114, 188, 39);
		panel_1.add(chckbxAssalariado);
		
		final JCheckBox chckbxComissionado = new JCheckBox("Comissionado");
		chckbxComissionado.setToolTipText("Comissionado");
		chckbxComissionado.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxComissionado.setBounds(194, 156, 188, 39);
		panel_1.add(chckbxComissionado);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(51, 582, 1162, 161);
		Modificacao.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		final JCheckBox chckbxVinculo = new JCheckBox("Vinculo com algum sindicato*");
		chckbxVinculo.setBounds(6, 7, 415, 45);
		panel_2.add(chckbxVinculo);
		chckbxVinculo.setFont(new Font("Arial", Font.PLAIN, 30));
		
		JLabel lblIdentificaoNoSindicato = new JLabel("Identifica\u00E7\u00E3o no sindicato");
		lblIdentificaoNoSindicato.setBounds(6, 66, 388, 35);
		panel_2.add(lblIdentificaoNoSindicato);
		lblIdentificaoNoSindicato.setFont(new Font("Arial", Font.PLAIN, 35));
		
		textFieldNomeSindicato = new JTextField();
		textFieldNomeSindicato.setBounds(6, 112, 1150, 45);
		panel_2.add(textFieldNomeSindicato);
		textFieldNomeSindicato.setFont(new Font("Arial", Font.PLAIN, 25));
		textFieldNomeSindicato.setColumns(10);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnSelecionar.setBounds(899, 87, 232, 45);
		Modificacao.getContentPane().add(btnSelecionar);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(640, 348, 573, 226);
		Modificacao.getContentPane().add(panel_1_1);
		
		JLabel lblFormaDeReceber = new JLabel("Forma de receber*");
		lblFormaDeReceber.setFont(new Font("Arial", Font.PLAIN, 35));
		lblFormaDeReceber.setBounds(136, 11, 301, 35);
		panel_1_1.add(lblFormaDeReceber);
		
		final JCheckBox chckbxViaCorreio = new JCheckBox("Via Correio");
		chckbxViaCorreio.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaCorreio.setBounds(187, 72, 160, 39);
		panel_1_1.add(chckbxViaCorreio);
		
		final JCheckBox chckbxEmMos = new JCheckBox("Em m\u00E3os");
		chckbxEmMos.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxEmMos.setBounds(187, 114, 188, 39);
		panel_1_1.add(chckbxEmMos);
		
		final JCheckBox chckbxViaDeposito = new JCheckBox("Via Dep\u00F3sito");
		chckbxViaDeposito.setToolTipText("Comissionado");
		chckbxViaDeposito.setFont(new Font("Arial", Font.PLAIN, 25));
		chckbxViaDeposito.setBounds(187, 156, 188, 39);
		panel_1_1.add(chckbxViaDeposito);
		
		numero = new JTextField();
		numero.setEditable(false);
		numero.setEnabled(false);
		numero.setFont(new Font("Arial", Font.PLAIN, 25));
		numero.setColumns(10);
		numero.setBounds(640, 292, 117, 45);
		Modificacao.getContentPane().add(numero);
		
		numero.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes f = new Funcoes();
				f.ApenasNumeros(e);
			}
		});
		
		JLabel lblNDaCasa = new JLabel("N\u00BA da casa");
		lblNDaCasa.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNDaCasa.setBounds(640, 246, 117, 35);
		Modificacao.getContentPane().add(lblNDaCasa);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 35));
		lblCep.setBounds(850, 246, 78, 35);
		Modificacao.getContentPane().add(lblCep);
		
		cep = new JTextField();
		cep.setEditable(false);
		cep.setEnabled(false);
		cep.setFont(new Font("Arial", Font.PLAIN, 25));
		cep.setColumns(10);
		cep.setBounds(767, 292, 231, 45);
		Modificacao.getContentPane().add(cep);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(Modificacao, "Você realmente quer sair?",
						"Sistema de Gerenciamento dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Modificacao.dispose();
					inicio.lista.setVisible(true);
				}
			}
		});
		
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Nome.getSelectedIndex() > 0) {
					nome.setEditable(true);
					nome.setEnabled(true);
					endereco.setEditable(true);
					endereco.setEnabled(true);
					chckbxHorista.setEnabled(true);
					chckbxAssalariado.setEnabled(true);
					chckbxComissionado.setEnabled(true);
					chckbxViaCorreio.setEnabled(true);
					chckbxEmMos.setEnabled(true);
					chckbxViaDeposito.setEnabled(true);
					chckbxVinculo.setEnabled(true);
					textFieldNomeSindicato.setEditable(true);
					textFieldNomeSindicato.setEnabled(true);
					btnModificar.setEnabled(true);
					numero.setEditable(true);
					numero.setEnabled(true);
					cep.setEditable(true);
					cep.setEnabled(true);
					
					int x = Nome.getSelectedIndex() - 1;
					textFieldID.setText(Integer.toString(Lista.funcionarios.get(x).getID()));
					nome.setText(Lista.funcionarios.get(x).getNome());
					endereco.setText(Lista.funcionarios.get(x).getEndereco());
					chckbxHorista.setSelected(Lista.funcionarios.get(x).isHorista());
					chckbxAssalariado.setSelected(Lista.funcionarios.get(x).isSalariado());
					chckbxComissionado.setSelected(Lista.funcionarios.get(x).isComissionado());
					chckbxViaCorreio.setSelected(Lista.funcionarios.get(x).isViaCorreios());
					chckbxEmMos.setSelected(Lista.funcionarios.get(x).isEmMaos());
					chckbxViaDeposito.setSelected(Lista.funcionarios.get(x).isViaDeposito());
					chckbxVinculo.setSelected(Lista.funcionarios.get(x).isSindicato());
					textFieldNomeSindicato.setText(Lista.funcionarios.get(x).getIdentificacao());
					numero.setText(Integer.toString(Lista.funcionarios.get(x).getNumero()));
					cep.setText(Lista.funcionarios.get(x).getCep());
				} else {
					nome.setEditable(false);
					nome.setEnabled(false);
					endereco.setEditable(false);
					endereco.setEnabled(false);
					chckbxHorista.setEnabled(false);
					chckbxAssalariado.setEnabled(false);
					chckbxComissionado.setEnabled(false);
					chckbxViaCorreio.setEnabled(false);
					chckbxEmMos.setEnabled(false);
					chckbxViaDeposito.setEnabled(false);
					chckbxVinculo.setEnabled(false);
					textFieldNomeSindicato.setEditable(false);
					textFieldNomeSindicato.setEnabled(false);
					btnModificar.setEnabled(false);
					numero.setEditable(false);
					numero.setEnabled(false);
					cep.setEditable(false);
					cep.setEnabled(false);
					nome.setText("");
					textFieldID.setText(Integer.toString(Lista.getId() + 1));
					endereco.setText("");
					textFieldNomeSindicato.setText("");
					numero.setText("");
					cep.setText("");
					JOptionPane.showMessageDialog(btnModificar, "Selecione um funcionário", "Erro", 0, null);
				}
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (nome.getText() != null && endereco.getText() != null && 
						(chckbxHorista.isSelected() == true || chckbxAssalariado.isSelected() == true || chckbxComissionado.isSelected() == true)) {				
						String texto = "Os dados abaixo estão corretos?\nNome: " + nome.getText() + "\nEndereço: " + endereco.getText();
						if(chckbxHorista.isSelected() == true) texto = texto + "\nHorista: Sim";
						if(chckbxAssalariado.isSelected() == true) texto = texto + "\nAssalariado: Sim";
						if(chckbxComissionado.isSelected() == true) texto = texto + "\nComissionado: Sim";
						if(chckbxVinculo.isSelected() == true) {
							texto = texto + "\nSindicato: Sim" +  "\nIdentificação? " + textFieldNomeSindicato.getText();
						} else {
							texto = texto + "\nSindicato: Não";
						}
					
						if (JOptionPane.showConfirmDialog(Modificacao, texto, 
								"Modificação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {	
							
							Tempo tempo = new Tempo();
							int x = Nome.getSelectedIndex() - 1;
							ListaPonto list = new ListaPonto();
							Listas lis = new Listas();
							if(chckbxAssalariado.isSelected() == true && chckbxComissionado.isSelected() == false) {
								Lista.funcionarios.get(x).setGrupo(1);
								if(Lista.funcionarios.get(x).isSalariado()) {
									int f = lis.posicao(0, Lista.funcionarios.get(x).getID());
									Listas.assalariados.get(f).setNome(nome.getText());
									Listas.assalariados.get(f).setSindicato(chckbxVinculo.isSelected());
									if(chckbxVinculo.isSelected()) Listas.assalariados.get(f).setDescontos(ConfiguracaoGlobal.taxadeSindicato);
								} else if(Lista.funcionarios.get(x).isComissionado()) {
									float p = 0;
									if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
									int f = lis.posicao(2, Lista.funcionarios.get(x).getID());
									lis.adicionar(new Assalariado(Listas.comissionados.get(f).getID(), Listas.comissionados.get(f).getNome(),
																  ConfiguracaoGlobal.salarioMensal, Listas.comissionados.get(f).isSindicato(),
															      Listas.comissionados.get(f).getBonus() + (ListaPonto.pontosComissionado.get(f).getHorasNormais()/15)*
															      Listas.comissionados.get(f).getSalario(), p, Listas.comissionados.get(f).getDiscExtra(),
															      Listas.comissionados.get(f).getAlicota(),  tempo.UltimoDiaUtil(),
															      Listas.comissionados.get(f).getGrupo()), null, null, 0, false);
									lis.remover(2, f);	
									list.adicionar(new Ponto(ListaPonto.pontosComissionado.get(f).getID(), ListaPonto.pontosComissionado.get(f).getHorasNormais(),
															 ListaPonto.pontosComissionado.get(f).getHorasExtras(), ListaPonto.pontosComissionado.get(f).getHorasNormaisTotal(),
															 ListaPonto.pontosComissionado.get(f).getHorasExtrasTotal(), false), null, null, 0, false);
									list.remover(2, f);
								} else {
									float p = 0;
									if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
									int f = lis.posicao(1, Lista.funcionarios.get(x).getID());
									lis.adicionar(new Assalariado(Listas.horistas.get(f).getID(), Listas.horistas.get(f).getNome(),
																  ConfiguracaoGlobal.salarioMensal, Listas.horistas.get(f).isSindicato(), Listas.horistas.get(f).getBonus() + 
															      Listas.horistas.get(f).getHorasExtras()*Listas.horistas.get(f).getSalarioHora(),
															      p, Listas.horistas.get(f).getDiscExtra(), Listas.horistas.get(f).getAlicota(),
															      tempo.UltimoDiaUtil(), Listas.horistas.get(f).getGrupo()),
																  null, null, 0, false);
									lis.remover(1, f);
									list.adicionar(new Ponto(ListaPonto.pontosHorista.get(f).getID(), ListaPonto.pontosHorista.get(f).getHorasNormais()/480,
											 				 0, ListaPonto.pontosHorista.get(f).getHorasNormaisTotal(),
											 				 0, false), null, null, 0, false);
									list.remover(1, f);
								}
							} else if(chckbxHorista.isSelected() == true) {
								Lista.funcionarios.get(x).setGrupo(2);
								if(Lista.funcionarios.get(x).isHorista()) {
									int f = lis.posicao(1, Lista.funcionarios.get(x).getID());
									Listas.horistas.get(f).setNome(nome.getText());
									Listas.horistas.get(f).setSindicato(chckbxVinculo.isSelected());
									if(chckbxVinculo.isSelected()) Listas.horistas.get(f).setDescontos(ConfiguracaoGlobal.taxadeSindicato);
								} else if(Lista.funcionarios.get(x).isComissionado()) {
									float p = 0;
									if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
									int f = lis.posicao(2, Lista.funcionarios.get(x).getID());
									lis.adicionar(null, new Horista(Listas.comissionados.get(f).getID(), Listas.comissionados.get(f).getNome(),
																	0, 0, Listas.comissionados.get(f).getBonus() + Listas.comissionados.get(f).getVendas()*
															  		Listas.comissionados.get(f).getComissao(), p,
															  		Listas.comissionados.get(f).isSindicato(), Listas.comissionados.get(f).getDiscExtra(),
															  		Listas.comissionados.get(f).getAlicota(), ConfiguracaoGlobal.salarioHora, 
															  		LocalDate.now().withDayOfYear((LocalDate.now().getDayOfYear() + 7 + tempo.DiaemNumero() + 6) % 365),
															  		Listas.comissionados.get(f).getGrupo()),
															  		null, 1, false);
									lis.remover(2, f);	
									list.adicionar(null, new Ponto(ListaPonto.pontosComissionado.get(f).getID(), ListaPonto.pontosComissionado.get(f).getHorasNormais(),
											 				 ListaPonto.pontosComissionado.get(f).getHorasExtras(), ListaPonto.pontosComissionado.get(f).getHorasNormaisTotal(),
											 				 ListaPonto.pontosComissionado.get(f).getHorasExtrasTotal(), false), null, 1, false);
									list.remover(2, f);
								} else {
									float p = 0;
									if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
									int f = lis.posicao(0, Lista.funcionarios.get(x).getID());
									lis.adicionar(null, new Horista(Listas.assalariados.get(f).getID(), Listas.assalariados.get(f).getNome(),
																	0, 0, Listas.assalariados.get(f).getBonus() + Listas.assalariados.get(f).getSalario()*
																	(30/100), p, Listas.assalariados.get(f).isSindicato(),
																	Listas.assalariados.get(f).getDiscExtra(), Listas.assalariados.get(f).getAlicota(), ConfiguracaoGlobal.salarioHora,
																	LocalDate.now().withDayOfYear((LocalDate.now().getDayOfYear() + 7 + tempo.DiaemNumero() + 6) % 365),
																	Listas.assalariados.get(f).getGrupo()),
									  								null, 1, false);
									lis.remover(0, f);
									list.adicionar(null, new Ponto(ListaPonto.pontosAssalariados.get(f).getID(), ListaPonto.pontosAssalariados.get(x).getHorasNormais()/480,
							 				 				 0, ListaPonto.pontosAssalariados.get(f).getHorasNormaisTotal(),
							 				 				 0, false), null, 1, false);
									list.remover(0, f);
								}
							} else {
								Lista.funcionarios.get(x).setGrupo(3);
								if(Lista.funcionarios.get(x).isComissionado()) {
									int f = lis.posicao(2, Lista.funcionarios.get(x).getID());
									Listas.comissionados.get(f).setNome(nome.getText());
									Listas.comissionados.get(f).setSindicato(chckbxVinculo.isSelected());
									if(chckbxVinculo.isSelected()) Listas.comissionados.get(f).setDescontos(ConfiguracaoGlobal.taxadeSindicato);
								} else if(Lista.funcionarios.get(x).isSalariado()) {
									float p = 0;
									if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
									int f = lis.posicao(0, Lista.funcionarios.get(x).getID());
									lis.adicionar(null, null, new Comissionado(Listas.assalariados.get(f).getID(), Listas.assalariados.get(f).getNome(),
										      								  0, Listas.assalariados.get(f).getBonus() + Listas.assalariados.get(f).getSalario()*
										      								  (30/100)*ListaPonto.pontosAssalariados.get(f).getHorasNormais(), 
										      								  p, Listas.assalariados.get(f).isSindicato(), ConfiguracaoGlobal.salarioQuizenal,
										      								  Listas.assalariados.get(f).getDiscExtra(), Listas.assalariados.get(f).getAlicota(), ConfiguracaoGlobal.comissao,
										      								  LocalDate.now().withDayOfYear((LocalDate.now().getDayOfYear() + 14 + tempo.DiaemNumero() + 6) % 365),
										      								  Listas.assalariados.get(f).getGrupo()), 2, false);
									lis.remover(0, f);	
									list.adicionar(null, null, new Ponto(ListaPonto.pontosAssalariados.get(f).getID(), ListaPonto.pontosAssalariados.get(f).getHorasNormais(),
							 				 					   ListaPonto.pontosAssalariados.get(f).getHorasExtras(), ListaPonto.pontosAssalariados.get(f).getHorasNormaisTotal(),
							 				 					   ListaPonto.pontosAssalariados.get(f).getHorasExtrasTotal(), false), 2, false);
									list.remover(0, f);								
								} else {
									float p = 0;
									if(chckbxVinculo.isSelected()) p = ConfiguracaoGlobal.taxadeSindicato;
									int f = lis.posicao(1, Lista.funcionarios.get(x).getID());
									lis.adicionar(null, null, new Comissionado(Listas.horistas.get(f).getID(), Listas.horistas.get(f).getNome(),
		      								  								   0, Listas.horistas.get(f).getBonus()*Listas.horistas.get(f).getSalarioHora() +
		      								  								   Listas.horistas.get(f).getSalarioHora()*ListaPonto.pontosHorista.get(f).getHorasNormais(), 
		      								  								   p, Listas.horistas.get(f).isSindicato(), ConfiguracaoGlobal.salarioQuizenal,
		      								  								   Listas.horistas.get(f).getDiscExtra(), Listas.horistas.get(f).getAlicota(), ConfiguracaoGlobal.comissao, 
		      								  								   LocalDate.now().withDayOfYear((LocalDate.now().getDayOfYear() + 14 + tempo.DiaemNumero() + 6) % 365),
		      								  								   Listas.horistas.get(f).getGrupo()), 2, false);
									lis.remover(1, f);
									list.adicionar(null, null, new Ponto(ListaPonto.pontosHorista.get(f).getID(), ListaPonto.pontosHorista.get(x).getHorasNormais()/480,
							 				 				 0, ListaPonto.pontosHorista.get(f).getHorasNormaisTotal(), 0, false), 2, false);
									list.remover(1, f);
								}
							}
							
							if(chckbxViaCorreio.isSelected()) {
								if(Lista.funcionarios.get(x).isEmMaos() || Lista.funcionarios.get(x).isViaDeposito()) {
									lis.AdicionarDados(null, new DadosCorreios(Lista.funcionarios.get(x).getID(), nome.getText(), endereco.getText(),
																			   Integer.parseInt(numero.getText()), cep.getText()), 1, false);
									if(Lista.funcionarios.get(x).isViaDeposito()) lis.removerDados(0, lis.posicao(0, Lista.funcionarios.get(x).getID()));									
								} else {
									int index = lis.posicaoDados(1, Lista.funcionarios.get(x).getID());
									Listas.dadosCorreios.get(index).setNome(nome.getText());
									Listas.dadosCorreios.get(index).setEndereco(endereco.getText());
									Listas.dadosCorreios.get(index).setNumero(Integer.parseInt(numero.getText()));
									Listas.dadosCorreios.get(index).setCep(cep.getText());
								}
							} else if(chckbxViaDeposito.isSelected()) {
								if(Lista.funcionarios.get(x).isEmMaos() || Lista.funcionarios.get(x).isViaCorreios()) {
									lis.AdicionarDados(new DadosBancarios(Lista.funcionarios.get(x).getID(), nome.getText(), "", 0, 0, 0), null, 0, false);
									if(Lista.funcionarios.get(x).isViaDeposito()) lis.removerDados(1, lis.posicaoDados(0, Lista.funcionarios.get(x).getID()));
								} else {
									int index = lis.posicaoDados(0, Lista.funcionarios.get(x).getID());
									Listas.dadosBancarios.get(index).setNome(nome.getText());
								}
							} else {
								if(Lista.funcionarios.get(x).isViaDeposito()) lis.removerDados(0, lis.posicao(0, Lista.funcionarios.get(x).getID()));
								else lis.removerDados(1, lis.posicaoDados(1, Lista.funcionarios.get(x).getID()));
							}
							
							Lista.funcionarios.get(x).modificacao(nome.getText(), endereco.getText(), 
		   							  chckbxHorista.isSelected(), chckbxAssalariado.isSelected(), chckbxComissionado.isSelected(),
		   							  chckbxViaCorreio.isSelected(), chckbxEmMos.isSelected(), chckbxViaDeposito.isSelected(),
		   							  chckbxVinculo.isSelected(), textFieldNomeSindicato.getText(), Integer.parseInt(numero.getText()), cep.getText());
							
							nome.setText("");
							textFieldID.setText("");
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
							try {
								lista.Salvar(true);
								lis.SalvarAssalariado(true);
								lis.SalvarComissionado(true);
								lis.SalvarHorista(true);
								list.SalvarAssalariado(true);
								list.SalvarComissionado(true);
								list.SalvarHorista(true);
								lis.SalvarCorreios(true);
								lis.SalvarBancarios(true);
								lis.SalvarVendas();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
									
							if (!(JOptionPane.showConfirmDialog(Modificacao, "Deseja modificar outro funcionário?", 
							    	"Modificar novamente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
								Modificacao.dispose();
								inicio.lista.setVisible(true);
							}
						}
					}
				else {
					JOptionPane.showMessageDialog(btnModificar, "Preencha todos os campos com *", "Erro", 0, null);
				}	
			}
		});
	}
}