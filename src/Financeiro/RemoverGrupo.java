package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Geral.Lista;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class RemoverGrupo {
	public JFrame removerGrupo;
	
	public RemoverGrupo() {
		Initialize();
	}
	
	public void Initialize() {
		removerGrupo = new JFrame();
		removerGrupo.setBounds(0, 0, 680, 380);
		removerGrupo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		removerGrupo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remover grupo");
		lblNewLabel.setBounds(225, 11, 214, 49);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		removerGrupo.getContentPane().add(lblNewLabel);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(136, 281, 189, 49);
		btnRemover.setFont(new Font("Arial", Font.PLAIN, 22));
		removerGrupo.getContentPane().add(btnRemover);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(338, 281, 189, 49);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerGrupo.dispose();
				Pagamentos p = new Pagamentos();
				p.pagamentos.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 22));
		removerGrupo.getContentPane().add(btnVoltar);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 22));
		comboBox.setBounds(153, 139, 343, 38);
		removerGrupo.getContentPane().add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"0 - Selecione uma das opções:"}));
		for(int a = 0; a < Lista.grupos.size(); a++) {
			comboBox.addItem(a + 1 + " - " + Lista.grupos.get(a).getNome());
		}
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(removerGrupo, "Deletar o grupo de pagamento " + comboBox.getSelectedItem(),
						"Sistema Financeiro dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					for(int a = 0; a < Lista.funcionarios.size(); a++) {
						if(Lista.funcionarios.get(a).getTipo() == 0 && 
						   Lista.funcionarios.get(a).getDadosAssalariado().getGrupo() == comboBox.getSelectedIndex() + 3) {
							Lista.funcionarios.get(a).getDadosAssalariado().setGrupo(1);
						}
						else if(Lista.funcionarios.get(a).getTipo() == 1 &&
								Lista.funcionarios.get(a).getDadosHorista().getGrupo() == comboBox.getSelectedIndex() + 3) {
							Lista.funcionarios.get(a).getDadosHorista().setGrupo(2);
						}
						else if(Lista.funcionarios.get(a).getTipo() == 2 &&
								Lista.funcionarios.get(a).getDadosComissionado().getGrupo() == comboBox.getSelectedIndex() + 3) {
							Lista.funcionarios.get(a).getDadosComissionado().setGrupo(3);
						}
					}
					Lista.grupos.remove(comboBox.getSelectedIndex() - 1);
					Lista.setQuantGrupos(Lista.grupos.size());
					Lista listas = new Lista();
					try {
						listas.Salvar(true);
						listas.SalvarGrupo();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					removerGrupo.dispose();
					Pagamentos p = new Pagamentos();
					p.pagamentos.setVisible(true);
				}
			}
		});
	}
}
