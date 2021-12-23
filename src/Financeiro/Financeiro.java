package Financeiro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Geral.Inicio;

public class Financeiro {
	Inicio ini = new Inicio();
	public JFrame listaFin;
	
	public Financeiro() {
		initialize();
	}
	public void initialize(){
		listaFin = new JFrame();
		listaFin.setBounds(0, 0, 854, 480);
		listaFin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaFin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema Financeiro dos Funcion\u00E1rios");
		lblNewLabel.setBounds(0, 11, 838, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		listaFin.getContentPane().add(lblNewLabel);
				
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(listaFin, "Você realmente quer sair?",
						"Sistema de Financeiro dos Funcionários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					ini.admin.setVisible(true);
					listaFin.dispose();
				}
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnFechar.setBounds(347, 363, 143, 57);
		listaFin.getContentPane().add(btnFechar);
		
		JButton btnGerarFolhasDe = new JButton("Gerar Folhas de hoje");
		btnGerarFolhasDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagamentosdeHoje lis = new PagamentosdeHoje();
				listaFin.dispose();
				lis.pagamentos.setVisible(true);
			}
		});
		btnGerarFolhasDe.setFont(new Font("Arial", Font.PLAIN, 25));
		btnGerarFolhasDe.setBounds(199, 295, 439, 57);
		listaFin.getContentPane().add(btnGerarFolhasDe);
		
		JButton btnGrupos = new JButton("Grupos e Datas");
		btnGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagamentos lis = new Pagamentos();
				listaFin.dispose();
				lis.pagamentos.setVisible(true);
			}
		});
		btnGrupos.setFont(new Font("Arial", Font.PLAIN, 25));
		btnGrupos.setBounds(199, 227, 439, 57);
		listaFin.getContentPane().add(btnGrupos);
		
		JButton btnModificaoSalarial = new JButton("Modifica\u00E7\u00E3o salarial global");
		btnModificaoSalarial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CGTela lis = new CGTela();
				lis.CGtela.setVisible(true);
			}
		});
		btnModificaoSalarial.setFont(new Font("Arial", Font.PLAIN, 25));
		btnModificaoSalarial.setBounds(199, 159, 439, 57);
		listaFin.getContentPane().add(btnModificaoSalarial);
		
		JButton btnLista = new JButton("Modifica\u00E7\u00F5es por tipo indiv\u00EDdual");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaFinanceiro lis = new ListaFinanceiro();
				listaFin.dispose();
				lis.lista.setVisible(true);
			}
		});
		btnLista.setFont(new Font("Arial", Font.PLAIN, 25));
		btnLista.setBounds(199, 91, 439, 57);
		listaFin.getContentPane().add(btnLista);
	}
}
