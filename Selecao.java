package Programas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Selecao {
	public JFrame Funcionarios;
	
	public Selecao() {
		initialize();
	}
	public void initialize() {
		Funcionarios = new JFrame();
		Funcionarios.setBounds(0, 0, 854, 480);
		Funcionarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Funcionarios.getContentPane().setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cad = new Cadastro();
				Funcionarios.dispose();
				cad.Cadastrar.setVisible(true);
			}
		});
		btnCadastrar.setBounds(333, 126, 176, 56);
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 25));
		Funcionarios.getContentPane().add(btnCadastrar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(333, 187, 176, 56);
		btnDeletar.setFont(new Font("Arial", Font.PLAIN, 25));
		Funcionarios.getContentPane().add(btnDeletar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lista chama = new Lista();
				Funcionarios.dispose();
				chama.lista.setVisible(true);
			}
		});
		btnListar.setBounds(333, 248, 176, 56);
		btnListar.setFont(new Font("Arial", Font.PLAIN, 25));
		Funcionarios.getContentPane().add(btnListar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(333, 309, 176, 61);
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 25));
		Funcionarios.getContentPane().add(btnModificar);

		JLabel lblNewLabel = new JLabel("Funcion\u00E1rios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(246, 43, 349, 56);
		Funcionarios.getContentPane().add(lblNewLabel);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionarios.dispose();
				Inicio chama = new Inicio();
				chama.Inicia.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 25));
		btnVoltar.setBounds(333, 374, 176, 56);
		Funcionarios.getContentPane().add(btnVoltar);
	}
}
