package Financeiro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Geral.Inicio;
import Geral.Lista;
import javax.swing.JLabel;

public class ListarFuncionarios {
	public JFrame lista;
	private JTable table;
	Inicio inicio = new Inicio();
	
	public ListarFuncionarios() {
		Initialize();
	}

	public void Initialize() {
		lista = new JFrame();
		lista.setBounds(0, 0, 1280, 800);
		lista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista.getContentPane().setLayout(null);
		
		tabela();
		
		JButton Adicionar = new JButton("Adicionar Funcion\u00E1rios");
		Adicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Adicionar.setFont(new Font("Arial", Font.PLAIN, 25));
		Adicionar.setBounds(30, 681, 293, 69);
		lista.getContentPane().add(Adicionar);
		
		JButton btnRemoverFuncionrios = new JButton("Remover Funcion\u00E1rios");
		btnRemoverFuncionrios.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRemoverFuncionrios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnRemoverFuncionrios.setBounds(333, 681, 293, 69);
		lista.getContentPane().add(btnRemoverFuncionrios);
		
		JButton btnModificarFuncionrios = new JButton("Modificar Funcion\u00E1rios");
		btnModificarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnModificarFuncionrios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnModificarFuncionrios.setBounds(636, 681, 293, 69);
		lista.getContentPane().add(btnModificarFuncionrios);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(939, 681, 293, 69);
		lista.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Sistema de Gerenciamento dos Funcion\u00E1rios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel.setBounds(285, 11, 693, 60);
		lista.getContentPane().add(lblNewLabel);
	}

	private void tabela() {
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nomes"}, 0);
		Object linha0[] = new Object[] {"ID", "Nome"};
		modelo.addRow(linha0);
		table.setModel(modelo);
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRender);;
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(1200);
		for (int i = 0; i < Lista.funcionarios.size(); i++) {
			Object linha[] = new Object[] {Lista.funcionarios.get(i).getID(), Lista.funcionarios.get(i).getNome()};
			modelo.addRow(linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
		lista.getContentPane().add(table);
	}
}
