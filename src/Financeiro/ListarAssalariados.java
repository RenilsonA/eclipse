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

public class ListarAssalariados {
	public JFrame listaAssalariados;
	private JTable table;
	ListaFinanceiro l = new ListaFinanceiro();
	private JTextField ModificacaodeID;
	
	public ListarAssalariados() {
		Initialize();
	}

	public void Initialize() {
		listaAssalariados = new JFrame();
		listaAssalariados.setBounds(0, 0, 1280, 800);
		listaAssalariados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaAssalariados.getContentPane().setLayout(null);
				
		table = new JTable();
		
		ModificacaodeID = new JTextField();
		ModificacaodeID.setFont(new Font("Arial", Font.PLAIN, 15));
		ModificacaodeID.setBounds(185, 658, 901, 20);
		listaAssalariados.getContentPane().add(ModificacaodeID);
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
		listaAssalariados.getContentPane().add(lblNewLabel);
		
		JButton btnModificarFuncionrios = new JButton("Modificação Indivídual");
		btnModificarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ModificacaodeID.getText().isEmpty()) {
					if(Lista.funcionarios.size() > 0) {
						Lista posic = new Lista();
						String f = ModificacaodeID.getText() + ' ';
						for(int a = 0; a < f.length(); a++) {
							String x = "";
							while(Character.isDigit(f.charAt(a))) {
								x = x + f.charAt(a);
								a++;
							}
							int posicao = posic.posicao(Integer.parseInt(x));
							if(posicao >= 0 && Lista.funcionarios.get(posicao).getTipo() == 0) {
								CSAssalariado frame = new CSAssalariado(posicao);
								frame.CSAssalariados.setVisible(true);
							}
						}
					}
				}
			}
		});
		btnModificarFuncionrios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnModificarFuncionrios.setBounds(332, 681, 293, 69);
		listaAssalariados.getContentPane().add(btnModificarFuncionrios);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaAssalariados.dispose();
				l.lista.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(638, 681, 293, 69);
		listaAssalariados.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel1 = new JLabel("Sistema de pagamento de funcion\u00E1rios assalariados");
		lblNewLabel1.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel1.setBounds(216, 11, 832, 60);
		listaAssalariados.getContentPane().add(lblNewLabel1);
		
		JButton btnNewButton = new JButton("Atualizar Lista");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(1050, 49, 176, 46);
		listaAssalariados.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaAssalariados.dispose();
				table.remove(table);
				table.setBorder(new EmptyBorder(3, 3, 3, 3));
				DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nomes", "Salário", "Bônus", "Grupo"}, 0);
				Object linha0[] = new Object[] {"ID", "Nome", "Salário", "Bônus", "Grupo"};
				modelo.addRow(linha0);
				table.setModel(modelo);
				DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
				cellRender.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setCellRenderer(cellRender);;
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(800);
				table.getColumnModel().getColumn(2).setPreferredWidth(300);
				table.getColumnModel().getColumn(3).setPreferredWidth(300);
				table.getColumnModel().getColumn(4).setPreferredWidth(300);
				for (int i = 0; i < Lista.funcionarios.size(); i++) {
					if(Lista.funcionarios.get(i).getTipo() == 0) {
						Object linha[] = new Object[] {Lista.funcionarios.get(i).getID(), Lista.funcionarios.get(i).getNome(),
								Lista.funcionarios.get(i).getDadosAssalariado().getSalario(), Lista.funcionarios.get(i).getDadosAssalariado().getBonus(), 
								Lista.funcionarios.get(i).getDadosAssalariado().getGrupo()};
						modelo.addRow(linha);
						table.setColumnSelectionAllowed(false);
						table.setCellSelectionEnabled(false);
						table.setBounds(60, 101, 1144, 531);
					}
				}
				listaAssalariados.getContentPane().add(table);
				listaAssalariados.setVisible(true);
			}
		});
	}
}
