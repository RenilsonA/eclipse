package Financeiro;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Geral.Inicio;
import Geral.Lista;
import Geral.Tempo;
import Ponto.ListaPonto;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.swing.JButton;

public class PagamentosdeHoje {
	public JFrame pagamentos;
	private JTable table;
	
	public PagamentosdeHoje() {
		Initialize();
	}
	
	public void Initialize() {
		pagamentos = new JFrame();
		pagamentos.setBounds(0, 0, 1280, 800);
		pagamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pagamentos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Pagamentos de Hoje");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(389, 11, 486, 49);
		pagamentos.getContentPane().add(lblNewLabel);
		
		JButton btnGerar = new JButton("Exportar Folhas");
		btnGerar.setFont(new Font("Arial", Font.PLAIN, 22));
		btnGerar.setBounds(446, 701, 189, 49);
		pagamentos.getContentPane().add(btnGerar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 22));
		btnVoltar.setBounds(645, 701, 189, 49);
		pagamentos.getContentPane().add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamentos.dispose();
				Financeiro f = new Financeiro();
				f.listaFin.setVisible(true);
			}
		});
		
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabela();
			}
		});
	}
	
	private void tabela() {
		pagamentos.dispose();
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome", "Salário", "Extra", "Descontos", "Taxas", "Líquido"}, 0);
		Object linha0[] = new Object[] {"Nome", "Salário", "Extra", "Descontos", "Taxas", "Líquido"};
		modelo.addRow(linha0);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(500);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(500);
		Tempo tempo = new Tempo();
		Listas listas = new Listas();
		Lista l = new Lista();
		for(int a = 0; a < Listas.assalariados.size(); a++) {
			if(LocalDate.now().equals(Listas.assalariados.get(a).getPagamento())) {
				float salario = (Listas.assalariados.get(a).getSalario()*ListaPonto.pontosAssalariados.get(a).getHorasNormais()/tempo.DiasUteisnoMes()) *
								 (1 -(Listas.assalariados.get(a).getDescontos()+ Listas.assalariados.get(a).getAlicota())/100F) +
								 Listas.assalariados.get(a).getBonus() - Listas.assalariados.get(a).getDiscExtra();
				if(Lista.funcionarios.get(l.posicao(Listas.assalariados.get(a).getID())).isViaCorreios())
					listas.recibosCorreios.add(new Recibos(Listas.assalariados.get(a).getID(), Listas.assalariados.get(a).getNome(), Listas.assalariados.get(a).getSalario()*
							  		   					   ListaPonto.pontosAssalariados.get(a).getHorasNormais()/tempo.DiasUteisnoMes(),
							  		   					   Listas.assalariados.get(a).getBonus(), Listas.assalariados.get(a).getDescontos() + Listas.assalariados.get(a).getAlicota(), 
							  		   					   Listas.assalariados.get(a).getDiscExtra(), salario));
				else if(Lista.funcionarios.get(l.posicao(Listas.assalariados.get(a).getID())).isViaDeposito())
					listas.recibosDeposito.add(new Recibos(Listas.assalariados.get(a).getID(), Listas.assalariados.get(a).getNome(), Listas.assalariados.get(a).getSalario()*
		   					   							   ListaPonto.pontosAssalariados.get(a).getHorasNormais()/tempo.DiasUteisnoMes(),
		   					   							   Listas.assalariados.get(a).getBonus(), Listas.assalariados.get(a).getDescontos() + Listas.assalariados.get(a).getAlicota(), 
		   					   							   Listas.assalariados.get(a).getDiscExtra(), salario));
				else listas.recibosMaos.add(new Recibos(Listas.assalariados.get(a).getID(), Listas.assalariados.get(a).getNome(), Listas.assalariados.get(a).getSalario()*
	   					   							    ListaPonto.pontosAssalariados.get(a).getHorasNormais()/tempo.DiasUteisnoMes(),
	   					   							    Listas.assalariados.get(a).getBonus(), Listas.assalariados.get(a).getDescontos() + Listas.assalariados.get(a).getAlicota(), 
	   					   							    Listas.assalariados.get(a).getDiscExtra(), salario));
				ListaPonto.pontosAssalariados.get(a).setHorasExtrasTotal(0);
				ListaPonto.pontosAssalariados.get(a).setHorasNormaisTotal(0);
			}
		}
		for(int a = 0; a < Listas.horistas.size(); a++) {
			if(LocalDate.now().equals(Listas.horistas.get(a).getPagamento())) {
				float salario = (Listas.horistas.get(a).getSalarioHora()*(ListaPonto.pontosHorista.get(a).getHorasNormaisTotal() + 
				        		ListaPonto.pontosHorista.get(a).getHorasExtrasTotal())/60) * 
				        		(1 - ((Listas.horistas.get(a).getDescontos() + Listas.horistas.get(a).getAlicota())/100F)) +
				        		Listas.horistas.get(a).getBonus() - Listas.horistas.get(a).getDiscExtra();
				if(Lista.funcionarios.get(l.posicao(Listas.horistas.get(a).getID())).isViaCorreios())
					listas.recibosCorreios.add(new Recibos(Listas.horistas.get(a).getID(), Listas.horistas.get(a).getNome(), Listas.horistas.get(a).getSalarioHora() *
		 					  							  (ListaPonto.pontosHorista.get(a).getHorasNormais() + ListaPonto.pontosHorista.get(a).getHorasExtrasTotal()),
		 					  							  Listas.horistas.get(a).getBonus(), Listas.horistas.get(a).getAlicota() + Listas.horistas.get(a).getDescontos(),
		 					  							  Listas.horistas.get(a).getDiscExtra(), salario));
				else if(Lista.funcionarios.get(l.posicao(Listas.horistas.get(a).getID())).isViaDeposito())
					listas.recibosDeposito.add(new Recibos(Listas.horistas.get(a).getID(), Listas.horistas.get(a).getNome(), Listas.horistas.get(a).getSalarioHora() *
		 					  							  (ListaPonto.pontosHorista.get(a).getHorasNormais() + ListaPonto.pontosHorista.get(a).getHorasExtrasTotal()),
		 					  							  Listas.horistas.get(a).getBonus(), Listas.horistas.get(a).getAlicota() + Listas.horistas.get(a).getDescontos(),
		 					  							  Listas.horistas.get(a).getDiscExtra(), salario));
				else listas.recibosMaos.add(new Recibos(Listas.horistas.get(a).getID(), Listas.horistas.get(a).getNome(), Listas.horistas.get(a).getSalarioHora() *
	 					  							   (ListaPonto.pontosHorista.get(a).getHorasNormais() + ListaPonto.pontosHorista.get(a).getHorasExtrasTotal()),
	 					  							   Listas.horistas.get(a).getBonus(), Listas.horistas.get(a).getAlicota() + Listas.horistas.get(a).getDescontos(),
	 					  							   Listas.horistas.get(a).getDiscExtra(), salario));
				ListaPonto.pontosHorista.get(a).setHorasExtrasTotal(0);
				ListaPonto.pontosHorista.get(a).setHorasNormaisTotal(0);
			}
		}
		for(int a = 0; a < Listas.comissionados.size(); a++) {
			if(LocalDate.now().equals(Listas.comissionados.get(a).getPagamento())) {
				float salario = (Listas.comissionados.get(a).getSalario()*ListaPonto.pontosComissionado.get(a).getHorasNormaisTotal()/(tempo.DiasUteisnoMes()/2))
				        		* (1 - ((Listas.comissionados.get(a).getDescontos() + Listas.comissionados.get(a).getAlicota())/100F)) + 
				        		Listas.comissionados.get(a).getBonus() - Listas.comissionados.get(a).getDiscExtra() +
				        		Listas.comissionados.get(a).getVendas()*Listas.comissionados.get(a).getComissao()/100F;
				if(Lista.funcionarios.get(l.posicao(Listas.comissionados.get(a).getID())).isViaCorreios())
					listas.recibosCorreios.add(new Recibos(Listas.comissionados.get(a).getID(), Listas.comissionados.get(a).getNome(), Listas.comissionados.get(a).getSalario()*
														   ListaPonto.pontosComissionado.get(a).getHorasNormais()/(tempo.DiasUteisnoMes()/2),
		 					  							   Listas.comissionados.get(a).getBonus(), Listas.comissionados.get(a).getAlicota() + 
		 					  							   Listas.comissionados.get(a).getDescontos(), Listas.comissionados.get(a).getDiscExtra(), salario));
				else if(Lista.funcionarios.get(l.posicao(Listas.comissionados.get(a).getID())).isViaDeposito())
					listas.recibosDeposito.add(new Recibos(Listas.comissionados.get(a).getID(), Listas.comissionados.get(a).getNome(), Listas.comissionados.get(a).getSalario()*
							   							   ListaPonto.pontosComissionado.get(a).getHorasNormais()/(tempo.DiasUteisnoMes()/2),
 							  							   Listas.comissionados.get(a).getBonus(), Listas.comissionados.get(a).getAlicota() + 
 							  							   Listas.comissionados.get(a).getDescontos(), Listas.comissionados.get(a).getDiscExtra(), salario));
				else listas.recibosMaos.add(new Recibos(Listas.comissionados.get(a).getID(), Listas.comissionados.get(a).getNome(), Listas.comissionados.get(a).getSalario()*
						   								ListaPonto.pontosComissionado.get(a).getHorasNormais()/(tempo.DiasUteisnoMes()/2),
							  							Listas.comissionados.get(a).getBonus(), Listas.comissionados.get(a).getAlicota() + 
							  							Listas.comissionados.get(a).getDescontos(), Listas.comissionados.get(a).getDiscExtra(), salario));				
				ListaPonto.pontosComissionado.get(a).setHorasExtrasTotal(0);
				ListaPonto.pontosComissionado.get(a).setHorasNormaisTotal(0);
			}
		}	
		for(int a = 0; a < listas.recibosDeposito.size(); a++) {
			Object linha[] = new Object[] {listas.recibosDeposito.get(a).getNome(), listas.recibosDeposito.get(a).getSalario(), listas.recibosDeposito.get(a).getExtra(),
								  listas.recibosDeposito.get(a).getTaxas(), listas.recibosDeposito.get(a).getDescontos(), listas.recibosDeposito.get(a).getLiquido()};		
			modelo.addRow(linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
		for(int a = 0; a < listas.recibosCorreios.size(); a++) {
			Object linha[] = new Object[] {listas.recibosCorreios.get(a).getNome(), listas.recibosCorreios.get(a).getSalario(), listas.recibosCorreios.get(a).getExtra(),
								  listas.recibosCorreios.get(a).getTaxas(), listas.recibosCorreios.get(a).getDescontos(), listas.recibosCorreios.get(a).getLiquido()};		
			modelo.addRow(linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
		for(int a = 0; a < listas.recibosMaos.size(); a++) {
			Object linha[] = new Object[] {listas.recibosMaos.get(a).getNome(), listas.recibosMaos.get(a).getSalario(), listas.recibosMaos.get(a).getExtra(),
								  listas.recibosMaos.get(a).getTaxas(), listas.recibosMaos.get(a).getDescontos(), listas.recibosMaos.get(a).getLiquido()};		
			modelo.addRow(linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
		Lista lista = new Lista();
		try {
			FileWriter recib = new FileWriter(Inicio.endereco + "FolhaCorreio.txt", false);
			PrintWriter Recib = new PrintWriter(recib);
			for(Recibos x : listas.recibosCorreios) {			
				Recib.println(x.getNome());
				Recib.println(x.getSalario());
				Recib.println(x.getExtra());
				Recib.println(x.getDescontos());
				Recib.println(x.getTaxas());
				Recib.println(x.getLiquido());
				Recib.println(tempo.DiadoMes() + "-" + tempo.Mes() + "-" + tempo.Ano());
				int f = lista.posicao(x.getID());
				Recib.println(Lista.funcionarios.get(f).getEndereco());
				Recib.println(Lista.funcionarios.get(f).getNumero());
				Recib.println(Lista.funcionarios.get(f).getCep());
				Recib.println();
			}
			Recib.flush();
			Recib.close();
			recib.close();
			
			FileWriter depo = new FileWriter(Inicio.endereco + "FolhaDeposito.txt", false);
			PrintWriter Depo = new PrintWriter(depo);
			for(Recibos x : listas.recibosDeposito) {			
				Depo.println(x.getNome());
				Depo.println(x.getSalario());
				Depo.println(x.getExtra());
				Depo.println(x.getDescontos());
				Depo.println(x.getTaxas());
				Depo.println(x.getLiquido());
				Depo.println(tempo.DiadoMes() + "-" + tempo.Mes() + "-" + tempo.Ano());
				int f = lista.posicao(x.getID());
				for(int a = 0; a < Listas.dadosBancarios.size(); a++) {
					if(Listas.dadosBancarios.get(a).getId() == x.getID()) {
						Depo.println(Listas.dadosBancarios.get(a).getBanco());
						Depo.println(Listas.dadosBancarios.get(a).getAgencia());
						Depo.println(Listas.dadosBancarios.get(a).getOperacao());
						Depo.println(Listas.dadosBancarios.get(a).getConta());
						a = Listas.dadosBancarios.size();
					}
				}
				Depo.println();
			}
			Depo.flush();
			Depo.close();
			depo.close();
			
			FileWriter maos = new FileWriter(Inicio.endereco + "FolhaMaos.txt", false);
			PrintWriter Maos = new PrintWriter(maos);
			for(Recibos x : listas.recibosMaos) {			
				Maos.println(x.getNome());
				Maos.println(x.getSalario());
				Maos.println(x.getExtra());
				Maos.println(x.getDescontos());
				Maos.println(x.getTaxas());
				Maos.println(x.getLiquido());
				Maos.println(tempo.DiadoMes() + "-" + tempo.Mes() + "-" + tempo.Ano());
				Maos.println();
			}
			Maos.flush();
			Maos.close();
			maos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		pagamentos.getContentPane().add(table);
		pagamentos.setVisible(true);
	}
}
