package Financeiro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Geral.Funcoes;
import Geral.Lista;

public class ListarComissionados {
	public JFrame listaComissionados;
	private JTable table;
	ListaFinanceiro l = new ListaFinanceiro();
	private JTextField ModificacaodeID;
	
	public ListarComissionados() {
		Initialize();
	}

	public void Initialize() {
		listaComissionados = new JFrame();
		listaComissionados.setBounds(0, 0, 1280, 800);
		listaComissionados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaComissionados.getContentPane().setLayout(null);
				
		table = new JTable();
		
		ModificacaodeID = new JTextField();
		ModificacaodeID.setFont(new Font("Arial", Font.PLAIN, 15));
		ModificacaodeID.setBounds(185, 658, 901, 20);
		listaComissionados.getContentPane().add(ModificacaodeID);
		ModificacaodeID.setColumns(10);
		ModificacaodeID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.NumerosCEspaco(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("ID's a modificar");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(68, 658, 107, 20);
		listaComissionados.getContentPane().add(lblNewLabel);
		
		JButton btnModificarFuncionrios = new JButton("Modificar Funcion\u00E1rios");
		btnModificarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Lista.funcionarios.size() > 0 && !ModificacaodeID.getText().isEmpty()) {
					Lista posic = new Lista();
					String f = ModificacaodeID.getText() + ' ';
					for(int a = 0; a < f.length(); a++) {
						String x = "";
						while(Character.isDigit(f.charAt(a))) {
							x = x + f.charAt(a);
							a++;
						}
						int posicao = posic.posicao(Integer.parseInt(x));
						if(posicao >= 0 && Lista.funcionarios.get(posicao).getTipo() == 2) {
							CSComissionado frame = new CSComissionado(posicao);
							frame.CSComissionados.setVisible(true);
						} 
					}
				}
			}
		});
		btnModificarFuncionrios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnModificarFuncionrios.setBounds(68, 681, 293, 69);
		listaComissionados.getContentPane().add(btnModificarFuncionrios);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaComissionados.dispose();
				l.lista.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(875, 681, 242, 69);
		listaComissionados.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel1 = new JLabel("Sistema de pagamento de funcion\u00E1rios comissionados");
		lblNewLabel1.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel1.setBounds(216, 11, 832, 60);
		listaComissionados.getContentPane().add(lblNewLabel1);
		
		JButton btnCadastrarVenda = new JButton("Cadastrar venda");
		btnCadastrarVenda.setFont(new Font("Arial", Font.PLAIN, 25));
		btnCadastrarVenda.setBounds(371, 681, 242, 69);
		listaComissionados.getContentPane().add(btnCadastrarVenda);
		
		JButton btnHistricoDeVenda = new JButton("Hist\u00F3rico de venda");
		btnHistricoDeVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaComissionados.dispose();
				VendasTela t = new VendasTela();
				t.vendas.setVisible(true);
			}
		});
		btnHistricoDeVenda.setFont(new Font("Arial", Font.PLAIN, 25));
		btnHistricoDeVenda.setBounds(623, 681, 242, 69);
		listaComissionados.getContentPane().add(btnHistricoDeVenda);
		
		btnCadastrarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Lista.funcionarios.size() > 0 && !ModificacaodeID.getText().isEmpty()) {
					Lista posic = new Lista();
					String f = ModificacaodeID.getText() + ' ';
					for(int a = 0; a < f.length(); a++) {
						String x = "";
						while(Character.isDigit(f.charAt(a))) {
							x = x + f.charAt(a);
							a++;
						}
						int posicao = posic.posicao(Integer.parseInt(x));
						if(posicao >= 0 && Lista.funcionarios.get(posicao).getTipo() == 2) {
							CadastrarVenda c = new CadastrarVenda(Lista.funcionarios.get(posicao).getID());
							c.CVenda.setVisible(true);
						} 
					}
				}
			}
		});
		
		JButton btnNewButton = new JButton("Atualizar Lista");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(1050, 49, 176, 46);
		listaComissionados.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaComissionados.dispose();
				table.remove(table);
				table.setBorder(new EmptyBorder(3, 3, 3, 3));
				DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nomes", "Salário", "Vendas", "Comissão (%)", "Bônus", "Grupo"}, 0);
				Object linha0[] = new Object[] {"ID", "Nomes", "Salário", "Vendas", "Comissão (%)", "Bônus", "Grupo"};
				modelo.addRow(linha0);
				table.setModel(modelo);
				DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
				cellRender.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setCellRenderer(cellRender);;
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(600);
				table.getColumnModel().getColumn(2).setPreferredWidth(300);
				table.getColumnModel().getColumn(3).setPreferredWidth(300);
				table.getColumnModel().getColumn(4).setPreferredWidth(300);
				table.getColumnModel().getColumn(5).setPreferredWidth(300);
				for (int i = 0; i < Lista.funcionarios.size(); i++) {
					if(Lista.funcionarios.get(i).getTipo() == 2) {
						Object linha[] = new Object[] {Lista.funcionarios.get(i).getID(), Lista.funcionarios.get(i).getNome(),
								Lista.funcionarios.get(i).getDadosComissionado().getSalario(), Lista.funcionarios.get(i).getDadosComissionado().getVendas(),
								Lista.funcionarios.get(i).getDadosComissionado().getComissao(), Lista.funcionarios.get(i).getDadosComissionado().getBonus(),
								Lista.funcionarios.get(i).getDadosComissionado().getGrupo()};
						modelo.addRow(linha);
						table.setColumnSelectionAllowed(false);
						table.setCellSelectionEnabled(false);
						table.setBounds(60, 101, 1144, 531);
					}
				}
				listaComissionados.getContentPane().add(table);
				listaComissionados.setVisible(true);
			}
		});
	}
}
