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

public class StrategyAssalariado implements StrategyPagamentos {

	public void exportar(Funcionarios x, Object Linha[], DefaultTableModel modelo, JTable table) {
		Tempo tempo = new Tempo();
		if(tempo.DiadePagar(x.getDadosAssalariado().getPagamento())) {
			String tipo = " ", rodape = " ";
			float dado1 = x.getDadosAssalariado().getSalario()*x.getDadosAssalariado().getDias()/tempo.DiasUteisnoMes();
			float dado2 = x.getDadosAssalariado().getdescSind() + x.getDadosAssalariado().getAlicota();
			float salario = dado1 * (1 - dado2/100F) + x.getDadosAssalariado().getBonus() - x.getDadosAssalariado().getDiscExtra();
			if(x.isViaCorreios()) {
				tipo = "Correios";
				rodape = "******************** Dados de Envio *******************\nEndereço: " + x.getEndereco() + "    Nº: " + x.getNumeroCasa() +
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
				Recib.println("Extra: " + x.getDadosAssalariado().getBonus());
				Recib.println("Descontos (R$): " + x.getDadosAssalariado().getDiscExtra());
				Recib.println("Taxas (%): " + dado2);
				Recib.println("Salário Líquido (R$): " + salario);
				Recib.println("Presença: " + x.getDadosAssalariado().getDias() + "/" + tempo.DiasUteisnoMes());
				Recib.println("Data: " + tempo.DiadoMes() + "-" + tempo.Mes() + "-" + tempo.Ano());
				Recib.println(rodape);
				Recib.flush();
				Recib.close();
				recib.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			x.getDadosAssalariado().setBonus(0);
			x.getDadosAssalariado().setDias(0);
			if(x.getDadosAssalariado().getGrupo() < 4) x.getDadosAssalariado().setPagamento(tempo.UltimoDiaUtil());
			else x.getDadosAssalariado().setPagamento(LocalDate.now().plusDays(Lista.grupos.get(x.getDadosAssalariado().getGrupo() - 4).getIntervalo()));
			Linha = new Object[] {x.getNome(), x.getDadosAssalariado().getSalario(), x.getDadosAssalariado().getBonus(), x.getDadosAssalariado().getDiscExtra(),
								  dado2 + "%", salario, tipo, x.getDadosAssalariado().getDias()};
			modelo.addRow(Linha);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);
			table.setBounds(60, 101, 1144, 531);
		}
	}
}
