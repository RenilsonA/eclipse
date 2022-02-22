package UnRe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Confirmação {
	
	public JFrame frame;
	private JTextField RefazerMax;
	private JTextField DesfazerMax;
	
	public Confirmação() {
		frame = new JFrame();
		frame.setBounds(0, 0, 480, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Texto = new JLabel();
		Texto.setHorizontalAlignment(SwingConstants.CENTER);
		Texto.setFont(new Font("Arial", Font.PLAIN, 20));
		Texto.setBounds(10, 40, 264, 31);
		frame.getContentPane().add(Texto);
		
		JButton btnRefazer = new JButton("Refazer");
		btnRefazer.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRefazer.setBounds(162, 98, 139, 48);
		frame.getContentPane().add(btnRefazer);
		
		JButton btnDesfazer = new JButton("Desfazer");
		btnDesfazer.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDesfazer.setBounds(162, 157, 139, 48);
		frame.getContentPane().add(btnDesfazer);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVoltar.setBounds(162, 216, 139, 48);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Desfazer/Refazer a\u00E7\u00E3o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 444, 48);
		frame.getContentPane().add(lblNewLabel);
		
		RefazerMax = new JTextField();
		RefazerMax.setHorizontalAlignment(SwingConstants.CENTER);
		RefazerMax.setFont(new Font("Arial", Font.PLAIN, 25));
		RefazerMax.setEnabled(false);
		RefazerMax.setBounds(311, 98, 67, 48);
		frame.getContentPane().add(RefazerMax);
		RefazerMax.setColumns(10);
		
		DesfazerMax = new JTextField();
		DesfazerMax.setHorizontalAlignment(SwingConstants.CENTER);
		DesfazerMax.setFont(new Font("Arial", Font.PLAIN, 25));
		DesfazerMax.setEnabled(false);
		DesfazerMax.setColumns(10);
		DesfazerMax.setBounds(311, 157, 67, 48);
		frame.getContentPane().add(DesfazerMax);
		
		final UnReFuncoes u = new UnReFuncoes();
		int x = u.TamanhoVoltar();
		int y = u.TamanhoIr();
		RefazerMax.setText(Integer.toString(x));
		DesfazerMax.setText(Integer.toString(y));
		
		btnRefazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u.FuncoesVoltar();
				int x = u.TamanhoVoltar();
				int y = u.TamanhoIr();
				RefazerMax.setText(Integer.toString(x));
				DesfazerMax.setText(Integer.toString(y));
			}
		});
		
		btnDesfazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u.FuncoesIr();
				int x = u.TamanhoVoltar();
				int y = u.TamanhoIr();
				RefazerMax.setText(Integer.toString(x));
				DesfazerMax.setText(Integer.toString(y));
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
	}
}
