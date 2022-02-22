package Financeiro;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class CSHorista {
	public JFrame CSHoristas;
	ListaFinanceiro l = new ListaFinanceiro();
	Funcoes f = new Funcoes();
	Lista li = new Lista();
	private JTextField Comissao;
	private JTextField SalarioHora;
	private JTextField Alicota;
	private JTextField descSind;
	private JTextField descExt;
	private JTextField textField;
	
	public CSHorista(int index) {
		Initialize(index);
	}

	public void Initialize(final int index) {		
		CSHoristas = new JFrame();
		CSHoristas.setBounds(0, 0, 640, 320);
		CSHoristas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CSHoristas.getContentPane().setLayout(null);
		
		final JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(204, 236, 105, 38);
		CSHoristas.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CSHoristas, "Você realmente deseja cancelar?",
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					CSHoristas.dispose();
				}
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(317, 236, 99, 38);
		CSHoristas.getContentPane().add(btnCancelar);
		
		Comissao = new JTextField();
		Comissao.setEnabled(false);
		Comissao.setHorizontalAlignment(SwingConstants.CENTER);
		Comissao.setFont(new Font("Arial", Font.PLAIN, 16));
		Comissao.setBounds(302, 126, 122, 20);
		CSHoristas.getContentPane().add(Comissao);
		Comissao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cadastro Financeiro Horista do ID " + Lista.funcionarios.get(index).getID());
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(119, 11, 386, 38);
		CSHoristas.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Extra");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(142, 126, 145, 20);
		CSHoristas.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sal\u00E1rio hora");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(142, 95, 85, 20);
		CSHoristas.getContentPane().add(lblNewLabel_1_2);
		
		SalarioHora = new JTextField();
		SalarioHora.setHorizontalAlignment(SwingConstants.CENTER);
		SalarioHora.setFont(new Font("Arial", Font.PLAIN, 16));
		SalarioHora.setColumns(10);
		SalarioHora.setBounds(302, 95, 122, 20);
		CSHoristas.getContentPane().add(SalarioHora);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(29, 160, 565, 65);
		CSHoristas.getContentPane().add(panel);
		panel.setLayout(null);
		
		descSind = new JTextField();
		descSind.setHorizontalAlignment(SwingConstants.CENTER);
		descSind.setBounds(271, 37, 122, 20);
		panel.add(descSind);
		descSind.setFont(new Font("Arial", Font.PLAIN, 16));
		descSind.setColumns(10);
		
		Alicota = new JTextField();
		Alicota.setHorizontalAlignment(SwingConstants.CENTER);
		Alicota.setBounds(120, 37, 122, 20);
		panel.add(Alicota);
		Alicota.setFont(new Font("Arial", Font.PLAIN, 16));
		Alicota.setColumns(10);
		
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
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Descontos : ");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(10, 12, 115, 19);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Al\u00EDcota (%):");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(120, 12, 122, 20);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Sindicato (%):");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1.setBounds(271, 11, 122, 20);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("Taxas (R$):");
		lblNewLabel_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1_1.setBounds(422, 11, 122, 20);
		panel.add(lblNewLabel_1_2_1_1_1_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Grupo");
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(143, 64, 85, 20);
		CSHoristas.getContentPane().add(lblNewLabel_1_2_2);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(300, 60, 277, 22);
		CSHoristas.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(457, 126, 122, 20);
		CSHoristas.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("+");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(434, 126, 36, 20);
		CSHoristas.getContentPane().add(lblNewLabel_1_1);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		comboBox.addItem("1 - Último dia útil do mês");
		comboBox.addItem("2 - Todas as sextas");
		comboBox.addItem("3 - Quizenalmente, as sextas");
		for(int a = 0; a < Lista.grupos.size(); a++) {
			comboBox.addItem(a + 4 + " - " + Lista.grupos.get(a).getNome());
		}
		comboBox.setSelectedIndex(Lista.funcionarios.get(index).getDadosHorista().getGrupo());
		
		Comissao.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				f.ApenasNumeros(e);
			}
		});
		SalarioHora.addKeyListener(new KeyAdapter() {
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
		
		descSind.setEditable(Lista.funcionarios.get(index).isSindicato());
		SalarioHora.setText(Float.toString(Lista.funcionarios.get(index).getDadosHorista().getSalarioHora()));
		Comissao.setText(Float.toString(Lista.funcionarios.get(index).getDadosHorista().getBonus()));
		Alicota.setText(Float.toString(Lista.funcionarios.get(index).getDadosHorista().getAlicota()));
		descSind.setText(Float.toString(Lista.funcionarios.get(index).getDadosHorista().getdescSind()));
		descExt.setText(Float.toString(Lista.funcionarios.get(index).getDadosHorista().getDiscExtra()));
		textField.setText("0.0");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CSHoristas, "Os dados estão corretos?",
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					if(comboBox.getSelectedIndex() > 0) {
						float extra = 0, Extra = 0;
						Lista.funcionarios.get(index).getDadosHorista().setGrupo(comboBox.getSelectedIndex());
						if(!descSind.getText().isEmpty()) Lista.funcionarios.get(index).getDadosHorista().setDiscExtra(Float.parseFloat(descSind.getText()));
						if(!Alicota.getText().isEmpty()) Lista.funcionarios.get(index).getDadosHorista().setAlicota(Float.parseFloat(Alicota.getText()));
						if(!descExt.getText().isEmpty()) Lista.funcionarios.get(index).getDadosHorista().setDiscExtra(Float.parseFloat(descExt.getText()));
						if(!Comissao.getText().isEmpty()) extra = Float.parseFloat(Comissao.getText());
						if(!textField.getText().isEmpty()) Extra = Float.parseFloat(textField.getText());
						Lista.funcionarios.get(index).getDadosHorista().setBonus(Extra + extra);
						if(!SalarioHora.getText().isEmpty()) Lista.funcionarios.get(index).getDadosHorista().setSalarioHora(Float.parseFloat(SalarioHora.getText()));
						Lista.funcionarios.get(index).getDadosHorista().setGrupo(comboBox.getSelectedIndex());
						Tempo t = new Tempo();
						if(comboBox.getSelectedIndex() > 3) Lista.funcionarios.get(index).getDadosHorista().setPagamento(Lista.grupos.get(comboBox.getSelectedIndex() - 4).getDia());
						else if(comboBox.getSelectedIndex() == 1) Lista.funcionarios.get(index).getDadosHorista().setPagamento(t.UltimoDiaUtil());
						else if(comboBox.getSelectedIndex() == 3) Lista.funcionarios.get(index).getDadosHorista().setPagamento(LocalDate.now().plusDays(14 - t.DiaemNumero() + 6));
						else Lista.funcionarios.get(index).getDadosHorista().setPagamento(LocalDate.now().plusDays(7 - t.DiaemNumero() + 6));
						CSHoristas.dispose();
						Lista listas = new Lista();
						try {
							listas.Salvar(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} 
			}
		});
	}
}
