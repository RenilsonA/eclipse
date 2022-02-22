package Financeiro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ClassesArray.Funcionarios;
import Geral.Lista;

public class VendasTela {
	public JFrame vendas;
	private JTable table;
	
	public VendasTela() {
		Initialize();
	}
	
	private void Initialize() {
		vendas = new JFrame();
		vendas.setBounds(0, 0, 1280, 800);
		vendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vendas.getContentPane().setLayout(null);
		
		table = new JTable();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendas.dispose();
				ListarComissionados l = new ListarComissionados();
				l.listaComissionados.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(485, 681, 293, 69);
		vendas.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel1 = new JLabel("Hist\u00F3rico de vendas");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel1.setBounds(216, 11, 832, 60);
		vendas.getContentPane().add(lblNewLabel1);
		
		JButton btnNewButton = new JButton("Atualizar Lista");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(1048, 57, 176, 46);
		vendas.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendas.dispose();
				table.remove(table);
				table.setBorder(new EmptyBorder(3, 3, 3, 3));
				DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nome", "Valor", "Dia"}, 0);
				Object linha0[] = new Object[] {"ID", "Nome", "Valor", "Dia"};
				modelo.addRow(linha0);
				table.setModel(modelo);
				DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
				cellRender.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setCellRenderer(cellRender);;
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(500);
				table.getColumnModel().getColumn(2).setPreferredWidth(500);
				table.getColumnModel().getColumn(3).setPreferredWidth(500);
				for (Funcionarios func: Lista.funcionarios) {
					if(func.getTipo() == 2) {
						for(int x = 0; x < func.getDadosComissionado().getListaVendas().size(); x++) {
							Object linha[] = new Object[] {func.getID(), func.getNome(), func.getDadosComissionado().getListaVendas().get(x).getValor(),
									func.getDadosComissionado().getListaVendas().get(x).getDiadaVenda()};
							modelo.addRow(linha);
							table.setColumnSelectionAllowed(false);
							table.setCellSelectionEnabled(false);
							table.setBounds(60, 101, 1144, 531);
						}
					}
				}
				vendas.getContentPane().add(table);
				vendas.setVisible(true);
			}
		});
	}
}
