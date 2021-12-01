package Programas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;

public class Remover {
	public JFrame Remocao;
	private JTable table;
	Inicio inicio = new Inicio();
	
	public Remover() {
		Initialize();
	}

	public void Initialize() {
		Remocao = new JFrame();
		Remocao.setBounds(0, 0, 1280, 800);
		Remocao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Remocao.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		Inicio.lista.printa();
		int x = 117;
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nomes"}, 0);
		Object linha0[] = new Object[] {"ID", "Nome"};
		modelo.addRow(linha0);
		for (int i = 0; i < Inicio.lista.funcionarios.size(); i++) {
			Object linha[] = new Object[] {Inicio.lista.funcionarios.get(i).getID(), Inicio.lista.funcionarios.get(i).getNome()};
			modelo.addRow(linha);
			JCheckBox chckbxNewCheckBox = new JCheckBox("");
			chckbxNewCheckBox.setBounds(39, x, 21, 15);
			Remocao.getContentPane().add(chckbxNewCheckBox);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
			Remocao.getContentPane().add(table);
			x = x + 16;
		}
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
				
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remocao.dispose();
				inicio.Inicia.setVisible(true);
			}
		});
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 25));
		btnRemover.setBounds(432, 689, 193, 61);
		Remocao.getContentPane().add(btnRemover);
		
		JLabel lblListaDeFuncionrios = new JLabel("Remover funcion\u00E1rios");
		lblListaDeFuncionrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeFuncionrios.setFont(new Font("Arial", Font.BOLD, 40));
		lblListaDeFuncionrios.setBounds(223, 8, 818, 47);
		Remocao.getContentPane().add(lblListaDeFuncionrios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remocao.dispose();
				inicio.Inicia.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnCancelar.setBounds(635, 689, 193, 61);
		Remocao.getContentPane().add(btnCancelar);

	}
}
