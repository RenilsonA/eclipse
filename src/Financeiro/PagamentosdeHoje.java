package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import ClassesArray.Funcionarios;
import Geral.Lista;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class PagamentosdeHoje {
	public JFrame pagamentos;
	private JTable table;
	
	public PagamentosdeHoje() {
		Initialize();
	}
	
	public void Initialize() {
		pagamentos = new JFrame();
		pagamentos.setBounds(0, 0, 1280, 800);
		pagamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pagamentos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Pagamentos de Hoje");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(389, 11, 486, 49);
		pagamentos.getContentPane().add(lblNewLabel);
		
		JButton btnGerar = new JButton("Exportar Folhas");
		btnGerar.setFont(new Font("Arial", Font.PLAIN, 22));
		btnGerar.setBounds(446, 701, 189, 49);
		pagamentos.getContentPane().add(btnGerar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 22));
		btnVoltar.setBounds(645, 701, 189, 49);
		pagamentos.getContentPane().add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamentos.dispose();
				Financeiro f = new Financeiro();
				f.listaFin.setVisible(true);
			}
		});
		
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabela();
			}
		});
	}
	
	private void tabela() {
		pagamentos.dispose();
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome", "Salário", "Extra", "Descontos", "Taxas", "Líquido"}, 0);
		Object linha0[] = new Object[] {"Nome", "Salário", "Extra", "Descontos", "Taxas", "Líquido"};
		modelo.addRow(linha0);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(500);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(500);
		Object linha[] = null;
		for(Funcionarios x: Lista.funcionarios) {
			
			StrategyTipo ST = StrategyTipo.values()[x.getTipo()];
			StrategyPagamentos n = ST.exportar();
			n.exportar(x, linha, modelo, table);
			
		}
		pagamentos.getContentPane().add(table);
		pagamentos.setVisible(true);
	}
}
