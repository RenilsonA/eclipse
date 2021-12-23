package Administrativo;

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
import javax.swing.JOptionPane;

public class Listar {
	public JFrame lista;
	private JTable table;
	Inicio inicio = new Inicio();
	
	public Listar() {
		Initialize();
	}

	public void Initialize() {
		lista = new JFrame();
		lista.setBounds(0, 0, 1280, 800);
		lista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista.getContentPane().setLayout(null);
		
		table = new JTable();
		
		JButton Adicionar = new JButton("Adicionar Funcion\u00E1rios");
		Adicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				lista.dispose();
				cadastro.Cadastrar.setVisible(true);
			}
		});
		Adicionar.setFont(new Font("Arial", Font.PLAIN, 25));
		Adicionar.setBounds(30, 681, 293, 69);
		lista.getContentPane().add(Adicionar);
		
		JButton btnRemoverFuncionrios = new JButton("Remover Funcion\u00E1rios");
		btnRemoverFuncionrios.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Remover remove = new Remover();
				lista.dispose();
				remove.Remocao.setVisible(true);
			}
		});
		btnRemoverFuncionrios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnRemoverFuncionrios.setBounds(333, 681, 293, 69);
		lista.getContentPane().add(btnRemoverFuncionrios);
		
		JButton btnModificarFuncionrios = new JButton("Modificar Funcion\u00E1rios");
		btnModificarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar modificar = new Modificar();
				lista.dispose();
				modificar.Modificacao.setVisible(true);
			}
		});
		btnModificarFuncionrios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnModificarFuncionrios.setBounds(636, 681, 293, 69);
		lista.getContentPane().add(btnModificarFuncionrios);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(lista, "Voc� realmente deseja sair da �rea administrativa?",
						"Sistema de gerenciamento dos Funcion�rios", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					lista.dispose();
					inicio.admin.setVisible(true);
				}
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(939, 681, 293, 69);
		lista.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Sistema de Gerenciamento dos Funcion\u00E1rios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel.setBounds(285, 11, 693, 60);
		lista.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Atualizar Lista");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(1048, 57, 176, 46);
		lista.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.dispose();
				table.remove(table);
				table.setBorder(new EmptyBorder(3, 3, 3, 3));
				DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nomes", "Endere�o", "Tipo"}, 0);
				Object linha0[] = new Object[] {"ID", "Nome", "Endere�o", "Tipo"};
				modelo.addRow(linha0);
				table.setModel(modelo);
				DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
				cellRender.setHorizontalAlignment(SwingConstants.CENTER);
				table.getColumnModel().getColumn(0).setCellRenderer(cellRender);;
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(600);
				table.getColumnModel().getColumn(2).setPreferredWidth(600);
				table.getColumnModel().getColumn(3).setPreferredWidth(500);
				for (int i = 0; i < Lista.funcionarios.size(); i++) {
					String tipo = "";
					if(Lista.funcionarios.get(i).isSalariado()) tipo = "Assalariado";
					else if(Lista.funcionarios.get(i).isHorista()) tipo = "Horista";
					else tipo = "Comissionado";
					Object linha[] = new Object[] {Lista.funcionarios.get(i).getID(), Lista.funcionarios.get(i).getNome(), Lista.funcionarios.get(i).getEndereco(), tipo};
					modelo.addRow(linha);
					table.setColumnSelectionAllowed(false);
					table.setCellSelectionEnabled(false);
					table.setBounds(60, 101, 1144, 531);
				}
				lista.getContentPane().add(table);
				lista.setVisible(true);
			}
		});
	}
}
