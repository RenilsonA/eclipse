package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import ClassesArray.Funcionarios;
import Geral.Funcoes;
import Geral.Lista;
import Geral.Tempo;
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
				Object linha[] = null;
				for(Funcionarios x: Lista.funcionarios) {
					if(x.getDadosAssalariado() != null && comboBox.getSelectedIndex() == x.getDadosAssalariado().getGrupo()) {
						float salario = (x.getDadosAssalariado().getSalario()*x.getDadosAssalariado().getDias()/tempo.DiasUteisnoMes()) *
										(1 -(x.getDadosAssalariado().getdescSind() + x.getDadosAssalariado().getAlicota())/100F) +
										+ x.getDadosAssalariado().getBonus() - x.getDadosAssalariado().getDiscExtra();
						linha = new Object[] {x.getNome(), x.getDadosAssalariado().getSalario()*x.getDadosAssalariado().getDias()/tempo.DiasUteisnoMes(),
								 x.getDadosAssalariado().getBonus(), x.getDadosAssalariado().getdescSind() +
								 x.getDadosAssalariado().getAlicota(), x.getDadosAssalariado().getDiscExtra(), salario};
						pagamentos.getContentPane().add(table);
						modelo.addRow(linha);
						table.setColumnSelectionAllowed(false);
						table.setCellSelectionEnabled(false);
						table.setBounds(60, 111, 1144, 531);
						pagamentos.getContentPane().add(table);
					} else if(x.getDadosHorista() != null && comboBox.getSelectedIndex() == x.getDadosHorista().getGrupo()) {
						float salario = (((x.getDadosHorista().getSalarioHora()*(x.getDadosHorista().getHoras() + x.getDadosHorista().getHorasExtras()*1.5F)))) * 
				        				(1 - ((x.getDadosHorista().getdescSind() + x.getDadosHorista().getAlicota())/100F)) + x.getDadosHorista().getBonus()
				        				- x.getDadosHorista().getDiscExtra();
						linha = new Object[] {x.getNome(), x.getDadosHorista().getSalarioHora() *
								(x.getDadosHorista().getHoras() + x.getDadosHorista().getHorasExtras()),
								x.getDadosHorista().getBonus(), x.getDadosHorista().getAlicota() + x.getDadosHorista().getdescSind(),
								x.getDadosHorista().getDiscExtra(), salario};
						modelo.addRow(linha);
						table.setColumnSelectionAllowed(false);
						table.setCellSelectionEnabled(false);
						table.setBounds(60, 111, 1144, 531);
						pagamentos.getContentPane().add(table);
					} else if(x.getDadosComissionado() != null && comboBox.getSelectedIndex() == x.getDadosComissionado().getGrupo()) {
						float salario = (x.getDadosComissionado().getSalario()*x.getDadosComissionado().getDias()/(tempo.DiasUteisnoMes()/2)) * 
				        		(1 - ((x.getDadosComissionado().getdescSind() + x.getDadosComissionado().getAlicota())/100F)) + 
				        		x.getDadosComissionado().getBonus() - x.getDadosComissionado().getDiscExtra() +
		        				x.getDadosComissionado().getVendas()*x.getDadosComissionado().getComissao()/100F;
						linha = new Object[] {x.getNome(), x.getDadosComissionado().getSalario() * x.getDadosComissionado().getDias()/
								(tempo.DiasUteisnoMes()/2), x.getDadosComissionado().getBonus(), x.getDadosComissionado().getAlicota() +
								x.getDadosComissionado().getdescSind(), x.getDadosComissionado().getDiscExtra(), salario};
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
