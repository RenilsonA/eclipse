package Financeiro;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ClassesArray.Funcionarios;

interface StrategyPagamentos {
	
	public void exportar(Funcionarios funcionario, Object Linha[], DefaultTableModel modelo, JTable table);
	
}
