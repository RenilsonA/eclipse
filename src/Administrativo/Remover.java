package Administrativo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Geral.Funcoes;
import Geral.Lista;
import UnRe.UnReFuncoes;

import javax.swing.JTextField;

public class Remover {
	public JFrame Remocao;
	private JTable table;
	Lista lista = new Lista();
	Listar inicio = new Listar();
	private JTextField RemocaodeID;
	
	public Remover() {
		Initialize();
	}

	public void Initialize() {
		Remocao = new JFrame();
		Remocao.setBounds(0, 0, 1280, 800);
		Remocao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Remocao.getContentPane().setLayout(null);
		
		tabela();
			
		JButton btnRemover = new JButton("Remover");
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
					inicio.lista.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnCancelar.setBounds(635, 689, 193, 61);
		Remocao.getContentPane().add(btnCancelar);
		
		RemocaodeID = new JTextField();
		RemocaodeID.setFont(new Font("Arial", Font.PLAIN, 15));
		RemocaodeID.setBounds(185, 658, 901, 20);
		Remocao.getContentPane().add(RemocaodeID);
		RemocaodeID.setColumns(10);
		RemocaodeID.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Funcoes funcoes = new Funcoes();
				funcoes.NumerosCEspaco(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("ID's a remover");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 658, 98, 20);
		Remocao.getContentPane().add(lblNewLabel);
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!RemocaodeID.getText().isEmpty()) {
					String f = RemocaodeID.getText() + ' ';
					for(int a = 0; a < f.length(); a++) {
						String x = "";
						while(Character.isDigit(f.charAt(a))) {
							x = x + f.charAt(a);
							a++;
						}
						int posicao = lista.posicao(Integer.parseInt(x));
						if(posicao >= 0) {
							if(JOptionPane.showConfirmDialog(Remocao, "Realmente deseja remover o funcionário?\nID: " + x + "\nNome: " + 
									Lista.funcionarios.get(posicao).getNome(), "Remover", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

								UnReFuncoes fun = new UnReFuncoes();
								fun.setVoltar(Lista.funcionarios.get(posicao), 2);
								lista.remover(posicao);							
								
							}
						}
					}
					if (!(JOptionPane.showConfirmDialog(Remocao, "Deseja Remover outros funcionários?", 
					    	"Remover novamente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)) {
						Remocao.dispose();
						inicio.lista.setVisible(true);
					}
					tabela();
				}
			}
		});
	}

	private void tabela() {
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		DefaultTableModel modelo = new DefaultTableModel(new Object[] { "ID", "Nomes", "Tipo"}, 0);
		Object linha0[] = new Object[] {"ID", "Nome", "Tipo"};
		modelo.addRow(linha0);
		table.setModel(modelo);
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(800);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		for (int i = 0; i < Lista.funcionarios.size(); i++) {
			String tipo = "";
			if(Lista.funcionarios.get(i).getTipo() == 0) tipo = "Assalariado";
			else if(Lista.funcionarios.get(i).getTipo() == 1) tipo = "Horista";
			else tipo = "Comissionado";
			Object linha[] = new Object[] {Lista.funcionarios.get(i).getID(), Lista.funcionarios.get(i).getNome(), tipo};
			modelo.addRow(linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
			Remocao.getContentPane().add(table);
		}
	}
}