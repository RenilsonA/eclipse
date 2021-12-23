package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Geral.Lista;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CadastoCorreios {
	public JFrame CCorreios;
	private JTextField endereco;
	private JTextField numero;
	private JTextField cep;
	private JTextField ID;
	
	public CadastoCorreios() {
		Initialize();
	}
	
	private void Initialize() {
		CCorreios = new JFrame();
		CCorreios.setBounds(0, 0, 640, 410);
		CCorreios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CCorreios.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Endere\u00E7o");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(203, 11, 218, 32);
		CCorreios.getContentPane().add(lblNewLabel);
		
		endereco = new JTextField();
		endereco.setFont(new Font("Arial", Font.PLAIN, 16));
		endereco.setBounds(144, 140, 383, 32);
		CCorreios.getContentPane().add(endereco);
		endereco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endere\u00E7o");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(42, 140, 134, 32);
		CCorreios.getContentPane().add(lblNewLabel_1);
		
		numero = new JTextField();
		numero.setFont(new Font("Arial", Font.PLAIN, 16));
		numero.setColumns(10);
		numero.setBounds(261, 183, 187, 32);
		CCorreios.getContentPane().add(numero);
		
		JLabel lblNewLabel_1_1 = new JLabel("N\u00FAmero");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(117, 183, 134, 32);
		CCorreios.getContentPane().add(lblNewLabel_1_1);
		
		cep = new JTextField();
		cep.setFont(new Font("Arial", Font.PLAIN, 16));
		cep.setColumns(10);
		cep.setBounds(261, 226, 187, 32);
		CCorreios.getContentPane().add(cep);
		
		JLabel lblNewLabel_1_2 = new JLabel("CEP");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(117, 226, 134, 32);
		CCorreios.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(172, 312, 126, 48);
		CCorreios.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCancelar.setBounds(308, 312, 126, 48);
		CCorreios.getContentPane().add(btnCancelar);
		
		JButton btnIr = new JButton("Ir");
		btnIr.setFont(new Font("Arial", Font.PLAIN, 16));
		btnIr.setBounds(535, 52, 77, 44);
		CCorreios.getContentPane().add(btnIr);
		
		ID = new JTextField();
		ID.setFont(new Font("Arial", Font.PLAIN, 16));
		ID.setEditable(false);
		ID.setColumns(10);
		ID.setBounds(525, 11, 89, 32);
		CCorreios.getContentPane().add(ID);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(10, 52, 515, 42);
		CCorreios.getContentPane().add(comboBox);
		for(int a = 0; a < Lista.funcionarios.size(); a++) {
			comboBox.addItem(Integer.toString(Listas.dadosBancarios.get(a).getId()));
		}
		
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() > 0) {
					int index = comboBox.getSelectedIndex() - 1;
					ID.setText(Integer.toString(Listas.dadosCorreios.get(index).getId()));
					endereco.setText(Listas.dadosCorreios.get(index).getEndereco()); 
					numero.setText(Integer.toString(Listas.dadosCorreios.get(index).getNumero())); 
					cep.setText(Listas.dadosCorreios.get(index).getCep());
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CCorreios, "Você realmente quer sair?",
						"Cadastro bancário dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					CCorreios.dispose();
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(CCorreios, "Os dados estão corretos?",
						"Cadastro bancário dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					int index = comboBox.getSelectedIndex() - 1;
					if(!endereco.getText().isEmpty()) Listas.dadosBancarios.get(index).setBanco(endereco.getText());
					if(!numero.getText().isEmpty()) Listas.dadosBancarios.get(index).setBanco(numero.getText());
					if(!cep.getText().isEmpty()) Listas.dadosBancarios.get(index).setBanco(cep.getText());
					CCorreios.dispose();
				}
			}
		});
	}
}
