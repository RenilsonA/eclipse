package Financeiro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ClassesArray.Funcionarios;
import Geral.Inicio;
import Geral.Lista;
import Geral.Tempo;

public class StrategyHorista implements StrategyPagamentos {
	
	public void exportar(Funcionarios x, Object Linha[], DefaultTableModel modelo, JTable table) {
		Tempo tempo = new Tempo();	
		if (tempo.DiadePagar(x.getDadosHorista().getPagamento())) {
			String tipo = " ", rodape = " ";
			float dado1 = x.getDadosHorista().getSalarioHora()*(x.getDadosHorista().getHoras() + x.getDadosHorista().getHorasExtras()*1.5F);
			float dado2 = x.getDadosHorista().getdescSind() + x.getDadosHorista().getAlicota();
			float salario = dado1 * (1 - dado2/100F) + x.getDadosHorista().getBonus() - x.getDadosHorista().getDiscExtra();
			double presenca = x.getDadosHorista().getHoras() + x.getDadosHorista().getHorasExtras()*1.5;
			if(x.isViaCorreios()) {
				tipo = "Correios";
				rodape = "******************** Dados de Envio *******************\nEndere?o: " + x.getEndereco() + "    N?: " + x.getNumeroCasa() +
						 "\nCEP: " + x.getCep() + "\n***********************************************************************\n";
			}
			else if(x.isViaDeposito()) {
				tipo = "Dep?sito";
				rodape = "******************** Dados de Dep?sito *******************\nBanco: " + x.getBancarios().getBanco() + 
						 "\nAg?ncia: " + x.getBancarios().getAgencia() + "\nOpera??o: " + x.getBancarios().getOperacao() + 
						 "\nConta: " + x.getBancarios().getConta() + "\n***********************************************************************";
			}
			else {
				tipo = "Em m?os";
				rodape = "***********************************************************************\n";
			}
			try {
				FileWriter recib = new FileWriter(Inicio.endereco + tipo + ".txt", true);
				PrintWriter Recib = new PrintWriter(recib);
				Recib.println("******************************** Dados ********************************");
				Recib.println("Nome: " + x.getNome());
				Recib.println("Sal?rio: " + dado1);
				Recib.println("Extra: " + x.getDadosHorista().getBonus());
				Recib.println("Descontos (R$): " + x.getDadosHorista().getDiscExtra());
				Recib.println("Taxas (%): " + dado2);
				Recib.println("Sal?rio L?quido (R$): " + salario);
				Recib.println("Presen?a: " + presenca);
				Recib.println("Data: " + tempo.DiadoMes() + "-" + tempo.Mes() + "-" + tempo.Ano());
				Recib.println(rodape);
				Recib.flush();
				Recib.close();
				recib.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
													
			x.getDadosHorista().setBonus(0);
			x.getDadosHorista().setHoras(0);
			x.getDadosHorista().setHorasExtras(0);
			x.getDadosHorista().setDiscExtra(0);
			if(x.getDadosHorista().getGrupo() < 4) x.getDadosHorista().setPagamento(LocalDate.now().plusDays(7));
			else x.getDadosHorista().setPagamento(LocalDate.now().plusDays(Lista.grupos.get(x.getDadosHorista().getGrupo() - 4).getIntervalo()));
			Linha = new Object[] {x.getNome(), x.getDadosHorista().getSalarioHora(), x.getDadosHorista().getBonus(), dado2/100F,
				      			  x.getDadosHorista().getDiscExtra(), salario, tipo, presenca};
			modelo.addRow(Linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
	}
}
