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

public class StrategyComissionado implements StrategyPagamentos {

	public void exportar(Funcionarios x, Object Linha[], DefaultTableModel modelo, JTable table) {
		Tempo tempo = new Tempo();
		if(tempo.DiadePagar(x.getDadosComissionado().getPagamento())) {
			String tipo = " ", rodape = " ";
			double dado1 = x.getDadosComissionado().getSalario()*(x.getDadosComissionado().getDias()/Math.floor(tempo.DiasUteisnoMes()/2));
			float dado2 = x.getDadosComissionado().getdescSind() + x.getDadosComissionado().getAlicota();
			float salario = (x.getDadosComissionado().getSalario()*x.getDadosComissionado().getDias()/(tempo.DiasUteisnoMes()/2))
	        				 * (1 - ((x.getDadosComissionado().getdescSind() + x.getDadosComissionado().getAlicota())/100F)) + 
	        				 x.getDadosComissionado().getBonus() - x.getDadosComissionado().getDiscExtra() +
	        				 x.getDadosComissionado().getVendas()*x.getDadosComissionado().getComissao()/100F;
			if(x.isViaCorreios()) {
				tipo = "Correios";
				rodape = "******************** Dados de Envio *******************\nEndereço: " + x.getEndereco() + "	Nº: " + x.getNumeroCasa() +
						 "\nCEP: " + x.getCep() + "\n***********************************************************************\n";
			}
			else if(x.isViaDeposito()) {
				tipo = "Depósito";
				rodape = "******************** Dados de Depósito *******************\nBanco: " + x.getBancarios().getBanco() + 
						 "\nAgência: " + x.getBancarios().getAgencia() + "\nOperação: " + x.getBancarios().getOperacao() + 
						 "\nConta: " + x.getBancarios().getConta() + "\n***********************************************************************";
			}
			else {
				tipo = "Em mãos";
				rodape = "***********************************************************************\n";
			}
			try {
				FileWriter recib = new FileWriter(Inicio.endereco + tipo + ".txt", true);
				PrintWriter Recib = new PrintWriter(recib);
				Recib.println("******************************** Dados ********************************");
				Recib.println("Nome: " + x.getNome());
				Recib.println("Salário: " + dado1);
				Recib.println("Extra: " + x.getDadosComissionado().getBonus());
				Recib.println("Descontos (R$): " + x.getDadosComissionado().getDiscExtra());
				Recib.println("Taxas (%): " + dado2);
				Recib.println("Salário Líquido (R$): " + salario);
				Recib.println("Presença: " + x.getDadosComissionado().getDias() + "/" + Math.floor(tempo.DiasUteisnoMes()/2));
				Recib.println("Data: " + tempo.DiadoMes() + "-" + tempo.Mes() + "-" + tempo.Ano());
				Recib.println(rodape);
				Recib.flush();
				Recib.close();
				recib.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			x.getDadosComissionado().setBonus(0);
			x.getDadosComissionado().setDias(0);
			x.getDadosComissionado().setDiscExtra(0);
			if(x.getDadosComissionado().getGrupo() < 4) x.getDadosComissionado().setPagamento(LocalDate.now().plusDays(14));
			else x.getDadosComissionado().setPagamento(LocalDate.now().plusDays(Lista.grupos.get(x.getDadosComissionado().getGrupo() - 4).getIntervalo()));
			Linha = new Object[] {x.getNome(), x.getDadosComissionado().getSalario(), x.getDadosComissionado().getBonus(), dado2/100F,
	      			  			  x.getDadosComissionado().getDiscExtra(), salario, tipo, x.getDadosComissionado().getDias()};
			modelo.addRow(Linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
	}
}
