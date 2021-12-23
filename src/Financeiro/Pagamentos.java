package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Geral.Funcoes;
import Geral.Lista;
import Geral.Tempo;
import Ponto.ListaPonto;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Pagamentos {
	private JTable table;
	public JFrame pagamentos;
	private JTextField ModificacaoID;
	
	public Pagamentos() {
		Initialize();
	}
	
	public void Initialize() {
		pagamentos = new JFrame();
		pagamentos.setBounds(0, 0, 1280, 800);
		pagamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pagamentos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pagamentos");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(559, 11, 145, 49);
		pagamentos.getContentPane().add(lblNewLabel);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 22));
		comboBox.setBounds(310, 71, 644, 38);
		pagamentos.getContentPane().add(comboBox);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 22));
		btnVoltar.setBounds(753, 701, 135, 49);
		pagamentos.getContentPane().add(btnVoltar);
		
		JButton btnAdd = new JButton("Adicionar grupo");
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 22));
		btnAdd.setBounds(275, 701, 211, 49);
		pagamentos.getContentPane().add(btnAdd);
		
		JButton btnRemover = new JButton("Remover grupo");
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 22));
		btnRemover.setBounds(493, 701, 250, 49);
		pagamentos.getContentPane().add(btnRemover);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"0 - Selecione uma das opções:"}));
		
		ModificacaoID = new JTextField();
		ModificacaoID.setFont(new Font("Arial", Font.PLAIN, 15));
		ModificacaoID.setBounds(181, 658, 901, 20);
		pagamentos.getContentPane().add(ModificacaoID);
		ModificacaoID.setColumns(10);
		ModificacaoID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.NumerosCEspaco(e);
			}
		});
		
		JLabel lblNewLabel1 = new JLabel("ID's a modificar");
		lblNewLabel1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel1.setBounds(67, 658, 108, 20);
		pagamentos.getContentPane().add(lblNewLabel1);
		
		table = new JTable();
		
		JLabel lblSelecioneUmGrupo = new JLabel("Selecione um grupo");
		lblSelecioneUmGrupo.setFont(new Font("Arial", Font.PLAIN, 22));
		lblSelecioneUmGrupo.setBounds(109, 71, 191, 38);
		pagamentos.getContentPane().add(lblSelecioneUmGrupo);
		
		JButton btnIr = new JButton("Selecionar");
		btnIr.setFont(new Font("Arial", Font.PLAIN, 18));
		btnIr.setBounds(964, 71, 135, 38);
		pagamentos.getContentPane().add(btnIr);
		
		comboBox.addItem("1 - Último dia útil do mês");
		comboBox.addItem("2 - Todas as sextas");
		comboBox.addItem("3 - Quizenalmente, as sextas");
		for(int a = 0; a < Lista.grupos.size(); a++) {
			comboBox.addItem(a + 4 + " - " + Lista.grupos.get(a).getNome());
		}

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoGrupo n = new NovoGrupo();
				pagamentos.dispose();
				n.grupo.setVisible(true);
			}
		});
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverGrupo f = new RemoverGrupo();
				pagamentos.dispose();
				f.removerGrupo.setVisible(true);
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamentos.dispose();
				Financeiro f = new Financeiro();
				f.listaFin.setVisible(true);
			}
		});
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamentos.dispose();
				pagamentos.remove(table);
				table.setBorder(new EmptyBorder(3, 3, 3, 3));
				DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome", "Salário", "Extra", "Descontos", "Taxas", "Líquido"}, 0);
				Object linha0[] = new Object[] {"Nome", "Salário", "Extra", "Descontos", "Taxas", "Líquido"};
				modelo.addRow(linha0);
				table.setModel(modelo);
				table.getColumnModel().getColumn(0).setPreferredWidth(300);
				table.getColumnModel().getColumn(1).setPreferredWidth(300);
				table.getColumnModel().getColumn(2).setPreferredWidth(300);
				table.getColumnModel().getColumn(3).setPreferredWidth(300);
				table.getColumnModel().getColumn(4).setPreferredWidth(300);
				table.getColumnModel().getColumn(5).setPreferredWidth(300);
				Tempo tempo = new Tempo();
				for(int a = 0; a < Listas.assalariados.size(); a++) {
					if(comboBox.getSelectedIndex() == Listas.assalariados.get(a).getGrupo()) {
						float salario = (Listas.assalariados.get(a).getSalario()*ListaPonto.pontosAssalariados.get(a).getHorasNormais()/tempo.DiasUteisnoMes()) *
										 (1 -(Listas.assalariados.get(a).getDescontos()+ Listas.assalariados.get(a).getAlicota())/100F) +
										 + Listas.assalariados.get(a).getBonus() - Listas.assalariados.get(a).getDiscExtra();
						Object linha[] = new Object[] {Listas.assalariados.get(a).getNome(), Listas.assalariados.get(a).getSalario()*
								  		         ListaPonto.pontosAssalariados.get(a).getHorasNormais()/tempo.DiasUteisnoMes(),
								  		         Listas.assalariados.get(a).getBonus(), Listas.assalariados.get(a).getDescontos() + Listas.assalariados.get(a).getAlicota(), 
								  		         Listas.assalariados.get(a).getDiscExtra(), salario};
						modelo.addRow(linha);
						table.setColumnSelectionAllowed(false);
						table.setCellSelectionEnabled(false);
						table.setBounds(60, 111, 1144, 531);
						pagamentos.getContentPane().add(table);
					}
				}
				for(int a = 0; a < Listas.horistas.size(); a++) {
					if(comboBox.getSelectedIndex() == Listas.horistas.get(a).getGrupo()) {
						float salario = (((Listas.horistas.get(a).getSalarioHora()*(ListaPonto.pontosHorista.get(a).getHorasNormaisTotal() + 
						        		ListaPonto.pontosHorista.get(a).getHorasExtrasTotal())))) * 
						        		(1 - ((Listas.horistas.get(a).getDescontos() + Listas.horistas.get(a).getAlicota())/100F)) +
						        		Listas.horistas.get(a).getBonus() - Listas.horistas.get(a).getDiscExtra();
						Object linha[] = new Object[] {Listas.horistas.get(a).getNome(), Listas.horistas.get(a).getSalarioHora() *
								 				 (ListaPonto.pontosHorista.get(a).getHorasNormais() + ListaPonto.pontosHorista.get(a).getHorasExtrasTotal()),
								 				 Listas.horistas.get(a).getBonus(), Listas.horistas.get(a).getAlicota() + Listas.horistas.get(a).getDescontos(),
								 				 Listas.horistas.get(a).getDiscExtra(), salario};
						modelo.addRow(linha);
						table.setColumnSelectionAllowed(false);
						table.setCellSelectionEnabled(false);
						table.setBounds(60, 111, 1144, 531);
						pagamentos.getContentPane().add(table);
					}
				}
				for(int a = 0; a < Listas.comissionados.size(); a++) {
					if(comboBox.getSelectedIndex() == Listas.comissionados.get(a).getGrupo()) {
						float salario = (Listas.comissionados.get(a).getSalario()*ListaPonto.pontosComissionado.get(a).getHorasNormaisTotal()/tempo.DiasUteisnoMes()) * 
						        		(1 - ((Listas.comissionados.get(a).getDescontos() + Listas.comissionados.get(a).getAlicota())/100F)) + 
						        		Listas.comissionados.get(a).getBonus() - Listas.comissionados.get(a).getDiscExtra(); //+
						        		//Listas.comissionados.get(a).getVendas()*Listas.comissionados.get(a).getComissao()/100F;
						Object linha[] = new Object[] {Listas.comissionados.get(a).getNome(), Listas.comissionados.get(a).getSalario() *
								 				 (ListaPonto.pontosComissionado.get(a).getHorasNormais()),
								 				 Listas.comissionados.get(a).getBonus(), Listas.comissionados.get(a).getAlicota() + Listas.comissionados.get(a).getDescontos(),
								 				 Listas.comissionados.get(a).getDiscExtra(), salario};
						modelo.addRow(linha);
						table.setColumnSelectionAllowed(false);
						table.setCellSelectionEnabled(false);
						table.setBounds(60, 111, 1144, 531);
						pagamentos.getContentPane().add(table);
					}
				}
				pagamentos.setVisible(true);
			}
		});
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
