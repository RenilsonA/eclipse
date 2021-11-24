package Programas;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;


public class Lista {
	public JFrame lista;
	private JTable table;
	
	public Lista() {
		initialize();
	}
	public void initialize() {
		lista = new JFrame();
		lista.setBounds(0, 0, 854, 480);
		lista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nomes", "Atributo", "Remuneração"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(263);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(63, 101, 743, 208);
		lista.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(195, 66, 88, 24);
		lista.getContentPane().add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipo.setBounds(492, 66, 88, 24);
		lista.getContentPane().add(lblTipo);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSalrio.setBounds(681, 66, 88, 24);
		lista.getContentPane().add(lblSalrio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio chama = new Inicio();
				lista.dispose();
				chama.Inicia.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(635, 369, 193, 61);
		lista.getContentPane().add(btnVoltar);
		
		JLabel lblListaDeFuncionrios = new JLabel("Lista de Funcion\u00E1rios");
		lblListaDeFuncionrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeFuncionrios.setFont(new Font("Arial", Font.BOLD, 40));
		lblListaDeFuncionrios.setBounds(10, 8, 818, 47);
		lista.getContentPane().add(lblListaDeFuncionrios);

		
	}
}
