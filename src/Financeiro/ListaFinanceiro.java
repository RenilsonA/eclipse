package Financeiro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListaFinanceiro {
	public JFrame lista;
	Financeiro fin = new Financeiro();
	
	public ListaFinanceiro() {
		Initialize();
	}

	public void Initialize() {
		lista = new JFrame();
		lista.setBounds(0, 0, 854, 560);
		lista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista.getContentPane().setLayout(null);
		
		JButton btnAssalariados = new JButton("Listar assalariados");
		btnAssalariados.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ListarAssalariados l = new ListarAssalariados();
				lista.dispose();
				l.listaAssalariados.setVisible(true);
			}
		});
		btnAssalariados.setFont(new Font("Arial", Font.PLAIN, 25));
		btnAssalariados.setBounds(273, 201, 293, 69);
		lista.getContentPane().add(btnAssalariados);
		
		JButton btnHoristas = new JButton("Listar horistas");
		btnHoristas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ListarHoristas l = new ListarHoristas();
				lista.dispose();
				l.listaHoristas.setVisible(true);
			}
		});
		btnHoristas.setFont(new Font("Arial", Font.PLAIN, 25));
		btnHoristas.setBounds(273, 361, 293, 69);
		lista.getContentPane().add(btnHoristas);
		
		JButton btnComissionados = new JButton("Listar comissionados");
		btnComissionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarComissionados l = new ListarComissionados();
				lista.dispose();
				l.listaComissionados.setVisible(true);
			}
		});
		btnComissionados.setFont(new Font("Arial", Font.PLAIN, 25));
		btnComissionados.setBounds(273, 281, 293, 69);
		lista.getContentPane().add(btnComissionados);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.dispose();
				fin.listaFin.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(273, 441, 293, 69);
		lista.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Sistema financeiro dos Funcion\u00E1rios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		lblNewLabel.setBounds(137, 11, 564, 60);
		lista.getContentPane().add(lblNewLabel);
		
		JButton btnModificarDadosBancarios = new JButton("Modificar dados bancarios");
		btnModificarDadosBancarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroBancario c = new CadastroBancario();
				c.CBancario.setVisible(true);
			}
		});
		btnModificarDadosBancarios.setFont(new Font("Arial", Font.PLAIN, 25));
		btnModificarDadosBancarios.setBounds(228, 121, 382, 69);
		lista.getContentPane().add(btnModificarDadosBancarios);
	}
}
