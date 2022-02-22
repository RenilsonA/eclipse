package Financeiro;

public enum StrategyTipo {
	ASSALARIADO {
		public StrategyPagamentos exportar() {
			return new StrategyAssalariado();
		}
	},
	HORISTA {
		public StrategyPagamentos exportar() {
			return new StrategyHorista();
		}
	},
	COMISSIONADO {
		public StrategyPagamentos exportar() {
			return new StrategyComissionado();
		}
	};
	
	public abstract StrategyPagamentos exportar();
}
