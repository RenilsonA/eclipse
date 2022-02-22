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

public class CSAssalariado {
	public JFrame CSAssalariados;
	ListaFinanceiro l = new ListaFinanceiro();
	Funcoes f = new Funcoes();
	Lista li = new Lista();
	private JTextField bonus;
	private JTextField SalarioBase;
	private JTextField Alicota;
	private JTextField descSind;
	private JTextField descExt;
	private JTextField textField;
	
	public CSAssalariado(int index) {
		Initialize(index);
	}

	public void Initialize(final int index) {		
		CSAssalariados = new JFrame();
		CSAssalariados.setBounds(0, 0, 640, 320);
		CSAssalariados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CSAssalariados.getContentPane().setLayout(null);
		
		final JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(204, 236, 105, 38);
		CSAssalariados.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CSAssalariados, "Você realmente deseja cancelar?",
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					CSAssalariados.dispose();
				}
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(317, 236, 99, 38);
		CSAssalariados.getContentPane().add(btnCancelar);
		
		bonus = new JTextField();
		bonus.setEnabled(false);
		bonus.setHorizontalAlignment(SwingConstants.CENTER);
		bonus.setFont(new Font("Arial", Font.PLAIN, 16));
		bonus.setBounds(300, 129, 122, 20);
		CSAssalariados.getContentPane().add(bonus);
		bonus.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cadastro Financeiro Assalariado do ID " + Lista.funcionarios.get(index).getID());
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(114, 11, 395, 38);
		CSAssalariados.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Extra");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(145, 129, 36, 20);
		CSAssalariados.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sal\u00E1rio base mensal");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(145, 97, 145, 20);
		CSAssalariados.getContentPane().add(lblNewLabel_1_2);
		
		SalarioBase = new JTextField();
		SalarioBase.setHorizontalAlignment(SwingConstants.CENTER);
		SalarioBase.setFont(new Font("Arial", Font.PLAIN, 16));
		SalarioBase.setColumns(10);
		SalarioBase.setBounds(300, 97, 122, 20);
		CSAssalariados.getContentPane().add(SalarioBase);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(28, 160, 565, 65);
		CSAssalariados.getContentPane().add(panel);
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
		lblNewLabel_1_2_1_1.setBounds(120, 10, 122, 20);
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
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Grupo");
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(145, 66, 85, 20);
		CSAssalariados.getContentPane().add(lblNewLabel_1_2_2);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(300, 60, 277, 22);
		CSAssalariados.getContentPane().add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecione uma das op\u00E7\u00F5es>"}));
		
		textField = new JTextField();
		textField.setText("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(455, 129, 122, 20);
		CSAssalariados.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("+");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(432, 129, 36, 20);
		CSAssalariados.getContentPane().add(lblNewLabel_1_1);
		comboBox.addItem("1 - Último dia útil do mês");
		comboBox.addItem("2 - Todas as sextas");
		comboBox.addItem("3 - Quizenalmente, as sextas");
		for(int a = 0; a < Lista.grupos.size(); a++) {
			comboBox.addItem(a + 4 + " - " + Lista.grupos.get(a).getNome());
		}
		comboBox.setSelectedIndex(Lista.funcionarios.get(index).getDadosAssalariado().getGrupo());
		
		bonus.addKeyListener(new KeyAdapter() {
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

		descSind.setEditable(Lista.funcionarios.get(index).isSindicato());
		SalarioBase.setText(Float.toString(Lista.funcionarios.get(index).getDadosAssalariado().getSalario()));
		Alicota.setText(Float.toString(Lista.funcionarios.get(index).getDadosAssalariado().getAlicota()));
		descSind.setText(Float.toString(Lista.funcionarios.get(index).getDadosAssalariado().getdescSind()));
		descExt.setText(Float.toString(Lista.funcionarios.get(index).getDadosAssalariado().getDiscExtra()));
		bonus.setText(Float.toString(Lista.funcionarios.get(index).getDadosAssalariado().getBonus()));
		textField.setText("0.0");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CSAssalariados, "Os dados estão corretos?",
						"Sistema finaceiro do Funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					if(comboBox.getSelectedIndex() > 0) {
						float extra = 0, Extra = 0;
						Lista.funcionarios.get(index).getDadosAssalariado().setGrupo(comboBox.getSelectedIndex());
						if(!descSind.getText().isEmpty()) Lista.funcionarios.get(index).getDadosAssalariado().setDiscExtra(Float.parseFloat(descSind.getText()));
						if(!Alicota.getText().isEmpty()) Lista.funcionarios.get(index).getDadosAssalariado().setAlicota(Float.parseFloat(Alicota.getText()));
						if(!descExt.getText().isEmpty()) Lista.funcionarios.get(index).getDadosAssalariado().setDiscExtra(Float.parseFloat(descExt.getText()));
						if(!SalarioBase.getText().isEmpty()) Lista.funcionarios.get(index).getDadosAssalariado().setSalario(Float.parseFloat(SalarioBase.getText()));
						if(!bonus.getText().isEmpty()) extra = Float.parseFloat(bonus.getText());
						if(!textField.getText().isEmpty()) Extra = Float.parseFloat(textField.getText());
						Lista.funcionarios.get(index).getDadosAssalariado().setBonus(Extra + extra);
						Tempo t = new Tempo();
						if(comboBox.getSelectedIndex() > 3) 
							Lista.funcionarios.get(index).getDadosAssalariado().setPagamento(Lista.grupos.get(comboBox.getSelectedIndex() - 4).getDia());
						else if(comboBox.getSelectedIndex() == 1) 
							Lista.funcionarios.get(index).getDadosAssalariado().setPagamento(t.UltimoDiaUtil());
						else if(comboBox.getSelectedIndex() == 3) 
							Lista.funcionarios.get(index).getDadosAssalariado().setPagamento(LocalDate.now().plusDays(14 - t.DiaemNumero() + 6));
						else Lista.funcionarios.get(index).getDadosAssalariado().setPagamento(LocalDate.now().plusDays(7 - t.DiaemNumero() + 6));
						CSAssalariados.dispose();
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
