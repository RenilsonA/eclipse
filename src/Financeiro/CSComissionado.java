package Financeiro;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import Geral.Funcoes;
import Geral.Lista;
import Geral.Tempo;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class CSComissionado {
	public JFrame CSComissionados;
	ListaFinanceiro l = new ListaFinanceiro();
	Funcoes f = new Funcoes();
	Listas list = new Listas();
	Lista li = new Lista();
	private JTextField Comissao;
	private JTextField SalarioBase;
	private JTextField Alicota;
	private JTextField descSind;
	private JTextField descExt;
	
	public CSComissionado(int index) {
		Initialize(index);
	}

	public void Initialize(final int index) {		
		CSComissionados = new JFrame();
		CSComissionados.setBounds(0, 0, 640, 350);
		CSComissionados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CSComissionados.getContentPane().setLayout(null);
		
		final JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(204, 262, 105, 38);
		CSComissionados.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CSComissionados, "Você realmente deseja cancelar?",
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					CSComissionados.dispose();
				}
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(317, 262, 99, 38);
		CSComissionados.getContentPane().add(btnCancelar);
		
		Comissao = new JTextField();
		Comissao.setHorizontalAlignment(SwingConstants.CENTER);
		Comissao.setFont(new Font("Arial", Font.PLAIN, 16));
		Comissao.setBounds(300, 93, 122, 20);
		CSComissionados.getContentPane().add(Comissao);
		Comissao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cadastro Financeiro Comissionado do ID " + Listas.comissionados.get(index).getID());
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(103, 11, 417, 38);
		CSComissionados.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Comiss\u00E3o por venda");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(140, 93, 145, 20);
		CSComissionados.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sal\u00E1rio base mensal");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(140, 124, 145, 20);
		CSComissionados.getContentPane().add(lblNewLabel_1_2);
		
		SalarioBase = new JTextField();
		SalarioBase.setHorizontalAlignment(SwingConstants.CENTER);
		SalarioBase.setFont(new Font("Arial", Font.PLAIN, 16));
		SalarioBase.setColumns(10);
		SalarioBase.setBounds(300, 124, 122, 20);
		CSComissionados.getContentPane().add(SalarioBase);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(27, 167, 565, 65);
		CSComissionados.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Descontos : ");
		lblNewLabel_1_2_1.setBounds(10, 11, 115, 19);
		panel.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		descSind = new JTextField();
		descSind.setHorizontalAlignment(SwingConstants.CENTER);
		descSind.setBounds(271, 37, 122, 20);
		panel.add(descSind);
		descSind.setFont(new Font("Arial", Font.PLAIN, 16));
		descSind.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Sindicato (%):");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setBounds(271, 10, 122, 20);
		panel.add(lblNewLabel_1_2_1_1_1);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		Alicota = new JTextField();
		Alicota.setHorizontalAlignment(SwingConstants.CENTER);
		Alicota.setBounds(120, 37, 122, 20);
		panel.add(Alicota);
		Alicota.setFont(new Font("Arial", Font.PLAIN, 16));
		Alicota.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Al\u00EDcota (%):");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setBounds(120, 11, 122, 20);
		panel.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2_1_1_2 = new JLabel("+");
		lblNewLabel_1_2_1_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_2.setBounds(252, 37, 20, 20);
		panel.add(lblNewLabel_1_2_1_1_2);
		
		descExt = new JTextField();
		descExt.setHorizontalAlignment(SwingConstants.CENTER);
		descExt.setFont(new Font("Arial", Font.PLAIN, 16));
		descExt.setColumns(10);
		descExt.setBounds(422, 37, 122, 20);
		panel.add(descExt);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Taxas (R$):");
		lblNewLabel_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1_1.setBounds(422, 10, 122, 20);
		panel.add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Grupo");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(140, 62, 145, 20);
		CSComissionados.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("(%)");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(432, 93, 145, 20);
		CSComissionados.getContentPane().add(lblNewLabel_1_3);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(300, 60, 277, 22);
		CSComissionados.getContentPane().add(comboBox);
		
		Comissao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		SalarioBase.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		Alicota.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		descSind.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		descExt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		
		SalarioBase.setText(Float.toString(Listas.comissionados.get(index).getSalario()));
		Comissao.setText(Float.toString(Listas.comissionados.get(index).getComissao()));
		Alicota.setText(Float.toString(Listas.comissionados.get(index).getAlicota()));
		descSind.setText(Float.toString(Listas.comissionados.get(index).getDiscExtra()));
		descExt.setText(Float.toString(Listas.comissionados.get(index).getDescontos()));
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		comboBox.addItem("1 - Último dia útil do mês");
		comboBox.addItem("2 - Todas as sextas");
		comboBox.addItem("3 - Quizenalmente, as sextas");
		for(int a = 0; a < Lista.grupos.size(); a++) {
			comboBox.addItem(a + 4 + " - " + Lista.grupos.get(a).getNome());
		}
		comboBox.setSelectedIndex(Listas.comissionados.get(index).getGrupo());
		
		descSind.setEditable(Lista.funcionarios.get(li.posicao(Listas.comissionados.get(index).getID())).isSindicato());
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CSComissionados, "Os dados estão corretos?",
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					if(comboBox.getSelectedIndex() > 0) {
						Lista.funcionarios.get(li.posicao(Listas.comissionados.get(index).getID())).setGrupo(comboBox.getSelectedIndex());
						if(!descSind.getText().isEmpty()) 
							Listas.comissionados.get(index).setDiscExtra(Float.parseFloat(descSind.getText()));
						if(!Alicota.getText().isEmpty()) 
							Listas.comissionados.get(index).setAlicota(Float.parseFloat(Alicota.getText()));
						if(!descExt.getText().isEmpty() && Lista.funcionarios.get(li.posicao(Listas.comissionados.get(index).getID())).isSindicato()) 
							Listas.comissionados.get(index).setDescontos(Float.parseFloat(descExt.getText()));
						if(!Comissao.getText().isEmpty())
							Listas.comissionados.get(index).setComissao(Float.parseFloat(Comissao.getText()));
						
						if(!SalarioBase.getText().isEmpty())
							Listas.comissionados.get(index).setSalario(Float.parseFloat(SalarioBase.getText()));
						Listas.comissionados.get(index).setGrupo(comboBox.getSelectedIndex());
						Tempo t = new Tempo();
						if(comboBox.getSelectedIndex() > 3) Listas.comissionados.get(index).setPagamento(Lista.grupos.get(comboBox.getSelectedIndex() - 4).getDia());
						else if(comboBox.getSelectedIndex() == 1) Listas.comissionados.get(index).setPagamento(t.UltimoDiaUtil());
						else if(comboBox.getSelectedIndex() == 3) Listas.comissionados.get(index).setPagamento(LocalDate.now().plusDays(14 - t.DiaemNumero() + 6));
						else Listas.comissionados.get(index).setPagamento(LocalDate.now().plusDays(7 - t.DiaemNumero() + 6));
						Lista l = new Lista();
						Lista.funcionarios.get(l.posicao(Listas.comissionados.get(index).getID())).setGrupo(comboBox.getSelectedIndex());
						Listas.comissionados.get(index).setGrupo(comboBox.getSelectedIndex());
						Lista.funcionarios.get(l.posicao(Listas.comissionados.get(index).getID())).setGrupo(comboBox.getSelectedIndex());
						CSComissionados.dispose();
						try {
							list.SalvarHorista(true);
							list.SalvarAssalariado(true);
							list.SalvarComissionado(true);
							list.SalvarBancarios(true);
							list.SalvarCorreios(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} 
			}
		});
	}
}
